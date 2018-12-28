package com.gennlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * https://www.cnblogs.com/tinyj/p/9797807.html
 */
@SpringBootApplication
@EnableWebSocket
@EnableScheduling
public class WebsocketApplication {
	/**https://gitee.com/anoyi/anyim*/
	public static void main(String[] args) {
		SpringApplication.run(WebsocketApplication.class, args);

	}

}
