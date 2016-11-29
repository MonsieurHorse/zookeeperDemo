package com.common.zookeeper.server;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by MHorse on 2016/6/20.
 */
public class persistentWatcherTest {

    PersistentWatcher persistentWatcher = new PersistentWatcher();
    String root = "/root";
    String path = root + "/child1";
    @Test
    public void testExist() throws IOException, KeeperException, InterruptedException {
        System.out.println("root: " + new String(persistentWatcher.zooKeeper().getData(root, false, new Stat()), "utf-8"));
        System.out.println(persistentWatcher.zooKeeper().getChildren(root, true));
        persistentWatcher.zooKeeper().create(root + "/child", "child data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
//        System.out.println("set rota(root, Calendar.getInstance().getTime().toString().getBytes(), -1).toString().getBytes(), "utf-8"));
//        zkServer.zk3().exists(root, zkServer.watcher);
//        persistentWatcher.zooKeeper().exists(root, true);
//        System.out.println("new root: " + new String(persistentWatcher.zooKeeper().getData(root, false, new Stat()), "utf-8"));
//        System.out.println("new path: " + new String(persistentWatcher.zooKeeper().getData(path, false, new Stat()), "utf-8"));
    }

}
