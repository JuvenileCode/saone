package com.bademo.action.controller;

import com.bademo.action.bean.BookBoot;
import com.bademo.action.service.BookBootRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created Info:
 * User: dota.liu.bin@gmail.com
 * Date: 2017/6/14 0014.16:38
 */
@Controller
@RequestMapping("/book")
@Api(value = "API-VehiclesController", description = "Book接口swagger测试")
public class BookBootController {

    @Autowired
    private BookBootRepository bookBootJpaService;

    @ApiOperation(value = "查询Book接口", notes = "此接口描述xxxxxxxxxxxxx<br/>xxxxxxx<br>值得庆幸的是这儿支持html标签<hr/>", httpMethod = "GET", response = String.class)
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBook(@PathVariable String reader, Model model) {
        List<BookBoot> bbt = bookBootJpaService.findByReader(reader);
        if (!CollectionUtils.isEmpty(bbt)) {
            model.addAttribute("bbt", bbt);
        }
        return "bookBoot";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBookBoot(BookBoot bookBoot) {
        bookBoot.setReader("2");
        bookBootJpaService.save(bookBoot);
        return "redirect:/book/2";
    }
}
