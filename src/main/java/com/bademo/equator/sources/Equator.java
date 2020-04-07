package com.bademo.equator.sources;

import java.util.List;

/**
 * @auther: Bin.L
 * @date: 2020/04/07 11:50
 * @Description: 对象比对器，用于对比两个对象的所有属性是否完全相等
 */
public interface Equator {

    /**
     * 两个对象是否全相等
     *
     * @param first  对象1
     * @param second 对象2
     * @return 两个对象是否全相等
     */
    boolean isEquals(Object first, Object second);


    /**
     * 获取不相等的属性
     *
     * @param first  对象1
     * @param second 对象2
     * @return 不相等的属性，键为属性名，值为属性类型
     */
    List<FieldInfo> getDiffFields(Object first, Object second);
}
