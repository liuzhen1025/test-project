/**
 * copyRight
 */
package com.gennlife;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2019/1/24
 * Time: 14:43
 */
@Component
public class ContainerEventListener implements BeanNameAware {
    //@Async注解指定该事件异步执行，必须配合启动类的@EnableAsync
    @Autowired
    private SimpMessagingTemplate template;
    private String beanName;
    @Async
    @EventListener
    public void handleBatchSendExMsgEmailEvent(MessageEvent event) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user=new User();
        String id = event.getEventContent();
        user.setId(id);
        user.setUserName("登陆了");
        user.setMessage("用户 【"+id+"】登陆了");
        user.setAge(10);
        this.template.convertAndSendToUser(user.getId()+"","/qqqq/dd/ddd",user);

    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }
}
