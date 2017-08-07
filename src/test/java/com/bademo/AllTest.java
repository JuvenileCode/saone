package com.bademo;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by:临时验证某些代码
 *
 * @author Bin.l
 * @date 2017/8/4 21:57
 */
public class AllTest {

    @Test
    public void atomic() {
        //AtomicInteger，一个提供原子操作的Integer的类:++i和i++不是线程安全的操作
        AtomicInteger count = new AtomicInteger(7);
        System.out.println(count.incrementAndGet());
        System.out.println(new AtomicInteger(6).incrementAndGet());
    }
}
