/**
 * copyRight
 */
package com.gennlife;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

/**
 * @author liuzhen
 *         Created by liuzhen.
 *         Date: 2018/11/23
 *         Time: 18:05
 */
@Configuration
@EnableWebSocketMessageBroker
@Slf4j
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    //STOMP监听类
    /*@Bean
    public STOMPConnectEventListener applicationStartListener(){
        return new STOMPConnectEventListener();
    }*/
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //建立连接端点，注册一个STOMP的协议节点,并指定使用SockJS协议
        stompEndpointRegistry.addEndpoint("/nmpSocketWeb")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
        //配置消息代理（MessageBroker）。
        messageBrokerRegistry.enableSimpleBroker("/topic", "/user");// 推送消息前缀
        messageBrokerRegistry.setUserDestinationPrefix("/user");
        messageBrokerRegistry.setApplicationDestinationPrefixes("/user");// 应用请求前缀，前端发过来的消息将会带有“/app”前缀。
    }

    /*@Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {

        registration.addDecoratorFactory(new WebSocketHandlerDecoratorFactory() {
            @Override
            public WebSocketHandler decorate(final WebSocketHandler handler) {

                return new WebSocketHandlerDecorator(handler) {
                    @Override
                    public void afterConnectionEstablished(final WebSocketSession session) throws Exception {
                        // 客户端与服务器端建立连接后，此处记录谁上线了
                        Object username = session.getAttributes().get("oauth");//.getPrincipal().getName();
                        log.info("online: " + username);
                        super.afterConnectionEstablished(session);
                    }

                    @Override
                    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
                        // 客户端与服务器端断开连接后，此处记录谁下线了
                        String username = session.getPrincipal().getName();
                        log.info("offline: " + username);
                        super.afterConnectionClosed(session, closeStatus);
                    }
                };
            }
        });
//        super.configureWebSocketTransport(registration);

    }*/
    /*@Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        //token认证
        registration.setInterceptors(new ChannelInterceptorAdapter() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                if (StompCommand.CONNECT.equals(accessor.getCommand()) || StompCommand.SEND.equals(accessor.getCommand())) {
                    String token = accessor.getFirstNativeHeader("token");
                    try {
                        tokenValidate(token);
                    } catch (Exception e) {
                        log.error(e.toString());
                        return null;
                    }
                }
                return message;
            }
        });
    }*/
    /*public boolean tokenValidate(String token) throws Exception {
        *//*if (token == null || token.isEmpty()) {
            throw new Exception("webSocket：token为空！");
        }*//*
        *//*if (JwtUtil.validateToken(token)==null) {
            throw new Exception("webSoc：token无效！");
        }*//*
        return true;
    }*/
}
