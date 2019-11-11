package com.tencent.lp.extend;

import java.io.PrintStream;

/**
 * @author Leepong
 * @date 10:31  2019/11/2
 * @description
 */
public class Run {
    public static void main(String[] args) {
        Zi zi = new Zi("sanshang");
        System.out.println(zi.name);
        zi.printName();

    }

}
