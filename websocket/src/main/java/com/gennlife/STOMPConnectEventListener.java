/**
 * copyRight
 */
package com.gennlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.web.socket.messaging.SessionConnectEvent;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/11/26
 * Time: 10:12
 */
public class STOMPConnectEventListener implements ApplicationListener<SessionConnectEvent> {
    @Autowired
    private RedisHelper redisHelper;
    @Override
    public void onApplicationEvent(SessionConnectEvent sessionConnectEvent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sessionConnectEvent.getMessage());
        //login get from browser
        if(sha.getNativeHeader("userid")==null){
            return;
        }
        String userid = sha.getNativeHeader("userid").get(0);
        String sessionId = sha.getSessionId();
        redisHelper.put("sessionKey", "websocket:"+userid,sessionId);
    }
}
