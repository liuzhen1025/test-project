package com.gennlife.service.impl;

import com.IBaseMapper;
import com.gennlife.dao.TOrder0Mapper;
import com.gennlife.domain.TOrder0;
import com.gennlife.service.TOrder0Service;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuzhen278
 * @title: TOrderServiceImpl2
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/410:22
 */
@Service("order0Service")
public class TOrderServiceImpl2 extends BaseServiceImpl<TOrder0> implements TOrder0Service {
    private TOrder0Mapper tOrder0Mapper;
    public TOrderServiceImpl2(TOrder0Mapper tOrder0Mapper) {
        super(tOrder0Mapper);
        this.tOrder0Mapper = tOrder0Mapper;
    }

    @Override
    public int batchInsert(List<TOrder0> list) {
        return tOrder0Mapper.batchInsert(list);
    }

    @Override
    public List<TOrder0> selectById(String id) {
        return tOrder0Mapper.selectById(id);
    }

}