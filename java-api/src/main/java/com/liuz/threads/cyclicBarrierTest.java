package com.liuz.threads;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class cyclicBarrierTest {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("线程组执行结束");
            }
        });
        /*for (int i = 0; i < 4; i++) {
            new Thread(new readNum(i,cyclicBarrier)).start();
        }  */
        //CyclicBarrier 可以重复利用，
        // 这个是CountDownLatch做不到的
        for (int i = 0; i < 15; i++) {
            new Thread(new readNum(i,cyclicBarrier)).start();
        }
        //cyclicBarrier.await();
        System.out.println("主线程停止");
        /*Thread.sleep(1000);
        System.out.println(" pa = "+cyclicBarrier.getParties());
        for (int i = 0; i < 4; i++) {
            new Thread(new readNum(i,cyclicBarrier)).start();
        }*/
    }
    static class readNum  implements Runnable{
        private int id;
        private CyclicBarrier cyc;
        public readNum(int id,CyclicBarrier cyc){
            this.id = id;
            this.cyc = cyc;
        }
        @Override
        public void run() {
            synchronized (this){
                System.out.println("id:"+id);
                try {
                    //System.out.println("parties = "+cyc.getNumberWaiting());
                    cyc.await();
                    /*System.out.print("开始执行时间"+System.currentTimeMillis()+"\t");*/
                    System.out.println("线程组任务" + id + "结束，其他任务继续");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}