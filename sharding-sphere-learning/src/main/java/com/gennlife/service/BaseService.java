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
public interface BaseService<T> extends IBaseMapper<T> {
    public PageInfo<T> convertToPage(List<T> object);
    public List<T> selectCountByConditionOr(BaseEntity t);
}
