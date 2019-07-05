package com.gennlife.dao;

import com.IBaseMapper;
import com.gennlife.domain.TOrderItem0;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderItem0Mapper extends IBaseMapper<TOrderItem0> {

    int updateBatch(List<TOrderItem0> list);

    int batchInsert(@Param("list") List<TOrderItem0> list);

    int insertOrUpdate(TOrderItem0 record);

    int insertOrUpdateSelective(TOrderItem0 record);

    /*int deleteByPrimaryKey(Long orderItemId);

    int insert(TOrderItem0 record);

    int insertSelective(TOrderItem0 record);*/

    /*TOrderItem0 selectByPrimaryKey(Long orderItemId);

    int updateByPrimaryKeySelective(TOrderItem0 record);

    int updateByPrimaryKey(TOrderItem0 record);*/

}