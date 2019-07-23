package com.gennlife.service;

import com.IBaseMapper;
import com.gennlife.domain.BaseEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author liuzhen278
 * @title: BaseService
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/410:04
 */
public interface BaseService<T extends BaseEntity> extends IBaseMapper<T> {
    public PageInfo<T> convertToPage(List<T> object);
    public PageInfo<T> selectByEntityWithPage(T t);
    public PageInfo<T> selectByExampleWithPage(T t);
    public PageInfo<T> selectByConditonWithPage(T t);
    public List<T> selectCountByConditionOr(BaseEntity t);
}
