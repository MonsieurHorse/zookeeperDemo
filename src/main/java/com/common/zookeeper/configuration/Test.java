package com.common.zookeeper.configuration;

import java.io.IOException;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by MHorse on 2016/5/31.
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeperWatcher zw1 = new ZooKeeperWatcher();
        zw1.connect("127.0.0.1", "/root1");
        ZooKeeperWatcher zw2 = new ZooKeeperWatcher();
        zw2.connect("127.0.0.1", "/root1");
        new Thread(zw1).start();
        new Thread(zw2).start();
        ConfigCenter cc = new ConfigCenter("127.0.0.1","/root1");
        cc.updateConfig("a");
        cc.updateConfig("b");
        cc.updateConfig("c");
        cc.updateConfig("d");
    }
}
