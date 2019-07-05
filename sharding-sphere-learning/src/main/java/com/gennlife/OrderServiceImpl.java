package com.gennlife;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuzhen278
 * @title: OrderServiceImpl
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/215:49
 */
@Service("orderService")

@Transactional(rollbackFor = RuntimeException.class)
public class OrderServiceImpl implements OrderService {
    private JdbcTemplate jdbcTemplate;
    @Override
    public void insert(String sql) {
        jdbcTemplate.execute(sql);
        //throw new RuntimeException();
    }

    @Override
    public void insertException(String sql) {
        jdbcTemplate.execute(sql);
        throw new RuntimeException();
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
