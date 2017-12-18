package com.bademo.mongodb;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created Info: test emity
 * User: dota.liu.bin@gmail.com
 * Date: 2017/12/8 0008.14:54
 */
@Setter
@Getter
@ToString
@Document(collection = "inventory")
public class InventoryEmity implements Serializable{
    @Id
    private String id;
    private String item;
    private String status;
    private Size size;
    private List<Instock> instock;

    @Setter
    @Getter
    @ToString
    public static class Size {
        private double h;
        private double w;
        private String uom;
    }

    @Setter
    @Getter
    @ToString
    public static class Instock {
        private String warehouse;
        private int qty;
    }
}
