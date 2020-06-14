package com.df.drs.base.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yuan
 * @project drs
 * @description 对象拷贝
 * @date 2020/6/3 17:31
 **/
public class CopyClassUtils {

    /**
     * 单个对象拷贝
     * @param source
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T copyClassProperties(Object source, Class<T> clazz) {
        return BeanUtil.toBean(source,clazz);
    }


    /**
     * 列表对象拷贝
     * @param sources
     * @param clazz
     * @param <T>
     * @param <M>
     * @return
     */
    public static <T, M> List<T> copyListProperties(List<M> sources, Class<T> clazz) {
        if (Objects.isNull(sources) || Objects.isNull(clazz) || sources.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<T> targets = new ArrayList<>(sources.size());
        for (M source : sources) {
            T t = ReflectUtil.newInstance(clazz);
            BeanUtil.copyProperties(source,t);
            targets.add(t);
        }
        return targets;
    }
}
