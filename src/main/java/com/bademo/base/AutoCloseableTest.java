package com.bademo.base;

/**
 * @auther: Bin.L
 * @date: 2019-03-27 21:52
 * @Description: {@link AutoCloseable} example
 */
public class AutoCloseableTest implements AutoCloseable {

    public void testPrint() {
        System.out.println("testPrint menthod invoked");
    }

    @Override
    public void close() throws Exception {
        System.out.println("close invoked");
    }

    public static void main(String[] args) throws Exception {

        try (AutoCloseableTest ob = new AutoCloseableTest()) {
            ob.testPrint();
        }

    }
}
