package com.smartcloud.common.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProduceTest {

    static BlockingQueue<Integer> queue = new LinkedBlockingQueue(5);

    static {
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
    }

    static class Produce implements Runnable {

        @Override
        public void run() {

        }

        public void produce(int data) {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 5) {
                        System.out.println("容器已满，请等一会儿再添加");
                        try {
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(data);
                    queue.notify();
                    System.out.println("添加的数据为:" + data);
                }

            }
        }
    }

    static class Consume implements Runnable {

        @Override
        public void run() {
            consume();
        }

        public void consume() {
            while (true) {

                synchronized (queue) {
                    while (queue.isEmpty()) {
                        System.out.println("没有数据请稍等，请等一会儿再添加");
                        try {
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    Integer take = null;
                    try {
                        take = queue.take();
                        System.out.println("取出的数据为" + take + "剩余元素为:" + queue.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        ProduceTest.Consume consume = new Consume();
        ProduceTest.Produce produce = new Produce();
        Thread t2= new Thread(produce);
        Thread t1= new Thread(consume);
        t2.start();
        t1.start();
    }
}
