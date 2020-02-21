package com.yanwhisper.www.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS一些总结
 *
 * @author little whisper
 * @date 2020/2/20 21:29
 */
public class AtomicDemo {
    public static void main(String args[]) {
        // 与lock的区别：获取锁失败不会被挂起，而是会重新尝试获取锁，直到成功为止
        // 存在的问题：ABA问题（追加版本号）；循环时间长开销大；只能保证一个共享变量的原子操作（可以把多个变量放在一个对象里进行CAS操作）
        AtomicInteger atomicInteger = new AtomicInteger();
        // 附带版本号的原子类
        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("a", 1);
    }
}
