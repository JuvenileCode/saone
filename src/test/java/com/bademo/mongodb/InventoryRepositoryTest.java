package com.bademo.mongodb;

import com.bademo.SaoneApplication;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created Info:
 * User: dota.liu.bin@gmail.com
 * Date: 2017/12/8 0008.15:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SaoneApplication.class)
public class InventoryRepositoryTest {

    @Autowired
    InventoryRepository service;

    @Test
    public void inser(){
        String str="[\n" +
                "  { item: \"journal\", status: \"A\", size: { h: 14, w: 21, uom: \"cm\" }, instock: [ { warehouse: \"A\", qty: 5 } ] },\n" +
                "  { item: \"notebook\", status: \"A\",  size: { h: 8.5, w: 11, uom: \"in\" }, instock: [ { warehouse: \"C\", qty: 5 } ] },\n" +
                "  { item: \"paper\", status: \"D\", size: { h: 8.5, w: 11, uom: \"in\" }, instock: [ { warehouse: \"A\", qty: 60 } ] },\n" +
                "  { item: \"planner\", status: \"D\", size: { h: 22.85, w: 30, uom: \"cm\" }, instock: [ { warehouse: \"A\", qty: 40 } ] },\n" +
                "  { item: \"postcard\", status: \"A\", size: { h: 10, w: 15.25, uom: \"cm\" }, instock: [ { warehouse: \"B\", qty: 15 }, { warehouse: \"C\", qty: 35 } ] }\n" +
                "]";
        Gson gson = new Gson();
        List<InventoryEmity> listInv = gson.fromJson(str,new TypeToken<List<InventoryEmity>>() {}.getType());
        //listInv.forEach(System.out::println);
        service.save(listInv);
        System.out.println("find" + service.findAll());
    }

    @Test
    public void dele() {
        service.deleteAll();
        System.out.println("find" + service.findAll());
    }

    @Test
    public void query(){
        System.out.println(service.findAll());
        System.out.println(service.findByItem("postcard"));
    }

    @Test
    public void basicQuery(){
        BasicQuery bq = new BasicQuery("{ 'instock.qty': { $gt: 10,  $lte: 20 }}");
        //System.out.println("ba"+service.find(bq));
    }

}