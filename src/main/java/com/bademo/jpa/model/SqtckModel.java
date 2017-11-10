package com.bademo.jpa.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created Info:spring-data-jpa [s_qtck]
 * User: dota.liu.bin@gmail.com
 * Date: 2017/11/9 0009.15:11
 */

@Getter
@Setter
@ToString
@Accessors(chain = true)
@Entity
@Table(name = "s_qtck")
public class SqtckModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String paper;
    private int pcid;
    private int kcid;
    private BigDecimal price;
    private BigDecimal number;
    private Date date;
    private String note;

}
