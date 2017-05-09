package com.bademo.play;

import com.bademo.play.bean.Dota;
import com.bademo.play.bean.ZhenSan;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created Info:BeanUtils复制工具练习 BeanUtils.copyProperties VS PropertyUtils.copyProperties
 * [测试后发现网页说明有些有错,应该是版本比较低的问题,本人的测试版本已修复原作者问题]
 * User: dota.liu.bin@gmail.com
 * Date: 2017/5/5 0005.15:19
 */
public class BeanUtilTest {
    public static void main(String[] args) throws Exception {

        Dota dota = new Dota();
        dota.setId(11);
        dota.setXl(BigDecimal.valueOf(780));
        dota.setEs("牛头人");
        dota.setCoco("船长");
        dota.setLqsj(new Date());
        dota.setDc(true);
        ZhenSan zhenSan = new ZhenSan();

        BeanUtils.copyProperties(dota, zhenSan); //spring-BeanUtils.copyProperties
        System.out.println(dota.toString() + "  >apache<  " + zhenSan.toString());
        //只对名字和类型都一样的属性进行copy，如果名字一样但类型不一样 会转为NULL
        PropertyUtils.copyProperties(zhenSan, dota); //apche-PropertyUtils.copyProperties
        System.out.println(dota.toString() + "  >apache<  " + zhenSan.toString());

        dota.setId(null);
        dota.setEs(null);
        dota.setLqsj(null);
        dota.setDc(null);
        BeanUtils.copyProperties(dota, zhenSan);
        System.out.println(dota.toString() + "  >apache<  " + zhenSan.toString());
        PropertyUtils.copyProperties(zhenSan, dota);
        System.out.println(dota.toString() + "  >apache<  " + zhenSan.toString());

        //List<Ojbect> 无法转换
        Dota dota2 = new Dota();
        dota.setId(12);
        dota.setXl(BigDecimal.valueOf(780));
        dota.setEs("神牛");
        dota.setCoco("船长");
        dota.setLqsj(new Date());
        dota.setDc(false);
        List<Dota> list=new ArrayList<>();
        list.add(dota);
        list.add(dota2);
        List<Dota> list2=new ArrayList<>();
        BeanUtils.copyProperties(list, list2);
        System.out.println(list.toString() + "  >apacheList<  " + list2.toString());
        PropertyUtils.copyProperties(list2, list);
        System.out.println(list.toString() + "  >apache<  " + list2.toString());
    }
}

