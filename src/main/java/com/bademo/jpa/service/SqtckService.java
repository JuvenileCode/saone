package com.bademo.jpa.service;

import com.bademo.jpa.model.SqtckModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created Info:
 * User: dota.liu.bin@gmail.com
 * Date: 2017/11/9 0009.16:30
 */
public interface SqtckService extends JpaRepository<SqtckModel,Integer>{

    default void message(){
        System.out.println("[I add a method to play]-sqtck-springDateJpa test");
    }

    List<SqtckModel> findByPriceAndNumberLessThan(BigDecimal price, BigDecimal number);
}
