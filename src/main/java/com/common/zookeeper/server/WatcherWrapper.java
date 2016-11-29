package com.common.zookeeper.server;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.io.IOException;
import java.util.List;

/**
 * Created by MHorse on 2016/6/12.
 */
public class WatcherWrapper implements Watcher {

    ZKServer zkServer = new ZKServer();

//    Zookeeper zk = new Zookeeper("127.0.0.1:2181", timeout, null);
//    List<String> childrens = ZKServer.zk().getChildren(path, true);
    public void process(WatchedEvent event) {
        if (event.getType() == Event.EventType.NodeChildrenChanged) {
            try {
                List<String> children = zkServer.zk2().getChildren("", true);
                System.out.println("children: " + children);
//                Event.EventType.NodeDataChanged
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // notify Thrift client, rpc service的server ip:port列表发生了变化
        }
    }
}
