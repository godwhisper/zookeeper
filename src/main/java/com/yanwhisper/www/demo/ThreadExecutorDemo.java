package com.yanwhisper.www.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author little whisper
 * @date 2020/2/20 18:26
 */
public class ThreadExecutorDemo {
    public static void main(String args[]) throws Exception {
        // 创建一个核心线程数为5，最大线程数为10， 空闲线程存活时间30s（大于核心数的线程），并且任务队列长度为100的阻塞队列
        // 拒绝策略：默认提供四种拒绝策略
        // 1.CallerRunsPolicy：只要线程池没有关闭，则调用者线程自己执行该任务，适用于并发小，性能要求不高，不允许失败；提交速度过快，会导致调用者线程阻塞
        // 2.AbortPolicy：线程池默认的拒绝策略，丢弃任务，并抛出拒绝执行RejectedExecutionException异常
        // 3.DiscardPolicy：直接丢弃，啥也不做
        // 4.DiscardOldestPolicy：当触发拒绝拒绝策略的时候，只要线程池没有关闭，则丢弃队列中最老的一个任务
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100), new NoticePolicy());
        for (int i = 0; i < 1000; i++) {
            final int number = i;
            // 1.添加任务时若线程池中线程数小于核心线程数，则新建线程执行任务
            // 2.若线程池中线程数等于核心线程，则会先将任务加入到任务队列，队列没满则加入
            // 3.若任务队列已满，则会先检查线程池中线程数是否超过最大数，如果没有超过最大线程数则新建线程执行
            // 4.若队列已满，并且线程池中线程数已达到最大线程数，则执行拒绝策略
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(number);
                }
            });
        }
        System.out.println("存活线程数：" + executor.getActiveCount());
        // 停止线程池（调用后立即返回，不再接收新任务，队列中已存在的任务还是会执行）
        // shutdownNow()：与shutdown()不同的是，该方法不仅不再接收新任务，还会将任务队列的任务丢弃，正在运行的任务也会被中断，然后立即返回
        executor.shutdown();
        // 判断线程池中是否还有线程在运行（该方法会阻塞调用线程，直到线程池中线程全部停止运行或者超时）
        // 参数1：超时时间，参数2：超时时间单位
        // 调用该方法前需要手动停止线程池，否则一般会超时时间到了才返回
        boolean end = executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("end = " + end);
    }
}
