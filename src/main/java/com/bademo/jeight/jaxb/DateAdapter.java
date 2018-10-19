package com.bademo.jeight.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

/**
 * @Description jaxb适配器-处理无法直接使用的复杂数据类型的解析和映射
 *              测试LocalDateTime适配器
 * @Author Bin.Liu
 * @Date 2018/10/19 14:11
 */
public class DateAdapter extends XmlAdapter<String,LocalDateTime>{
    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        return LocalDateTime.parse(v);
    }

    @Override
    public String marshal(LocalDateTime v) throws Exception {
        return v.toString();
    }
}
