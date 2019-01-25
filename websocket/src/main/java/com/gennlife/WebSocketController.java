/**
 * copyRight
 */
package com.gennlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.core.MessagePostProcessor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.ServerEndpoint;

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
    @MessageMapping("/test")
    @ResponseBody
    public String received(User user){
        this.template.convertAndSendToUser(user.getId()+"","/user/qqqq/dd/ddd",user);
        return "success";
    }
}
