package com.liuz.threads;

import java.util.concurrent.CountDownLatch;

public class countDownlatchTest {
    public static void main(String[] args) throws InterruptedException {  
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for(int i=0;i<9;i++){
            new Thread(new readNum(i,countDownLatch)).start();
        }
        countDownLatch.await();
       /* long count = countDownLatch.getCount();
        System.out.println("count = "+count);
        for(int i=10;i<16;i++){
            new Thread(new readNum(i,countDownLatch)).start();
        }
        count = countDownLatch.getCount();
        System.out.println("count = "+count);*/
        //countDownLatch.await();

        System.out.println("线程执行结束。。。。");  
    }  
  
    static class readNum  implements Runnable{  
        private int id;  
        private CountDownLatch latch;
        public readNum(int id,CountDownLatch latch){  
            this.id = id;  
            this.latch = latch;  
        }  
        @Override  
        public void run() {  
            synchronized (this){
                System.out.println("id:"+id);
               // System.out.println("lantch = "+latch.getCount());
                latch.countDown();
                System.out.println("开始执行时间"+System.currentTimeMillis()+"\t线程组任务"+id+"结束，其他任务继续");
            }  
        }  
    }  
}  