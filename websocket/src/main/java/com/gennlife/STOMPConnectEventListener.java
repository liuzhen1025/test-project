/**
 * copyRight
 */
package com.gennlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import java.util.List;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/11/26
 * Time: 10:12
 */
public class STOMPConnectEventListener implements ApplicationListener<SessionConnectEvent> {
    @Autowired
    private ApplicationContext context;
    @Override
    public void onApplicationEvent(SessionConnectEvent sessionConnectEvent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sessionConnectEvent.getMessage());
        //login get from browser
        List<String> oauth = sha.getNativeHeader("oauth");
        StompCommand command = sha.getCommand();
        if(oauth == null || oauth.isEmpty() || command == null){
            return;
        }
        String name = command.getMessageType().name();
        String id = oauth.get(0);
        MessageEvent event = new MessageEvent(this);
        event.setEventContent(id);
        context.publishEvent(event);
    }
}
