package com.common.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * Created by MHorse on 2016/5/16.
 */
public class Service {

    public byte[] getData(String path) throws IOException, InterruptedException, KeeperException {
        ZooKeeperOperator zkoperator = new ZooKeeperOperator();
        zkoperator.connect("localhost:2181");

        return zkoperator.getData(path);
    }

    public void zkExist(String path) throws KeeperException, InterruptedException {
        ZooKeeper zooKeeper = null;
//        zooKeeper.exists(path, true);
        zooKeeper.exists(path, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("状态:" + watchedEvent.getState() + " type:" + watchedEvent.getType() +
                        " wrapper:" + watchedEvent.getWrapper() + " path:" + watchedEvent.getPath());
            }
        });
//        return null;
    }

    public void zkGetChild(String path) throws KeeperException, InterruptedException, IOException {
        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 80000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("状态:" + watchedEvent.getState() + " type:" + watchedEvent.getType() +
                        " wrapper:" + watchedEvent.getWrapper() + " path:" + watchedEvent.getPath());
            }
        });
//        zooKeeper.exists(path, true);
       /* zooKeeper.exists(path, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("状态:" + watchedEvent.getState() + " type:" + watchedEvent.getType() +
                        " wrapper:" + watchedEvent.getWrapper() + " path:" + watchedEvent.getPath());
            }
        });*/

        // 取出子目录节点列表
        System.out.println("取出子目录节点列表: " + zooKeeper.getChildren(path, true));
    }
}
