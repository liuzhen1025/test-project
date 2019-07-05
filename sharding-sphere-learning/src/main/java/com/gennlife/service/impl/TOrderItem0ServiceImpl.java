package com.gennlife.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.gennlife.dao.TOrderItem0Mapper;
import com.gennlife.domain.TOrderItem0;
import com.gennlife.service.TOrderItem0Service;

/**
 * @author liuzhen278
 * @title: ${NAME}
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/49:17
 */
@Service
public class TOrderItem0ServiceImpl implements TOrderItem0Service {

    @Resource
    private TOrderItem0Mapper tOrderItem0Mapper;

    @Override
    public int deleteByPrimaryKey(Long orderItemId) {
        return tOrderItem0Mapper.deleteByPrimaryKey(orderItemId);
    }

    @Override
    public int insert(TOrderItem0 record) {
        return tOrderItem0Mapper.insert(record);
    }

    @Override
    public int insertOrUpdate(TOrderItem0 record) {
        return tOrderItem0Mapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(TOrderItem0 record) {
        return tOrderItem0Mapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(TOrderItem0 record) {
        return tOrderItem0Mapper.insertSelective(record);
    }

    @Override
    public TOrderItem0 selectByPrimaryKey(Long orderItemId) {
        return tOrderItem0Mapper.selectByPrimaryKey(orderItemId);
    }

    @Override
    public int updateByPrimaryKeySelective(TOrderItem0 record) {
        return tOrderItem0Mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TOrderItem0 record) {
        return tOrderItem0Mapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<TOrderItem0> list) {
        return tOrderItem0Mapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<TOrderItem0> list) {
        return tOrderItem0Mapper.batchInsert(list);
    }

}

