package com.tencent.lp.extend;

/**
 * @author Leepong
 * @date 10:31  2019/11/2
 * @description
 */
public class Zi extends Fu {

    static {
        System.out.println("this is zi static block");
    }

    {
        System.out.println("this is zi construct block");
        System.out.println("name : " + this.name);
    }

    public Zi(String name) {
        super(name);
        System.out.println("this is zi construct method");
        this.name = name;
    }
}

