package com.gennlife.service;

import com.gennlife.domain.TOrder0;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuzhen278
 * @title: ${NAME}
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/319:21
 */
public interface TOrder0Service extends BaseService<TOrder0> {
    int batchInsert(List<TOrder0> list);
    public List<TOrder0> selectById(String tableName, String id);
    /*int deleteByPrimaryKey(Long orderId);

    int insert(TOrder0 record);

    int insertOrUpdate(TOrder0 record);

    int insertOrUpdateSelective(TOrder0 record);

    int insertSelective(TOrder0 record);

    TOrder0 selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(TOrder0 record);

    int updateByPrimaryKey(TOrder0 record);

    int updateBatch(List<TOrder0> list);

    int batchInsert(List<TOrder0> list);

    List<TOrder0> selectByCondition(Object tOrder0);*/


}

