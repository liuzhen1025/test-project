package com.gennlife.dao;

import com.IBaseMapper;
import com.gennlife.domain.TOrder0;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liuzhen278
 * @title: ${NAME}
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/319:22
 */
public interface TOrder0Mapper extends IBaseMapper<TOrder0> {

    /*int deleteByPrimaryKey(Long orderId);*//*int deleteByPrimaryKey(Long orderId);*/

    /*int insert(TOrder0 record);*/

    int insertOrUpdate(TOrder0 record);

    int insertOrUpdateSelective(TOrder0 record);

    /*int insertSelective(TOrder0 record);*/

    /*TOrder0 selectByPrimaryKey(Long orderId);*/

   /* int updateByPrimaryKeySelective(TOrder0 record);

    int updateByPrimaryKey(TOrder0 record);*/

    int updateBatch(List<TOrder0> list);

    int batchInsert(@Param("list") List<TOrder0> list);
    @Select("select * from t_order where order_id= ?")
    List<TOrder0> selectById(String id);

}