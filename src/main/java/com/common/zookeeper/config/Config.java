package com.common.zookeeper.config;

/**
 * Created by MHorse on 2016/5/27.
 */
public interface Config {
    byte[] getConfig(String path) throws Exception;
}
