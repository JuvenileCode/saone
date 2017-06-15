package com.bademo.action.service;

import com.bademo.action.bean.BookBoot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created Info: s-d-j 简单操作
 * User: dota.liu.bin@gmail.com
 * Date: 2017/6/14 0014.16:19
 */
public interface BookBootRepository extends JpaRepository<BookBoot, Integer> {

    List<BookBoot> findByReader(String reader);

}
