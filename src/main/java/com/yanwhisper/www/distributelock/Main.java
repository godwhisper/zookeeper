package com.yanwhisper.www.distributelock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

/**
 * @author little whisper
 * @date 2020/2/13 12:35
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Watcher watcher = new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getType() + "-" + watchedEvent.getState() + "-" + watchedEvent.getPath());
            }
        };
        ZooKeeper zk = new ZooKeeper("localhost:2181", 3000, watcher);
        Stat rootStat = zk.exists("/root", true);
        if (rootStat == null) {
            zk.create("/root", "root data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        System.out.println("------------分割线-----------");

        Stat rcStat = zk.exists("/root/rc1", true);
        if (rcStat == null) {
            zk.create("/root/rc1", "I am the first child.".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        System.out.println("------------分割线-----------");

//        zk.setData("/root/rc1", "Hello, the first child.".getBytes(), 0);
        Stat stat = new Stat();
        byte[] bytes = zk.getData("/root/rc1", true, stat);
        System.out.println(bytes.toString() + ":" + stat.getVersion());
    }
}
