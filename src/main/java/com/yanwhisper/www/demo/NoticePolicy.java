package com.yanwhisper.www.demo;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author little whisper
 * @date 2020/2/20 21:00
 */
public class NoticePolicy implements RejectedExecutionHandler {

    // 触发拒绝策略的时候，打印一串信息
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("触发拒绝策略。。。");
    }
}
