package com.bademo.action.bean;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Created Info:Lombok Test
 * User: dota.liu.bin@gmail.com
 * Date: 2017/9/28 0028.18:47
 */
public @Getter
@Setter
@ToString
class LomBokTest {
    //http://www.jianshu.com/p/2ea9ff98f7d6
    private String name;
    @NonNull
    private Double sum;
    private Boolean anYm;
    private BigDecimal count;
    private Integer age;

}
