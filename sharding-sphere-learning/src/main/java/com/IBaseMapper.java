package com;

import tk.mybatis.mapper.common.*;

/**
 * @author liuzhen278
 * @title: IBaseMapper
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/320:00
 */
public interface IBaseMapper<T> extends BaseMapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {

}
