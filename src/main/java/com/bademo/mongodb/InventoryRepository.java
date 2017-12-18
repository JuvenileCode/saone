package com.bademo.mongodb;

import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created Info: mongodb crud基本操作练习
 * User: dota.liu.bin@gmail.com
 * Date: 2017/12/8 0008.15:13
 */
@Service
public interface InventoryRepository extends CrudRepository<InventoryEmity, String> {

    /**
     * 方法命名查询
     * @param item
     * @return
     */
    InventoryEmity findByItem(String item);

    //List<InventoryEmity> find(BasicQuery bq);
}
