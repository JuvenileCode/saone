package com.bademo.equator.sources;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @auther: Bin.L
 * @date: 2020/04/07 13:53
 * 基于 getter 方法比对两个对象
 * <p>
 * 所有无参的 get 和 is 方法都认为是对象的属性
 */
public class GetterBaseEquator extends AbstractEquator {

    private static final String GET = "get";
    private static final String IS = "is";
    private static final String GET_IS = "get|is";
    private static final String GET_CLASS = "getClass";

    public GetterBaseEquator() {
    }

    /**
     * 指定包含或排除某些字段
     *
     * @param includeFields 包含字段，若为 null 或空集，则不指定
     * @param excludeFields 排除字段，若为 null 或空集，则不指定
     */
    public GetterBaseEquator(List<String> includeFields, List<String> excludeFields) {
        super(includeFields, excludeFields);
    }


    @Override
    public List<FieldInfo> getDiffFields(Object first, Object second) {
        if (first == null && second == null) {
            return Collections.emptyList();
        }
        // 先尝试判断是否为普通数据类型
        if (isSimpleField(first, second)) {
            return compareSimpleField(first, second);
        }

        List<FieldInfo> diffField = new LinkedList<>();
        Object obj = first == null ? second : first;
        Map<String, Method> getters = getAllGetters(obj.getClass());
        for (Map.Entry<String, Method> entry : getters.entrySet()) {
            String fieldName = entry.getKey();
            Method method = entry.getValue();
            try {
                boolean eq;
                Object firstVal = first == null ? null : method.invoke(first);
                Object secondVal = second == null ? null : method.invoke(second);
                FieldInfo fieldInfo = new FieldInfo(fieldName, method.getReturnType(), firstVal, secondVal);
                eq = isFieldEquals(fieldInfo);
                if (!eq) {
                    diffField.add(fieldInfo);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new IllegalStateException("获取属性进行比对发生异常: " + fieldName, e);
            }
        }

        return diffField;
    }

    /**
     * 获取类中的所有 getter 方法
     *
     * @return key -> fieldName, value -> getter
     */
    private Map<String, Method> getAllGetters(Class<?> clazz) {
        Map<String, Method> getters = new LinkedHashMap<>(12);
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            // getter 方法没有参数
            if (m.getParameterTypes().length > 0) {
                continue;
            }
            if (m.getReturnType() == Boolean.class || m.getReturnType() == boolean.class) {
                // 如果返回值是 boolean 则兼容 isXxx 的写法
                if (m.getName().startsWith(IS)) {
                    String fieldName = uncapitalize(m.getName().substring(2));
                    getters.put(fieldName, m);
                    continue;
                }
            }
            // 以get开头但排除getClass()方法
            if (m.getName().startsWith(GET) && !GET_CLASS.equals(m.getName())) {
                String fieldName = uncapitalize(m.getName().replaceFirst(GET_IS, ""));
                getters.put(fieldName, m);
            }
        }
        return getters;
    }

    /**
     * 来自spring的StringUtils
     * <p/>
     * 用于使首字母小写
     */
    private String uncapitalize(String str) {
        if (str == null && str.isEmpty()) {
            return str;
        } else {
            char baseChar = str.charAt(0);
            char updatedChar;
            updatedChar = Character.toLowerCase(baseChar);
            if (baseChar == updatedChar) {
                return str;
            } else {
                char[] chars = str.toCharArray();
                chars[0] = updatedChar;
                return new String(chars, 0, chars.length);
            }
        }
    }
}
