package com.morgan.manage.common.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author：Morgan.B.Chen
 * @Description: 基础service层
 * @Date:2018/7/12
 */
public abstract class BaseServiceImpl<T> implements BaseService<T>{

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public T find(Integer id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> list() {
        return baseMapper.selectAll();
    }

    @Override
    public List<T> list(T t) {
        return baseMapper.select(t);
    }

    @Override
    public int save(T t) {
        return baseMapper.insert(t);
    }

    @Override
    public int batchSave(List<T> list) {
        return baseMapper.insertList(list);
    }

    @Override
    public int update(T t) {
        return baseMapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int remove(Integer id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchRemove(String ids) {
        return baseMapper.deleteByIds(ids);
    }
}
