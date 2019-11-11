package com.tencent.lp;

import com.tencent.lp.proto.MyProtoClass;

import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void run(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static <T> void run2(List<T> list) {
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        MyProtoClass.Person sanshang = MyProtoClass.Person.newBuilder()
                .setName("sanshang")
                .setAge(23)
                .setGender(MyProtoClass.Gender.MALE)
                .build();
        System.out.println(sanshang.getAge());
    }


}
