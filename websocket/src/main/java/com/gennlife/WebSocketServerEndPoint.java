/**
 * copyRight
 */
package com.gennlife;

import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/1/25
 * Time: 15:24
 */
@ServerEndpoint(value = "/test", configurator = WebSocketConfig1.class)
@Component
public class WebSocketServerEndPoint {
    @OnMessage
    public void save(String user){

        System.out.println(user);
    }

}
