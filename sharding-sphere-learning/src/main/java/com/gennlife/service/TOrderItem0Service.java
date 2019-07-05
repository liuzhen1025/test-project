package com.gennlife.service;

import java.util.List;
import com.gennlife.domain.TOrderItem0;

/**
 * @author liuzhen278
 * @title: ${NAME}
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/49:17
 */
public interface TOrderItem0Service {


    int deleteByPrimaryKey(Long orderItemId);

    int insert(TOrderItem0 record);

    int insertOrUpdate(TOrderItem0 record);

    int insertOrUpdateSelective(TOrderItem0 record);

    int insertSelective(TOrderItem0 record);

    TOrderItem0 selectByPrimaryKey(Long orderItemId);

    int updateByPrimaryKeySelective(TOrderItem0 record);

    int updateByPrimaryKey(TOrderItem0 record);

    int updateBatch(List<TOrderItem0> list);

    int batchInsert(List<TOrderItem0> list);

}

