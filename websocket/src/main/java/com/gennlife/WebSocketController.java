/**
 * copyRight
 */
package com.gennlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.core.MessagePostProcessor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageHeaderInitializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.ServerEndpoint;
import java.security.Principal;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/11/26
 * Time: 14:06
 */

@Controller
@RequestMapping("/socket")
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate template;
    //@Scheduled(fixedRate = 1000)
    public void sendTopicMessage() {
        System.out.println("后台广播推送！");
        User user=new User();
        user.setUserName("后台广播推送！");
        user.setAge(10);
        user.setId("1000001");
        this.template.convertAndSend("/topic/getResponse",user);
    }
    //一对一推送消息
    //@Scheduled(fixedRate = 1000)
    public void sendQueueMessage() {
        System.out.println("后台一对一推送！");
        User user=new User();
        user.setId("1000002");
        user.setUserName("后台点对点");
        user.setAge(10);
        this.template.convertAndSendToUser(user.getId()+"","/user/getResponse",user);
    }
    @RequestMapping("/meaage")
    @ResponseBody
    public String receivedMesssage(User user){
        /*User user=new User();
        user.setId(userId);
        user.setUserName(sendMessage);
        user.setAge(10);*/
        this.template.convertAndSendToUser(user.getId()+"","/user/qqqq/dd/ddd",user);
        return "success";
    }

    /**
     * 必须有{userId} web端推送消息时，服务端收到消息才不会报错
     * @param user
     * @return
     */
    @MessageMapping("/{userId}/test")
    @ResponseBody
    public String received(@PathVariable String userId, User user,MessageHeaders headers){
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        this.template.convertAndSendToUser(user.getId(),"/qqqq/dd/ddd",user);
        return "success";
    }

    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }
}
