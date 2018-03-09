package com.common.zookeeper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.log4j.helpers.ThreadLocalMap;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by MHorse on 2016/6/22.
 */
public class Test {

    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64};
        Map map = new LinkedHashMap();
        map.put(1, "");
        map.put(4, "s");
        map.put(2, "2");
        System.out.println(map.toString());
        int arrayLength=a.length;
        //循环建堆
        for(int i=0;i<arrayLength-1;i++){
            //建堆
            buildMaxHeap(a,arrayLength-1-i);
            //交换堆顶和最后一个元素
            swap(a,0,arrayLength-1-i);
            System.out.println(Arrays.toString(a));
        }
    }
    //对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex){
        //从lastIndex处节点（最后一个节点）的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k=i;
            //如果当前k节点的子节点存在
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){
                    //若果右子节点的值较大
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if(data[k]<data[biggerIndex]){
                    //交换他们
                    swap(data,k,biggerIndex);
                    //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }
    //交换
    private static void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }

//    Tree tree =

    @org.junit.Test
    public void testP(){

        //在-128~127 之外的数
        Integer i1 =200;
        Integer i2 =200;
        System.out.println("i1==i2: "+(i1==i2));
        // 在-128~127 之内的数
        Integer i3 =100;
        Integer i4 =100;
        System.out.println("i3==i4: "+(i3==i4));

        System.out.println("Integer: ");

        Double d1 = Double.valueOf(100);
        Double d2 = Double.valueOf(200);
        System.out.println("Double: " + (d1 == d2));

        Boolean b1 = Boolean.valueOf(true);
        System.out.println(Integer.valueOf(1).equals(Long.valueOf(1L)));
        
    }

    @org.junit.Test
    public void testPackage(){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);//true
        System.out.println(e==f);//false
        System.out.println(c==(a+b));//true
        System.out.println(c.equals(a+b));//true
        System.out.println(g==(a+b));//false
        System.out.println(g.equals(a+b));//false
        System.out.println(g.equals(a + h));//true
    }

    @org.junit.Test
    public void testArray(){
        int[] array = {1, 2, 3};
        System.out.println(Arrays.toString(array));

        String str = "abcd";
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }

    @org.junit.Test
    public void testConstantPool(){
        String str1 = new String("hello");

        str1+="world";
        String str2 = "helloworld";
        String str3 = str1;
        System.out.println(str1==str2);
        System.out.println(str1 == str3);
        System.out.println(str2==str3);
    }

    @org.junit.Test
    public void testMap(){
        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 2);
        linkedHashMap.put(3, 3);
        Iterator iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
