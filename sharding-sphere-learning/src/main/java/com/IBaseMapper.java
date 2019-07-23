package com;

import com.gennlife.domain.BaseEntity;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.mapper.common.*;

/**
 * @author liuzhen278
 * @title: IBaseMapper
 * @projectName mytest-project
 * @description:  sql 打印参见 https://www.jb51.net/article/117048.htm
 * @date 2019/7/320:00
 */
@CacheNamespace
@EnableCaching
public interface IBaseMapper<T extends BaseEntity> extends BaseMapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {

}
