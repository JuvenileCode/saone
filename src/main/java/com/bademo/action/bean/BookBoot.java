package com.bademo.action.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created Info: spring 实战练习的BookBean
 * User: dota.liu.bin@gmail.com
 * Date: 2017/6/14 0014.16:07
 */

@Entity //标记一个JPA实体
public class BookBoot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String reader;
    private String isbn;
    private String title;
    private String author;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookBoot{" +
                "id=" + id +
                ", reader='" + reader + '\'' +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

/*
CREATE TABLE `NewTable` (
`id`  int NOT NULL AUTO_INCREMENT ,
`reader`  varchar(100) NULL ,
`isbn`  varchar(50) NULL ,
`title`  varchar(50) NULL ,
`author`  varchar(50) NULL ,
`description`  varchar(255) NULL ,
    PRIMARY KEY (`id`)
);
*/

}
