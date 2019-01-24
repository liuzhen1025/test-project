/**
 * copyRight
 */
package com.gennlife;

import org.springframework.context.ApplicationEvent;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/1/24
 * Time: 14:40
 */
public class MessageEvent extends ApplicationEvent {

    /** 事件的内容（具有实际业务意义的内容） */
    private String eventContent;
    public MessageEvent(Object source) {
        super(source);
    }

    public MessageEvent(Object source, String eventContent) {
        super(source);
        this.eventContent = eventContent;
    }

    public String getEventContent() {

        return eventContent;
    }

    public void setEventContent(String eventContent) {

        this.eventContent = eventContent;
    }
}
