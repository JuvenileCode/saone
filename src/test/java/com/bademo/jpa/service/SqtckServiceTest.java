package com.bademo.jpa.service;

import com.bademo.SaoneApplication;
import com.bademo.jpa.model.SqtckModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created Info: SqtckService Test
 * User: dota.liu.bin@gmail.com
 * Date: 2017/11/9 0009.16:34
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SaoneApplication.class)
public class SqtckServiceTest {

    @Autowired
    SqtckService service;


    @Test
    public void add() {
        SqtckModel ob = new SqtckModel()
                        .setPaper("CKD003").setPcid(15).setKcid(16)
                        .setNumber(BigDecimal.valueOf(3333.11)).setNote("do't?")
                        .setPrice(BigDecimal.valueOf(56.45)).setDate(new Date());
        service.save(ob);
    }

    @Test
    public void dele() {
        try {
            service.delete(3);
        } catch (EmptyResultDataAccessException e) {
            //e.printStackTrace();
            System.out.println("Empty Result - 无此数据删除");
        }
    }

    @Test
    public void update(){
        SqtckModel ob = new SqtckModel()
                .setId(4)
                .setPaper("CKD004").setPcid(21).setKcid(26)
                .setNumber(BigDecimal.valueOf(76.23)).setNote("OpenJPA 2.4")
                .setPrice(BigDecimal.valueOf(123.67)).setDate(new Date());
        service.save(ob);
    }

    @Test
    public void findMull(){
        System.out.println(" all result "+ service.findAll().toString());
        System.out.println(" count result "+ service.count());
        System.out.println(" id result "+ service.findOne(1));
    }

    @Test
    public void findByPriceAndNumber(){
        System.out.println(service.findByPriceAndNumberLessThan(BigDecimal.valueOf(122.44),BigDecimal.valueOf(45.55)));
    }

    @Test
    public void findDynamic() {
        SqtckModel model = new SqtckModel();
        model.setPaper("CKD002");
        model.setPcid(13);
        model.setNumber(BigDecimal.valueOf(56.3));
        System.out.println(service.findDynamic(model));
    }

}