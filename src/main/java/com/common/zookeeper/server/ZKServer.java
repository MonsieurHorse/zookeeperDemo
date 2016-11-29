package com.common.zookeeper.server;

import org.apache.commons.logging.Log;
import org.apache.zookeeper.*;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static org.apache.zookeeper.Watcher.Event.EventType.*;

/**
 * Created by MHorse on 2016/6/2.
 */
public class ZKServer {

    public static final Logger logger = LoggerFactory.getLogger(ZKServer.class);
    /*public static ZooKeeper zk() throws IOException {
        final ZooKeeper zk = new ZooKeeper("127.0.0.1:2183",
                3000, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                // TODO Auto-generated method stub
                System.out.println("已经触发了" + event.getType() + "事件！");
//                if (event.equals(EventType.NodeDataChanged)){
//                    zk.setData("/root/child1", zk().getData("/root", false, new Stat()), -1);
//                }
                if (event.getType().equals(-1)){
                    System.out.println("event.getType() None" );
                }else if (event.getType().equals(1)){
                    System.out.println("NodeCreated");
//                    System.out.println(zk.getChildren("/root", true));
                }else if (event.getType().equals(2)){
                    System.out.println("NodeDeleted");
                }else if (event.getType().equals(3)){
                    System.out.println("NodeDataChanged");
                }else if (event.getType().equals(4)){
                    System.out.println("NodeChildrenChanged");
                }else if (event.getType().equals(5)){
                    System.out.println("DataWatchRemoved");
                }else if (event.getType().equals(6)){
                    System.out.println("ChildWatchRemoved");
                }else {
                    System.out.println("others not -1 ~ 6, type: " + event.getType());
                }

                try {
                    if (new String(zk().getData("/root", false, new Stat())).equals(
                            new String(zk().getData("/root/child1", false, new Stat())))) {
                        System.out.println("#############root data 未更新");
                    } else {
                        try {
                            zk().setData("/root/child1", zk().getData("/root", false, new Stat()), -1);
                            System.out.println("************更新path");
                            System.out.println(new String(zk().getData("root/child1", false,new Stat())));
                        } catch (KeeperException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(e);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(e);
                } catch (KeeperException e) {
                    e.printStackTrace();
                    System.out.println(e);
                }

            }
        });
        return zk;
    }*/

//    WatcherWrapper watcherWrapper = new WatcherWrapper();
    public  ZooKeeper zk2() throws IOException {
//        String server = null;
        final ZooKeeper zk2 = new ZooKeeper("127.0.0.1:2183",
                3000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getPath());
                System.out.println(watchedEvent.getState());
                System.out.println(watchedEvent.getType());
                System.out.println(watchedEvent.getWrapper());
                if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                    try {
                        List<String> children = zk2().getChildren("/root", true);
//                        logger.info("children: " + children);
                        System.out.println("children: " + children);
//                Event.EventType.NodeDataChanged
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if (watchedEvent.getType() == EventType.NodeDataChanged){
                    try {
//                        zk2().setData("/root/child1", zk2().getData("/root", false, new Stat()), -1);
                        System.out.println("set child data: " + zk2().setData("/root/child1", zk2().getData("/root", false, new Stat()), -1));
                        System.out.println("root data changed: " + new String(zk2().getData("/root", false, new Stat()), "utf-8"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return zk2;
    }

    public  ZooKeeper zk3() throws IOException {
//        String server = null;
        final ZooKeeper zk3 = new ZooKeeper("10.10.3.13:2181",
                3000, watcher);
        return zk3;
    }

    public Watcher watcher = new Watcher() {
        public void process(WatchedEvent watchedEvent) {
            try {
//                EventType.NodeDataChanged
//                EventType.NodeDataChanged()
//                zk3().setData("/root/child1", zk3().getData("/root", false, new Stat()), -1);
//                System.out.println("child data changed: " + new String(zk3().getData("/root/child1", false, new Stat()), "utf-8"));
                System.out.println("watchedEvent: " + watchedEvent.getType().getIntValue() + " state: " + watchedEvent.getState());
                if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
//                    System.out.println("set child data: " + zk3().setData("/root/child1", zk3().getData("/root", false, new Stat()), -1));
//                    System.out.println("root data changed: " + zk3().getData("/root", false, new Stat()));
                    System.out.println("child1: " + new String(zk3().getData("/root/child1", false, null), "utf-8"));
                    zk3().setData("/root/child1", zk3().getData("/root", false, new Stat()), -1);
                    List<String> children = zk3().getChildren("/root", true);
                    logger.info("children: " + children);
                    System.out.println("children: " + children);
                    System.out.println("child1: " + new String(zk3().getData("/root/child1", false, null), "utf-8"));
                }else if (watchedEvent.getType() == EventType.NodeDataChanged){
//                        zk2().setData("/root/child1", zk2().getData("/root", false, new Stat()), -1);
                    System.out.println("set child data: " + zk3().setData("/root/child1", zk3().getData("/root", false, new Stat()), -1));
//                    zk3().getData();
                    System.out.println("root data changed: " + zk3().getData("/root", false, new Stat()));
                }
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    };



}
