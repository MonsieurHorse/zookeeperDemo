package com.common.zookeeper.server;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by MHorse on 2016/6/2.
 */
public class ZKServerTest {

    ZKServer zkServer = new ZKServer();

    String root = "/root";
    String path = root + "/child1";

    /*@Test
    public void testSetad() throws IOException, KeeperException, InterruptedException {
//        String path = "/root/child0604";
//        zkServer.zk().exists("/root", true);
//        zkServer.zk().create("/root/child0604", "add child node".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("~~~~~root: " + new String(zkServer.zk().getData(root, false, new Stat()), "utf-8"));
        zkServer.zk().setData(root, "06121634".getBytes(), -1);
        System.out.println("~~~~~path: " + new String(zkServer.zk().getData(path, false, new Stat()), "utf-8"));
//        zkServer.zk().getData(path, true, new Stat());
//        zkServer.zk().getState();
//        System.out.println(zkServer.zk().getState().toString());
//        zkServer.zk().getConfig(true, new Stat());
//        System.out.println(zkServer.zk().getConfig(true, new Stat()));
        System.out.println(new String(zkServer.zk().getConfig(false, new Stat()), "utf-8"));
    }

    @Test
    public void testGet() throws IOException, KeeperException, InterruptedException {
        System.out.println("path: " + new String(zkServer.zk().getData(path, true, new Stat())));
        System.out.println("root: " + new String(zkServer.zk().getData(path, true, new Stat())));
    }

    @Test
    public void testSet() throws IOException, KeeperException, InterruptedException {
        zkServer.zk().setData(root, "root node data".getBytes(), -1);
    }

    @Test
    public void testGetAndSet() throws IOException, KeeperException, InterruptedException {
        final String rootData = new String(zkServer.zk().getData(root, true, new Stat()));
        final String pathData = new String(zkServer.zk().getData(path, false, new Stat()));
        System.out.println("rootData: " + rootData);
        System.out.println("pathData: " + pathData);
        *//*zkServer.zk().getData(path, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                if (rootData.equals(pathData)) {
                    System.out.println("root data 未更新");
                } else {
                    try {
                        zkServer.zk().setData(path, rootData.getBytes(), -1);
                        System.out.println("更新path");
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Stat());*//*
//        testGet();
    }*/

    @Test
    public void testCreateChild() throws IOException, KeeperException, InterruptedException {

        List<String> children = zkServer.zk2().getChildren(root, true);
        System.out.println("child-old: " + children);
//        zkServer.zk2().
//        zkServer.zk2().create(root + "/child", "test child node data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println(zkServer.zk2().create(root + "/child", "test child node data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL));
//        System.out.println("children: " + zkServer.zk2().getChildren(root, false));
//        System.out.println(new String(zkServer.zk2().getData(root, true, new Stat())));
//        children = zkServer.zk2().getChildren(root, true);
//        System.out.println("child-new: " + children);
//        System.out.println("~~~~~root: " + String.valueOf(zkServer.zk().getChildren(root, true)));
//        zkServer.zk().setData(root, "06121634".getBytes(), -1);
//        System.out.println("~~~~~path: " + new String(zkServer.zk().getData(path, false, new Stat()), "utf-8"));
    }

    @Test
    public void testExist() throws IOException, KeeperException, InterruptedException {
        System.out.println("root: " + new String(zkServer.zk3().getData(root, false, new Stat()), "utf-8"));
//        System.out.println("set rota(root, Calendar.getInstance().getTime().toString().getBytes(), -1).toString().getBytes(), "utf-8"));
//        zkServer.zk3().exists(root, zkServer.watcher);
        zkServer.zk3().exists(root, zkServer.watcher);
        String string = zkServer.zk3().create(path, "test create".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("string: " + string);
        System.out.println("new root: " + new String(zkServer.zk3().getData(root, false, new Stat()), "utf-8"));
        System.out.println("new path: " + new String(zkServer.zk3().getData(path, false, new Stat()), "utf-8"));
    }

    @Test
    public void testSetData() throws IOException, KeeperException, InterruptedException {
        System.out.println("root: " + new String(zkServer.zk3().getData(root, false, new Stat()), "utf-8"));
        zkServer.zk3().setData(root, Calendar.getInstance().getTime().toString().getBytes(), -1);
//        zkServer.zk3().set
//        zkServer.zk3().exists(root, zkServer.watcher);
//        zkServer.zk3().exists(root, zkServer.watcher);
        System.out.println("new root: " + new String(zkServer.zk3().getData(root, false, new Stat()), "utf-8"));
        System.out.println("new path: " + new String(zkServer.zk3().getData(path, false, new Stat()), "utf-8"));
    }

    @Test
    public void testSetDataZK2() throws IOException, KeeperException, InterruptedException {
        System.out.println("root: " + new String(zkServer.zk2().getData(root, true, new Stat()), "utf-8"));
        zkServer.zk2().setData(root, Calendar.getInstance().getTime().toString().getBytes(), -1);
//        System.out.println("new root: " + new String(zkServer.zk2().getData(root, false, new Stat()), "utf-8"));
//        System.out.println("new path: " + new String(zkServer.zk2().getData(path, false, new Stat()), "utf-8"));
    }

    @Test
    public void testGetData() throws IOException, KeeperException, InterruptedException {
        System.out.println("root: " + new String(zkServer.zk2().getData(root, true, new Stat()), "utf-8"));
        zkServer.zk2().setData(path, Calendar.getInstance().getTime().toString().getBytes(), -1);
//        zkServer.zk2().
        System.out.println("new root: " + new String(zkServer.zk2().getData(root, false, new Stat()), "utf-8"));
        System.out.println("new path: " + new String(zkServer.zk2().getData(path, false, new Stat()), "utf-8"));
    }

}
