package com.bademo.play;

import com.bademo.play.bean.BasicPerson;
import com.bademo.play.bean.BasicPersonDto;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.Date;

/**
 * Created by:Orika JavaBean映射工具练习
 *
 * @author Bin.l
 * @date 2017/5/8 22:32
 */
public class OrikaBeanTest {

    //1 ,Orika映射框架的基础是MapperFactory类,将用于配置任何映射的类,并获取执行实际映射工作的MapperFacade
    private static final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    public static void main(String[] args) {
        BasicPerson bpOne = new BasicPerson();
        bpOne.setName("Orika碉堡了");
        bpOne.setAge(18);
        bpOne.setBirthDate(null);
        bpOne.setYq(895.5);

        //2 注册字段映射，转换器，自定义映射器，具体类型等[可以List,map转换]
        mapperFactory.classMap(BasicPerson.class, BasicPersonDto.class)
                 //.mapNulls(false).mapNullsInReverse(false) //TODO 为null不映射不知为什么不行
                .field("name", "fullName")
                .field("age", "currentAge")
                .byDefault()  //属性类型和名字一样默认转换
                .register();

        //使用MapperFacade映射对象
        MapperFacade mapper = mapperFactory.getMapperFacade();
        BasicPersonDto bpDtoOne=new BasicPersonDto();
        bpDtoOne.setBirthDate(new Date());
        bpDtoOne=mapper.map(bpOne,BasicPersonDto.class);
        System.out.println(bpOne.toString()+" <> "+bpDtoOne.toString());
        //使用 BoundMapperFacade 转换对象绑定
        BoundMapperFacade<BasicPerson, BasicPersonDto> boundMapper =
                mapperFactory.getMapperFacade(BasicPerson.class, BasicPersonDto.class);
        BasicPersonDto bpDtoOne2=new BasicPersonDto();
        bpDtoOne2.setBirthDate(new Date());
        bpDtoOne2= boundMapper.map(bpOne);
        System.out.println(bpOne.toString()+" <> "+bpDtoOne2.toString());


    }


}

