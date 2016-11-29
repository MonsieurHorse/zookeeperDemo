package com.common.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by MHorse on 2016/5/16.
 */
public class ServiceTest {
    Service service = new Service();

    @Test
    public void testZKExist() throws KeeperException, InterruptedException {
        service.zkExist("/root4/child3");
    }

    @Test
    public void testZKGetChild() throws InterruptedException, IOException, KeeperException {
        service.zkGetChild("/root4/child3");
    }

}
