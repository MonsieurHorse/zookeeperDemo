package com.common.zookeeper.server;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by MHorse on 2016/6/20.
 */
public class PersistentWatcher {

    public ZooKeeper zooKeeper() throws IOException {
//        String server = null;
        final ZooKeeper zooKeeper = new ZooKeeper("10.10.3.13:2181",
                500000, new Watcher() {
            public void process(WatchedEvent event) {
                // TODO Auto-generated method stub
                if (event.getState() == Watcher.Event.KeeperState.SyncConnected) {
                    System.out.println("watcher received event");
//            countDownLatch.countDown();
                }
                System.out.println("回调watcher1实例： 路径" + event.getPath() + " 类型："+ event.getType());
                // 事件类型，状态，和检测的路径
                Watcher.Event.EventType eventType = event.getType();
                Watcher.Event.KeeperState state = event.getState();
                String watchPath = event.getPath();
                switch (eventType) {
                    case NodeCreated:
                        break;
                    case NodeDataChanged:
                        break;
                    case NodeChildrenChanged:
                        try {
                            //处理收到的消息
                            handleMessage(watchPath);
                        } catch (UnsupportedEncodingException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (KeeperException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        return zooKeeper;
    }



    public void handleMessage(String watchPath) throws KeeperException, InterruptedException, IOException {
        System.out.println("收到消息");
        //再监听该子节点
        List<String> Children = this.getChildren(watchPath);
        System.out.println("watchPath:" + watchPath);
        for (String a : Children) {
            String childrenpath = watchPath + "/" + a;
            byte[] recivedata = this.zooKeeper().getData(childrenpath, false, null);

            String recString = new String(recivedata, "UTF-8");
            System.out.println("receive the path:" + childrenpath + ":data:" + recString);
            //做完了之后，删除该节点
            this.zooKeeper().delete(childrenpath, -1);
//            this.deletNode(childrenpath, -1);
        }
    }

    public List<String> getChildren(String path) throws KeeperException,InterruptedException {
        //监听该节点子节点的变化情况
        return this.getChildren(path);
    }
    public Stat setData(String path, byte[] data, int version)throws KeeperException, InterruptedException {
        return this.setData(path, data, version);
    }

}
