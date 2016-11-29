package allocationAndCollection;

/**
 * Created by MHorse on 2016/10/14.
 */
public class Test {

    private static final int _1MB = 1024*1024;



    @org.junit.Test
    public void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    @org.junit.Test
    public void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    @org.junit.Test
    public void testTenuringThreshold(){
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB/4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
