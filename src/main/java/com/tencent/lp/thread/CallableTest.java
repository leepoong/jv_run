package com.tencent.lp.thread;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author Leepong
 * @date 9:39  2019/11/3
 * @description
 */
public class CallableTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " start to call");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " end calling");
        return new Random().nextInt(10) + "";
    }
}
