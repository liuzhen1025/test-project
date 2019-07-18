package com.gennlife;

import com.gennlife.domain.TOrder0;
import com.gennlife.service.BaseService;
import com.gennlife.service.TOrder0Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuzhen278
 * @title: BaseServiceTest
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/1717:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class BaseServiceTest {
    @Autowired
    private TOrder0Service order0Service;
    @Test
    public void testCommon(){
        System.out.println("success");
    }
    @Test
    public void testInsert(){
        TOrder0 order = new TOrder0();
        order.setUserId(2L);
        order.setOrderId(1L);
        int insert = order0Service.insert(order);
        System.out.println(insert);
    }
    @Test
    public void testInsertSelective(){
        TOrder0 order = new TOrder0();
        order.setUserId(2L);
        order.setOrderId(3L);
        order.setGoodsName("test insert selective");
        int insert = order0Service.insertSelective(order);
        System.out.println(insert);
    }
    //@Transactional
    @Test
    public void testInsertSelectiveTs(){
        TOrder0 order = new TOrder0();
        order.setUserId(2L);
        order.setOrderId(17L);
        order.setGoodsName("test insert selective");
        int insert = order0Service.insertSelective(order);

        System.out.println(insert);
    }
}