//        Collections.synchronizedCollection(hashMap)
        Collections.synchronizedMap(hashMap);
    }

    @org.junit.Test
    public void testQueue(){
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("poll="+queue.poll()); //返回第一个元素，并在队列中删除
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("element="+queue.element()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("===");
        System.out.println("peek="+queue.peek()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
    }

    @org.junit.Test
    public void testTime(){
        long timestamp = System.currentTimeMillis();
        org.joda.time.DateTime dateTime = new org.joda.time.DateTime(timestamp);
        long time = dateTime.plusDays(-4).withTimeAtStartOfDay().getMillis();
        System.out.println(time);
    }

    /*@Resource
    ThreadPoolHttpClient threadPoolHttpClient;*/




    public String timestampToString(long timestamp){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(timestamp);
        String timeString = simpleDateFormat.format(date);
        return timeString;
    }

    @org.junit.Test
    public void testTtimestampToString(){
        long timestamp = System.currentTimeMillis();
        System.out.println(timestampToString(timestamp));
    }


    @org.junit.Test
    public void testMD5(){
        System.out.println("搜狐新闻（资讯版）师傅给你发福利啦，猛戳链接还可领取1000狐币（http://t.cn/ROorwJi）".length());
        String key = "u8JUIS983hAl9M";
        String crypt = null;
        Md5Crypt.apr1Crypt(key, "");
        JSONObject identityObject = new JSONObject();
        identityObject.put("userId", "59b334b182fad50001ed2e6f");
        identityObject.put("crypt", crypt);
//        identityObject.put("identity", identity);
//        identityObject.put("realName", realName);
//        identityObject.put("id", id);
        System.out.println(identityObject.toString());
        System.out.println(identityObject.toString().length());
    }


    private Integer needExchage(String appVersion) {
        try {
            if (true) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 2;
        }
    }

    @org.junit.Test
    public void testNeedExchange(){
        System.out.println(needExchage("1.0.0"));
        System.out.println(needExchage("2.0.0"));
        System.out.println(needExchage("1.3.0"));
        System.out.println(needExchage("1.3.1"));
        System.out.println(needExchage("1.3.29"));
        System.out.println(needExchage("1.3.1.2"));
        System.out.println(needExchage("1.3"));
    }

    @org.junit.Test
    public void testlo(){
        int waitTime = 0;
        boolean isPoolMaximum = true;
        while (isPoolMaximum) {

            try {
                waitTime = waitTime + 10;
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (waitTime > 3000){
                System.out.println("waitTime: " + waitTime);
                break;
            }else {
                System.out.println("no wai  t" + waitTime);
            }
        }

    }

    @org.junit.Test
    public void testIsOverTime(){

        String timestamp = "1508329254000";
//        System.out.println(isOverTime(timestamp, 10*60*1000));
        System.out.println(Long.parseLong(timestamp));
        System.out.println(Long.valueOf(timestamp));
        System.out.println(isOverTime3333(timestamp));
    }

    public boolean isOverTime(String timestamp, long toleranceTime){
        return Math.abs(System.currentTimeMillis() -  Long.parseLong(timestamp))> toleranceTime;
    }

    private boolean isOverTime3333(String timestamp) {
        if (timestamp.length() == 10){
            timestamp = timestamp + "000";
        }
        System.out.println(timestamp);

        return isOverTime(String.valueOf(timestamp), 10*60*1000);
		/*long now=System.currentTimeMillis();
		long reportTime=Long.parseLong(timestamp);
		if(timestamp.length()==10)
		{
			reportTime=reportTime*1000;
		}
		return Math.abs(now-reportTime)>PointConstants.OVER_TIME;*/
    }

    @org.junit.Test
    public void testMax(){
        Math.max(Long.parseLong(null), 2);
    }

    @org.junit.Test
    public void testLength(){
        String userGuessResult = "{\"guessId\":\"6326284321636221953\",\"userId\":\"59e1b27c8fc6fd000176eca6\",\"source\":0,\"gainCount\":9087}";
        System.out.println(userGuessResult.length());
    }

    @org.junit.Test
    public void testTreeMap(){
        HashMap hashMap = new HashMap();
//        hashMap.va
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(10, "10a");
        treeMap.put(1, "1a");
        treeMap.put(5, "5a");
        treeMap.put(3, "3a");
        treeMap.put(6, "6a");

        System.out.println(treeMap.values());

        ArrayList collection = new ArrayList(treeMap.values());
        collection.subList(0, 3);
        System.out.println(collection.subList(0, 3));
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(collection.subList(0, 3));
        System.out.println(jsonArray.toJSONString());

    }

    @org.junit.Test
    public void testList(){
        List<String> list = new ArrayList<>();
        list.add("关键词1");
        list.add("关键词2");
        list.add("关键词3");
        System.out.println(list.toString());
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(list);
        System.out.println(jsonArray.toJSONString());
    }

    @org.junit.Test
    public void testSubString(){
        String userId = "594ce3f80cc07c00012b3f4a";

//        System.out.println(StringUtils.substring(userId, userId.length() - 1));
//        CharUtils
//        System.out.println(userId.endsWith("a"));
//        System.out.println(12%10);
//        System.out.println(1000 %10);
//        System.out.println(100 / 10);
//        Long number = null;
//        System.out.println(number);
//        long time = number;
//        System.out.println(time);
        long totalReadTimes = 0;
        totalReadTimes = Long.valueOf(getLong());
        System.out.println(totalReadTimes);
    }

    public Long getLong(){
        Long value = null;
        return value;
    }

    @org.junit.Test
    public void testIntegerParse(){
        System.out.println(Integer.parseInt("-10"));
        System.out.println(Integer.valueOf("01"));
    }

    @org.junit.Test
    public void testLongValueOf(){
//        System.out.println(Long.valueOf(null));
        Long value = null;
        value = getLong();
//        System.out.println(1 == value);
        Long number = 3L;
        System.out.println(number.compareTo(value));


    }

    @org.junit.Test
    public void testListOutOfBound() {
        System.out.println(System.currentTimeMillis());
        Long result = null;
//        List list = new ArrayList();
//        System.out.println(list.get(0));
        long SETNX_SUCCESS = 1L;
        System.out.println(SETNX_SUCCESS == result);

    }

    @org.junit.Test
    public void testItMap(){

        Map<String, String> map = null;
//        httpGet(map);

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "a");
        System.out.println(hashMap);

    }

    public void httpGet(Map<String, String> headerMap){
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
//            httpGet.setHeader(new BasicHeader(entry.getKey(), entry.getValue()));
            System.out.println(entry.getKey() + entry.getValue());
        }
    }

    @org.junit.Test
    public void testEasList() {

        String contentId = "[a, b, c]";
        String[] s = {"a", "b", "c"};
        List list = java.util.Arrays.asList(s);
        System.out.println(list);
    }

    @org.junit.Test
    public void testListRemove(){
        List<NoticeInfo> list = new LinkedList<>();
        List<NoticeInfo> noticeInfoList = new ArrayList<>();
        for (int i = 0; i < 10; i ++){
            NoticeInfo noticeInfo = new NoticeInfo();
            noticeInfo.setActionType(i);
            noticeInfo.setNoticeType(100 + i);
            String content = "这里是汉字 " + i;
            try {
                content = URLEncoder.encode(content, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            noticeInfo.setNoticeId(content);
            noticeInfoList.add(noticeInfo);
        }
        System.out.println(noticeInfoList.size());
        System.out.println(noticeInfoList);

        Iterator<NoticeInfo> noticeIterator = noticeInfoList.iterator();
        while(noticeIterator.hasNext()){
            NoticeInfo noticeInfo = noticeIterator.next();
            Integer noticType = noticeInfo.getNoticeType();
//            if(noticType == Constants.COMMENT_REPLY_TYPE || noticType == Constants.COMMENT_DIGG_TYPE){
            if(noticType > 105){
                System.out.println(noticType);
//                noticeIterator.remove();
                try {
                    noticeInfo.setNoticeId(URLDecoder.decode(noticeInfo.getNoticeId(), "utf-8"));
                    list.add(noticeInfo);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println(list.size());
        System.out.println(list);
    }


    @org.junit.Test
    public void testEncode(){

//        String content = "你   参与的竞猜“感恩节火鸡和土耳其同名“Turkey”，是否因为来自土耳其？”已经揭晓结果啦，你  猜++对了吗？";
        String content = "恭喜你成功邀请好友“130****1235”，搜狐新闻（资讯版）将奖励你3元现金(分7次发放)，悄悄告诉你，邀请的好友越多，奖励越多呦~";
        try {
            System.out.println(content);
            content = URLEncoder.encode(content, "utf-8");
            System.out.println(content);
            content = content.replaceAll("\\+", "%20"); // 将表示空格的“+”变为“%20”
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(content);
        try {
            content = URLDecoder.decode(content, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(content);
    }


    @org.junit.Test
    public void testClassLoader() {
        ThreadLocal threadLocal = new ThreadLocalMap();
        System.out.println(threadLocal.getClass().getClassLoader().toString());
    }

}
