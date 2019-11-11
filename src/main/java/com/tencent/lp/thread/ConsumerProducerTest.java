package com.tencent.lp.thread;

import sun.applet.Main;

import java.util.Random;

/**
 * @author Leepong
 * @date 8:45  2019/11/2
 * @description
 */
public class ConsumerProducerTest {
    static class Product {
        String name = "";
        int price = 0;

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    static class Consumer {
        private Product product;

        Consumer(Product product) {
            this.product = product;
        }

        void consume() {
            synchronized (product) {
                for (; ; ) {
                    if (product.name.equals("") | product.price == 0) {
                        try {
                            product.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("consume " + product.getName() + " : " + product.getPrice());
                        product.notify();
                    }
                }
            }
        }
    }

    static class Producer {
        private Product product;

        Producer(Product product) {
            this.product = product;
        }

        public int getRandom(int min, int max) {
            return new Random().nextInt(max - min + 1) + min;
        }

        void produce() {
            synchronized (product) {
                char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
                for (; ; ) {
                    if (product.getName().equals("") | product.getPrice() == 0) {
                        String newName = "" + chars[getRandom(0, 3)] + chars[getRandom(3, 7)];
                        int price = getRandom(20, 20);
                        product.setName(newName);
                        product.setPrice(price);
                        System.out.println("produce " + product.getName() + " : " + product.getPrice());
                        product.notify();
                    } else {
                        try {
                            product.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Product p = new Product();
        Consumer consumer = new Consumer(p);
        Producer producer = new Producer(p);
        new Thread(consumer::consume).start();
        new Thread(producer::produce).start();
    }
}
