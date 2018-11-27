/**
 * copyRight
 */
package com.gennlife;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/11/26
 * Time: 10:48
 */
//@Component
public class MessagingTemplate extends SimpMessagingTemplate {

    public MessagingTemplate(MessageChannel messageChannel) {
        super(messageChannel);
    }
}
