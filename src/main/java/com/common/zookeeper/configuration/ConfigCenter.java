package com.common.zookeeper.configuration;

/**
 * Created by MHorse on 2016/5/31.
 */
import java.io.IOException;
import java.io.PrintStream;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ConfigCenter implements Watcher {
    ZooKeeper zk = null;
    String znode;

    ConfigCenter(String address, String znode) {
        this.znode = znode;
        try {
            this.zk = new ZooKeeper(address, 3000, this);
            Stat st = this.zk.exists("/root1", true);
            if (st == null) {
                this.zk.create(znode, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.PERSISTENT);
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.zk = null;
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void process(WatchedEvent event) {
        System.out.println(event.toString());
        try {
            this.zk.exists("/root1", true);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void updateConfig(String str) {
        try {
            Stat s = this.zk.exists(this.znode, true);
            this.zk.setData(this.znode, str.getBytes(), s.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}