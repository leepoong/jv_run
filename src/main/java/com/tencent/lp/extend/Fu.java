package com.tencent.lp.extend;

/**
 * @author Leepong
 * @date 10:31  2019/11/2
 * @description
 */
public class Fu {
    String name = "fu";

    static {
        System.out.println("this is fu static block");
    }

    {
        System.out.println("this is fu construct block");
    }

    public Fu(String name) {
        System.out.println("this is fu construct method");
        this.name = name;
    }

    public void printName() {
        System.out.println(this.name);
    }
}
