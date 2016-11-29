package com.common.zookeeper.online;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by MHorse on 2016/5/17.
 */
public class ServerClient {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        // 创建一个与服务器的连接 需要(服务端的 ip+端口号)(session过期时间)(Watcher监听注册)
        ZooKeeper zk = new ZooKeeper("10.10.3.14:2181",
                3000, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                // TODO Auto-generated method stub
                System.out.println("已经触发了" + event.getType() + "事件！");
                System.out.println("path: " + event.getPath());
                System.out.println("state: " + event.getState());
                System.out.println("wrapper: " + event.getWrapper());
            }
        });

        /*zk.delete("/testRootPath/testChildPathTwo", -1);
        System.out.println(zk.getChildren("/testRootPath", true));
        zk.getChildren("/testRootPath", true);
        zk.delete("/testRootPath", -1);*/
//        zk.close();
        // 创建一个目录节点
        /**
         * CreateMode:
         * 	PERSISTENT (持续的，相对于EPHEMERAL，不会随着client的断开而消失)
         *		PERSISTENT_SEQUENTIAL（持久的且带顺序的）
         *		EPHEMERAL (短暂的，生命周期依赖于client session)
         *		EPHEMERAL_SEQUENTIAL  (短暂的，带顺序的)
         */
//        zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        // 创建一个子目录节点
//        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);

        // 取出子目录节点列表
        System.out.println(zk.getChildren("/im-servers",true));
//        System.out.println(new String(zk.getData("/im-servers",true,null)));
        // 创建另外一个子目录节点
//        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(zk.getChildren("/im-servers/pay",true));
        System.out.println(new String(zk.getData("/im-servers/pay/10.10.3.14:7001", true, null)));

        // 修改子目录节点数据
//        zk.setData("/testRootPath/testChildPathOne","hahahahaha".getBytes(),-1);
//        byte[] datas = zk.getData("/testRootPath/testChildPathOne", true, null);
//        String str = new String(datas,"utf-8");
//        System.out.println(str);

        //删除整个子目录   -1代表version版本号，-1是删除所有版本
//        zk.delete("/testRootPath/testChildPathOne", -1);
//        System.out.println(zk.getChildren("/testRootPath",true));
//        zk.delete("/testRootPath", -1);
//        System.out.println(str);
    }
}
