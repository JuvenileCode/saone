package com.bademo.action.service;

import com.bademo.SaoneApplication;
import com.bademo.action.bean.BookBoot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created Info:
 * User: dota.liu.bin@gmail.com
 * Date: 2017/6/15 0015.14:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SaoneApplication.class)
@WebAppConfiguration
public class BookBootRepositoryTest {

    @Autowired
    private BookBootRepository BookBootDao;

    @Test
    public void test() throws Exception {
        // 创建1条记录
//        BookBoot bookBoot = new BookBoot();
//        bookBoot.setReader("AA");
//        bookBoot.setDescription("BB");
//        bookBoot.setIsbn("CC");
//        bookBoot.setAuthor("EE");
//        bookBoot.setIsbn("FF");
//        BookBootDao.save(bookBoot);
        // 测试findAll, 查询所有记录
        Assert.assertEquals(5, BookBootDao.findAll().size());
        // 测试findByName, 查询姓名为FFF的BookBoot
        //Assert.assertEquals(60, BookBootDao.findByName("FFF").getAge().longValue());
        // 测试findBookBoot, 查询姓名为FFF的BookBoot
        //Assert.assertEquals(60, BookBootDao.findBookBoot("FFF").getAge().longValue());
        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的BookBoot
        //Assert.assertEquals("FFF", BookBootDao.findByNameAndAge("FFF", 60).getName());
        // 测试删除姓名为AAA的BookBoot
        //BookBootDao.delete(BookBootDao.findByName("AAA"));
        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        //Assert.assertEquals(9, BookBootDao.findAll().size());
    }


    @Test
    public void findByReader() throws Exception {
    }
}