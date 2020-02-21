package com.yanwhisper.www.atomic;

/**
 * 关于volatile的一些总结
 *
 * @author little whisper
 * @date 2020/2/21 9:53
 */
public class VolatileDemo {
    // volatile作用：保证可见性，禁止指令重排
    // 原理：处理器与内存之间存在多级缓存来提高处理器的速度；当向volatile变量进行写操作时，JVM会向处理器发送一条lock前缀的指令，
    //  将这个缓存中变量写回系统主存；其他处理器通过缓存一致性协议获取新的值
    // 缓存一致性协议：每个处理器通过嗅探总线上传播的数据来检查自己缓存的值是不是过期了；当处理器发现自己缓存行对应的内存地址修改了，
    // 就会将当前处理器的缓存行设置为无效状态；当处理器需要对这个数据进行修改操作时，会强制重新从系统内存里把数据读到处理器缓存里
    static volatile int count = 0;
    public static void main(String args[]) throws Exception {
        Thread t1 = new Thread(() -> {
            // count累加10000次
            for (int i = 0; i < 10000; i++) {
                count = count + 1;
            }
        });
        Thread t2 = new Thread(() -> {
            // count累加10000次
            for (int i = 0; i < 10000; i++) {
                count = count + 1;
            }
        });
        t1.start();
        t2.start();
        // 等待t1、t2线程执行完毕再输出volatile的值
        t1.join();
        t2.join();
        // count的值比20000小，说明volatile不能保证多线程下线程安全
        System.out.println("t1 t2 end! count = " + count);
    }
}
