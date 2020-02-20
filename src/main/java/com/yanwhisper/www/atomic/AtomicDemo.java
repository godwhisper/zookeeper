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
        // 整型原子类：
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("a", 1);
    }
}
