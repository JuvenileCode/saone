package com.bademo.action.controller;

import com.bademo.action.bean.BookBoot;
import com.bademo.action.service.BookBootJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created Info:
 * User: dota.liu.bin@gmail.com
 * Date: 2017/6/14 0014.16:38
 */
@RestController

@RequestMapping("/book")
public class BookBootController {

    @Autowired
    private BookBootJpaService bookBootJpaService;

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBook(@PathVariable String reader, Model model) {
        List<BookBoot> bbt = bookBootJpaService.findByReader(reader);
        if (!CollectionUtils.isEmpty(bbt)) {
            model.addAttribute("bbt", bbt);
        }
        return "bookBoot";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addBookBoot(@PathVariable String reader, BookBoot bookBoot) {
        bookBoot.setReader(reader);
        bookBootJpaService.save(bookBoot);
        return "bookBoot:/{reader}";
    }
}
