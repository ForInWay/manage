package com.morgan.manage.common.base;

import java.util.List;

public interface BaseService<T> {

    T find(Integer id);

    List<T> list();

    List<T> list(T t);

    int add(T t);

    int batchSave(List<T> list);

    int update(T t);

    int remove(Integer id);

    int batchRemove(String ids);
}
