package com.bademo.play.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created Info:BeanUtil测试
 * User: dota.liu.bin@gmail.com
 * Date: 2017/5/9 0009.17:15
 */
public class Dota {
    private Integer id;
    private BigDecimal xl;
    private String es;
    private String coco;
    private Date lqsj;
    private Boolean dc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getXl() {
        return xl;
    }

    public void setXl(BigDecimal xl) {
        this.xl = xl;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getCoco() {
        return coco;
    }

    public void setCoco(String coco) {
        this.coco = coco;
    }

    public Date getLqsj() {
        return lqsj;
    }

    public void setLqsj(Date lqsj) {
        this.lqsj = lqsj;
    }

    public Boolean getDc() {
        return dc;
    }

    public void setDc(Boolean dc) {
        this.dc = dc;
    }

    @Override
    public String toString() {
        return "Dota{" +
                "id=" + id +
                ", xl=" + xl +
                ", es='" + es + '\'' +
                ", coco='" + coco + '\'' +
                ", lqsj=" + lqsj +
                ", dc=" + dc +
                '}';
    }
}
