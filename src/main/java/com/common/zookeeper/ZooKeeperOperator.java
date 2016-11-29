package com.common.zookeeper;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
//import sun.rmi.runtime.Log;
//import sun.rmi.runtime.Log;

/**
 * Created by MHorse on 2016/5/16.
 */
public class ZooKeeperOperator extends AbstractZooKeeper {
    private static Log log = LogFactory.getLog(ZooKeeperOperator.class.getName());

    /**
     *
     *<b>function:</b>创建持久态的znode,比支持多层创建.比如在创建/parent/child的情况下,无/parent.无法通过
     *@author cuiran
     *@createDate 2013-01-16 15:08:38
     *@param path
     *@param data
     *@throws KeeperException
     *@throws InterruptedException
     */
    public void create(String path,byte[] data)throws KeeperException, InterruptedException{
        /**
         * 此处采用的是CreateMode是PERSISTENT  表示The znode will not be automatically deleted upon client's disconnect.
         * EPHEMERAL 表示The znode will be deleted upon the client's disconnect.
         */
        this.zooKeeper.create(path, data, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
    /**
     *
     *<b>function:</b>获取节点信息
     *@author cuiran
     *@createDate 2013-01-16 15:17:22
     *@param path
     *@throws KeeperException
     *@throws InterruptedException
     */
    public void getChild(String path) throws KeeperException, InterruptedException{
        try{
            List<String> list=this.zooKeeper.getChildren(path, false);
            if(list.isEmpty()){
                log.debug(path+"中没有节点");
            }else{
                log.debug(path+"中存在节点");
                for(String child:list){
                    log.debug("节点为："+child);
                }
            }
        }catch (KeeperException.NoNodeException e) {
            // TODO: handle exception
            throw e;

        }
    }

    public String getChildString(String path) throws KeeperException, InterruptedException {
        List<String> list = this.zooKeeper.getChildren(path, false);
        if (null == list){
            return path + "中没有节点";
        }else {
            String children = null;
            for (String child : list){
                children = children +", " + child;
            }
            return path + "中存在节点: " + children;
        }
//        return null;
    }
    public byte[] getData(String path) throws KeeperException, InterruptedException {
        return  this.zooKeeper.getData(path, false,null);
    }

    public static void main(String[] args) {
        try {
            ZooKeeperOperator zkoperator             = new ZooKeeperOperator();
            zkoperator.connect("localhost:2181");

            byte[] data = new byte[]{'a','b','c','d'};

            String root = "/root05171158";

              zkoperator.create(root, null);
              System.out.println(Arrays.toString(zkoperator.getData(root)));

              zkoperator.create(root + "/child1", data);
              System.out.println(Arrays.toString(zkoperator.getData(root + "/child1")));

              zkoperator.create(root + "/child2", data);
              System.out.println(Arrays.toString(zkoperator.getData(root + "/child2")));

            String zktest="ZooKeeper的Java API测试";
            zkoperator.create(root + "/child3", zktest.getBytes());
            log.debug("获取设置的信息：" + new String(zkoperator.getData(root + "/child3")));

            System.out.println("节点孩子信息:" + zkoperator.getChildString(root));
//            zkoperator.getChild(root);
//            System.out.println("root节点信息: " + zkoperator.getData(root + "/child3"));
            System.out.println("root节点信息: " + new String(zkoperator.getData("/root05171107" + "/child3"), "utf-8"));

            zkoperator.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
