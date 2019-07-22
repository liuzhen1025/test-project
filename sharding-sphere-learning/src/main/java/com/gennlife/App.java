package com.gennlife;


import com.gennlife.dao.TOrder0Mapper;
import com.gennlife.domain.TOrder0;
import com.gennlife.service.TOrder0Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import tk.mybatis.mapper.entity.Example;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 腾讯内容安全接口封装框架
 * 【https://gitee.com/xshuai/taip 】
 * 百度AI大脑
 * 【http://ai.baidu.com/solution/censoring?track=cp:ainsem|pf:pc|pp:chanpin-neirongshenhe|pu:neirongshenhe|ci:|kw:10001733】
 *
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        TOrder0Service orderService = (TOrder0Service)context.getBean("order0Service");
        TOrder0Mapper TOrder0Mapper = (TOrder0Mapper)context.getBean("tOrder0Mapper");
        final JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        List<TOrder0> lists = new ArrayList<>(20);
        int i = TOrder0Mapper.selectCount(new TOrder0());
        System.out.println();
        /*for (long i = 2000151; i<2000191; i++) {
            TOrder0 order0 = new TOrder0();
            order0.setGoodsName("测试"+i);
            order0.setOrderId(i);
            order0.setUserId(i);
            lists.add(order0);
        }
        int i = orderService.batchInsert(lists);
        System.out.println(i);*/
        /**/TOrder0 order0 = new TOrder0();
        order0.setUserId(13L);
        order0.setPageNum(5);
        order0.setPageSize(10);
        order0.setOrderBy("user_id desc,order_id asc");
        //List<TOrder0> select = orderService.select(order0);
        long start = System.currentTimeMillis();
        List<TOrder0> tOrder0s = orderService.select(order0);
        List<TOrder0> tOrder0s1 = orderService.select(order0);
        System.out.println();
        //orderService.insert(order0);
        //orderService.updateByPrimaryKey(order0);
        /*Map<String,Object> ob = new HashMap<>();
        ob.put("goodsName","测试111");*/
        //PageHelper.startPage(1,2,true);
        //List<TOrder0> tOrder0s = orderService.selectCountByConditionOr(order0);
        //jdbcTemplate.queryForObject("select count(1) from t_order",Long.class);
       /* ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                for (int i = 0; i<=200; i++) {
                    jdbcTemplate.queryForObject("select count(1) from t_order",Long.class);
                    int page = i*10;
                    List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_order where order_id=13 order by order_id desc limit "+page+",10 ");
                }
                System.out.println("普通用时："+(System.currentTimeMillis()-start));
            }
        });
        executorService.shutdown();*/
        /*long l = System.currentTimeMillis();
        for (int i = 0; i<=200; i++) {
            order0.setPageNum(i+11);
            List<TOrder0> select = orderService.select(order0);
            *//*List<TOrder0> tOrder0s = orderService.selectByCondition(example);*//*
            PageInfo<TOrder0> pageInfo1 = orderService.convertToPage(select);
        }
        System.out.println("用时："+(System.currentTimeMillis()-l));*/
        /**//*long l = System.currentTimeMillis();
        List<TOrder0> select = orderService.select(order0);
        *//*List<TOrder0> tOrder0s = orderService.selectByCondition(example);*//*
        System.out.println("================================================================");
        PageInfo<TOrder0> pageInfo1 = orderService.convertToPage(select);
        System.out.println("用时："+(System.currentTimeMillis()-l));*/
        //System.out.println(pageInfo1);
        //orderService.selectAll();
        /*List<TOrder0> select = orderService.select(pa);
        PageInfo<TOrder0> pageInfo = orderService.convertToPage(select);
        System.out.println(pageInfo);*/
        /*List<TOrder0> tOrder0s = orderService.selectByCondition(example);
        System.out.println(tOrder0s);*/
        /*List<TOrder0> tOrder0s1 = orderService.selectByIds("1,2");
        System.out.println(tOrder0s1);
        //orderService.delete(order0);
        boolean b = orderService.existsWithPrimaryKey(order0);
        System.out.println(b);
        List<TOrder0> tOrder0s2 = orderService.selectByIds("1,2");
        System.out.println(tOrder0s2);*/
        ///jdbcTemplate.execute("INSERT INTO `t_order` VALUES (2, 1, '事务测试12')");
        //List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_order where order_id=2 and user_id=2");
        //System.out.println( "Hello World!" );
    }
}
