package com.gennlife.service.impl;

import com.IBaseMapper;
import com.gennlife.annotation.EnablePage;
import com.gennlife.domain.BaseEntity;
import com.gennlife.service.BaseService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhen278
 * @title: BaseServiceImpl
 * @projectName mytest-project
 * @description: TODO
 * @date 2019/7/410:05
 */
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected IBaseMapper<T> baseMapper;
    public BaseServiceImpl(IBaseMapper baseMapper){
        this.baseMapper = baseMapper;
    }
    /**
    　　* @description: 根据对象删除对应数据，属性值不能有null值(sharding-jdbc要求)
    　　* @param [o]
    　　* @return int
    　　* @throws
    　　* @author liuzhen278
    　　* @date 2019/7/4 11:06
    　　*/
    @Override
    public int deleteByPrimaryKey(Object o) {
        return baseMapper.deleteByPrimaryKey(o);
    }
    /**
     　　* @description: 根据对象删除对应数据
     　　* @param t 需要删除数据
     　　* @return int
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:06
     　　*/
    @Override
    public int delete(T t) {
        return baseMapper.delete(t);
    }
    /**
    　　* @description: 保存数据
    　　* @param t 需要插入的数据
    　　* @return int
    　　* @throws
    　　* @author liuzhen278
    　　* @date 2019/7/4 11:11
    　　*/
    @Override
    public int insert(T t) {
        return baseMapper.insert(t);
    }
    /**
     　　* @description: 保存数据，主键为自增长
     　　* @param t 需要插入的数据
     　　* @return int
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:11
     　　*/
    @Override
    public int insertUseGeneratedKeys(T t) {
        return baseMapper.insertUseGeneratedKeys(t);
    }
    /**
    　　* @description: 根据id 查询数据
    　　* @param ids 英文逗号分隔的id
    　　* @return java.util.List<T>
    　　* @throws
    　　* @author liuzhen278
    　　* @date 2019/7/4 11:14
    　　*/
    @Override
    public List<T> selectByIds(String ids) {
        return baseMapper.selectByIds(ids);
    }
    /**
     　　* @description: 根据id 删除数据
     　　* @param ids 英文逗号分隔的id
     　　* @return java.util.List<T>
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:14
     　　*/
    @Override
    public int deleteByIds(String s) {
        return baseMapper.deleteByIds(s);
    }
    /**
    　　* @description: 根据指定条件查询数据
    　　* @param o 参见{@link tk.mybatis.mapper.entity.Example}
    　　* @return java.util.List<T>
    　　* @throws
    　　* @author liuzhen278
    　　* @date 2019/7/4 11:24
    　　*/
    @Override
    public List<T> selectByCondition(Object o) {
        return baseMapper.selectByCondition(o);
    }
    /**
     　　* @description: 根据指定条件查询数据总量
     　　* @param o 参见{@link tk.mybatis.mapper.entity.Example}
     　　* @return java.util.List<T>
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:24
     　　*/
    @Override
    public int selectCountByCondition(Object o) {
        return baseMapper.selectCountByCondition(o);
    }
    /**
     　　* @description: 根据指定条件删除数据
     　　* @param o 参见{@link tk.mybatis.mapper.entity.Example}
     　　* @return java.util.List<T>
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:24
     　　*/
    @Override
    public int deleteByCondition(Object o) {
        return baseMapper.deleteByCondition(o);
    }
    /**
     　　* @description: 根据指定条件更新数据
     　　* @param t,o t为需要更新的数据对象；0为条件参见{@link tk.mybatis.mapper.entity.Example}
     　　* @return java.util.List<T>
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:24
     　　*/
    @Override
    public int updateByCondition(T t, Object o) {
        return baseMapper.updateByCondition(t,o);
    }
    /**
     　　* @description: 根据指定条件更新数据
     　　* @param t,o t为需要更新的数据对象；0为条件参见{@link tk.mybatis.mapper.entity.Example}
     　　* @return java.util.List<T>
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:24
     　　*/
    @Override
    public int updateByConditionSelective(T t, Object o) {
        return baseMapper.updateByConditionSelective(t,o);
    }
    /**
     　　* @description: 根据指定条件查询数据
     　　* @param o 0为条件参见{@link tk.mybatis.mapper.entity.Example}
     　　* @return java.util.List<T>
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:24
     　　*/
    @Override
    public List<T> selectByExample(Object o) {
        return baseMapper.selectByExample(o);
    }
    /**
     　　* @description: 根据指定条件查询数据总数
     　　* @param o 0为条件参见{@link tk.mybatis.mapper.entity.Example}
     　　* @return java.util.List<T>
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:24
     　　*/
    @Override
    public int selectCountByExample(Object o) {
        return baseMapper.selectCountByExample(o);
    }
    /**
     　　* @description: 根据指定条件查询唯一一条数据
     　　* @param o 0为条件参见{@link tk.mybatis.mapper.entity.Example}
     　　* @return java.util.List<T>
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:24
     　　*/
    @Override
    public T selectOneByExample(Object o) {
        return baseMapper.selectOneByExample(o);
    }
    /**
     　　* @description: 根据指定条件查询删除数据
     　　* @param o 0为条件参见{@link tk.mybatis.mapper.entity.Example}
     　　* @return java.util.List<T>
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:24
     　　*/
    @Override
    public int deleteByExample(Object o) {
        return baseMapper.deleteByExample(o);
    }
    /**
     　　* @description: 根据指定条件查询更新数据
     　　* @param o 0为条件参见{@link tk.mybatis.mapper.entity.Example}
     　　* @return java.util.List<T>
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:24
     　　*/
    @Override
    public int updateByExample(T t, Object o) {
        return baseMapper.updateByExample(t,o);
    }
    /**
     　　* @description: 根据指定条件查询更新数据
     　　* @param o 0为条件参见{@link tk.mybatis.mapper.entity.Example}
     　　* @return java.util.List<T>
     　　* @throws
     　　* @author liuzhen278
     　　* @date 2019/7/4 11:24
     　　*/
    @Override
    public int updateByExampleSelective(T t, Object o) {
        return baseMapper.updateByExampleSelective(t,o);
    }
    /**
    　　* @description: 批量插入
    　　* @param [list]
    　　* @return int
    　　* @throws
    　　* @author liuzhen278
    　　* @date 2019/7/4 14:05
    　　*/
    @Override
    public int insertList(List<? extends T> list) {
        return baseMapper.insertList(list);
    }
    /**
    　　* @description: 非空值插入
    　　* @param [t]
    　　* @return int
    　　* @throws
    　　* @author liuzhen278
    　　* @date 2019/7/4 14:05
    　　*/
    @Override
    public int insertSelective(T t) {
        return baseMapper.insertSelective(t);
    }

    @Override
    public boolean existsWithPrimaryKey(Object o) {
        return baseMapper.existsWithPrimaryKey(o);
    }

    @Override
    public List<T> selectAll() {
        List<T> ts = baseMapper.selectAll();
        return ts;
    }

    @Override
    public T selectByPrimaryKey(Object o) {
        return baseMapper.selectByPrimaryKey(o);
    }

    @Override
    public int selectCount(T t) {
        return baseMapper.selectCount(t);
    }

    @Override
    public List<T> select(T t) {
        List<T> select = baseMapper.select(t);
        return select;
    }

    @Override
    public T selectOne(T t) {
        return baseMapper.selectOne(t);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return baseMapper.updateByPrimaryKey(t);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public PageInfo<T> convertToPage(List<T> object) {
        return new PageInfo<>(object==null? new ArrayList<T>():object);
    }
    @EnablePage
    @Override
    public List<T> selectCountByConditionOr(BaseEntity t) {
        Example example = new Example(t.getClass());
        Example.Criteria criteria = example.createCriteria();
        criteria.orEqualTo(t);
        return this.selectByCondition(example);
    }
    @EnablePage
    @Override
    public PageInfo<T> selectByEntityWithPage(T t) {
        List<T> list = this.select(t);
        //PageInfo<T> pageInfo = new PageInfo<>(select==null? new ArrayList<T>():select);
        return this.convertToPage(list);
    }
    @EnablePage
    @Override
    public PageInfo<T> selectByExampleWithPage(T t) {
        List<T> ts = this.selectByExample(t);
        return this.convertToPage(ts);
    }
    @EnablePage
    @Override
    public PageInfo<T> selectByConditonWithPage(T t) {
        List<T> ts = this.selectByCondition(t);
        return this.convertToPage(ts);
    }

}
