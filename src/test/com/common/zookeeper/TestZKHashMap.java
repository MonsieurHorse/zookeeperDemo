/*
package com.common.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

*/
/**
 * Created by MHorse on 2016/5/31.
 *//*

public class TestZKHashMap {
    private static final String hostString = "localhost:2181";
    private static final String baseHashMapPath = "/test-maps";
    private static final String baseLockPath = "/test-locks";
    private static final String Init_Done = "/initData";
    private static final int timeout = 2000;

    private static ZooKeeper zk1, zk2;
    private static ZkSessionManager zkSessionManager1, zkSessionManager2;
    private static ZkHashMap<String,Person> testMap1, testMap2;
    private static Serializer<Entry<String, Person>> serializer = new JavaSerializer<String, Person>();

    public static void main(String[] args) throws Exception {
        setup();
        final CountDownLatch latch = new CountDownLatch(2);

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                initData(zk1, zkSessionManager1);
                String znode = "test1";
                Person person = new Person("melin");
                testMap1.put(znode, person);
                latch.countDown();
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                initData(zk2, zkSessionManager2);
                String znode = "test2";
                Person person = new Person("melin");
                testMap2.put(znode, person);
                latch.countDown();
            }
        };
        thread1.start();
        thread2.start();
        latch.await();
        Thread.sleep(100);

        if(testMap1.containsKey("test2")) {
            System.out.println("testMap1 包含 test2");
        }

        if(testMap2.containsKey("test1")) {
            System.out.println("testMap2 包含 test1");
        }

        tearDown();
    }

    private static ZooKeeper newZooKeeper() throws IOException {
        return new ZooKeeper(hostString, timeout,new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("+++++++++"+event);
            }
        });
    }

    public static void setup() throws Exception {
        zk1 = newZooKeeper();
        zk1.create(baseHashMapPath,new byte[]{}, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zkSessionManager1 = new BaseZkSessionManager(zk1);
        testMap1 = new ZkHashMap<String, Person>(baseHashMapPath, zkSessionManager1, serializer);

        zk2 = newZooKeeper();
        zkSessionManager2 = new BaseZkSessionManager(zk2);
        testMap2 = new ZkHashMap<String, Person>(baseHashMapPath, zkSessionManager2, serializer);
    }

    public static void tearDown() throws Exception{
        try{
            ZkUtils.recursiveSafeDelete(zk1,baseHashMapPath,-1);
            ZkUtils.recursiveSafeDelete(zk1,baseLockPath,-1);
            ZkUtils.recursiveSafeDelete(zk1,Init_Done,-1);
        }catch(KeeperException ke){
            //suppress because who cares what went wrong after our tests did their thing?
        }finally{
            zk1.close();
            zk2.close();
        }
    }

    public static void initData(ZooKeeper zk, ZkSessionManager zkSessionManager) {
        final Lock lock = new ReentrantZkLock(baseLockPath, zkSessionManager);
        try {
            if (null == zk.exists(Init_Done, true)) {
                // if the init_done node not exists we try to init
                lock.lock();
                if(zk.exists(Init_Done, true) != null) {
                    System.out.println("已经初始化数据"+zk);
                    return;
                }
                System.out.println("初始化数据"+zk);
                //创建初始化成功标识,注意这个标志是永久节点
                zk.create(Init_Done, null, ZooDefs.Ids.OPEN_ACL_UNSAFE,  CreateMode.PERSISTENT);
                //工作完成,释放锁
                lock.unlock();
            } else {// if init_done exists we simply load data from gcih
                System.out.println("已经初始化数据"+zk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
