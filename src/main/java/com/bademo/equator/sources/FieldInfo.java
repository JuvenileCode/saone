package com.bademo.equator.sources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther: Bin.L
 * @date: 2020/04/07 11:51
 * @Description: 不同的属性数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldInfo {

    private String fieldName;

    private Class<?> fieldType;

    private Object firstVal;

    private Object secondVal;
}
