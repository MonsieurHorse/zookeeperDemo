package stringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.stuxuhai.jpinyin.ChineseHelper;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.DateTime;
import org.joda.time.Seconds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xxtea.XXTEA;

import java.io.*;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by MHorse on 2016/8/15.
 */
public class Test {

    public static final long DATE = 1498214111031L;
    public static final String IN_STR = "123456";
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    @org.junit.Test
    public void testListSplit(){
        String string = "çµå½± ";
        System.out.println(StringUtils.substringBetween("a[sfd]f[asd]", "[","]"));

    }

    String string = "04ad441f302122d1ad6bfa6905612706";
    @org.junit.Test
    public void testMD5(){

        System.out.println(string2MD5(IN_STR));
        System.out.println(convertMD5(string2MD5(IN_STR)));
        System.out.println(convertMD5(convertMD5(string2MD5(IN_STR))));

//        System.out.println(sign("", ));

    }

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }


    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String input_charset) {
        text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }
    /**
     * @param content
     * @param charset
     * @return
//     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

    @org.junit.Test
    public void testStream() throws IOException {
        File file = new File("C:\\document\\userIndexer201607120307.txt");

        InputStream in = new BufferedInputStream(new FileInputStream(file));

        Collection collection = new ArrayList(16);
        for (int i = 0; i<15 ; i++){
            collection.add(i*10);
        }
        System.out.println(collection.toString());
        Vector vector = new Vector();
        vector.add(3);
        Thread thread = new Thread();

    }

    @org.junit.Test
    public void testCalender(){
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("Europe/Zurich"));
        /*System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.getTimeZone());
        calendar = new GregorianCalendar(TimeZone.getTimeZone("America/Bahia"));
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.getTimeZone());*/
        calendar = new GregorianCalendar(TimeZone.getTimeZone("Asia/Beijing"));
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.getTimeZone());
        calendar.set(2009, 1, 29);
        System.out.println(calendar.getTime());

    }

    @org.junit.Test
    public void testItMap(){
        TreeMap<Integer, String> treeMap = new TreeMap();
        for (int i = 0; i < 10; i++) {
            Integer key = i;
            String b = "value" + i;
            treeMap.put(key, b);
        }

        System.out.println(treeMap.get(treeMap.firstKey()));
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap);
        // 第一种方法
        // 使用entrySet()方法生成一个由Map.entry对象组成的Set,
        // 而Map.entry对象包括了每个元素的"键"和"值".这样就可以用iterator了
          Iterator it = treeMap.entrySet().iterator();
          while (it.hasNext()) {
           // entry的输出结果如key0=value0等
           Map.Entry entry =(Map.Entry) it.next();
           Object key = entry.getKey();
           Object value=entry.getValue();
           System.out.println(entry);
           System.out.println(key);
           System.out.println(value);
          }
    }

    @org.junit.Test
    public void testTreeMapSort(){
        //不指定排序器
        TreeMap<String, String> treeMap1 = new TreeMap<String, String>();
        treeMap1.put("2", "1");
        treeMap1.put("b", "1");
        treeMap1.put("1", "1");
        treeMap1.put("a", "1");
        System.out.println("treeMap1="+treeMap1);

        //指定排序器
        TreeMap<String, String> treeMap2 = new TreeMap<String, String>(new Comparator<String>(){

            /*
             * int compare(Object o1, Object o2) 返回一个基本类型的整型，
             * 返回负数表示：o1 小于o2，
             * 返回0 表示：o1和o2相等，
             * 返回正数表示：o1大于o2。
             */
            public int compare(String o1, String o2) {

                //指定排序器按照降序排列
                return o2.compareTo(o1);
            }
        });
        treeMap2.put("2", "1");
        treeMap2.put("b", "1");
        treeMap2.put("1", "1");
        treeMap2.put("a", "1");
        System.out.println("treeMap2=" + treeMap2);
        treeMap2.containsKey("");
//        treeMap2.su
        Map map = new HashMap();
        map.containsKey("");
        map.put(1, 1);
        map.put(13, 13);
        map.put(17, 17);
        map.put(33, 33);
//        System.out.println(map.get(1).hashCode());
//        System.out.println(map.get(17).hashCode());
        Iterator iterator = map.keySet().iterator();
        while ( iterator.hasNext()){
            System.out.println(iterator.next().hashCode());
        }
    }

    @org.junit.Test
    public void testCompareTo(){
        Map map = new HashMap();
        map.put(1, "1");
        map.put(2, "2");
        System.out.println(map);
        SoftReference softReference = new SoftReference(map);
        System.gc();
        System.gc();
        System.gc();
        System.out.println(map);
        map = null;
        System.out.println(map);

        System.out.println("a".compareTo("d"));
//        Collections.sort();
    }

    @org.junit.Test
    public void testWeakReference(){
        WeakReference<String> sr = new WeakReference<String>(new String("hello"));

        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());

        String world = new String("world");
        WeakReference weakReference = new WeakReference(world);
        System.out.println(world);
        System.gc();
        System.out.println(world);
        ReferenceQueue referenceQueue = new ReferenceQueue();

    }

    @org.junit.Test
    public void testPhantomReference(){
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
        System.out.println(pr.get());
    }

    @org.junit.Test
    public void testAdd(){
        String string = "Sdfldkfsd";
        String str = StringUtils.substring(string, string.length() - 3, string.length());
        System.out.println(str);
        System.out.println(string.charAt(1));
        System.out.println(StringUtils.isAllLowerCase(string));
        System.out.println(Character.isLowerCase(string.charAt(1)));
    }

    @org.junit.Test
    public void testQueue(){
        Set hashSet = new LinkedHashSet((int) (1000/0.75));

        int max = 10;

        long time = System.currentTimeMillis();
        Random random = new Random();
        while (hashSet.size() < 15){
            hashSet.add(random.nextInt(max) +1);
        }
        System.out.println("time: " + (System.currentTimeMillis() - time) );
        System.out.println("hashSet: " + hashSet.size());
        System.out.println(hashSet);

    }

    @org.junit.Test
    public void testRandom(){
        Set<Integer> set = new TreeSet<Integer>();
        Random random = new Random();
        for (int i = 0; i< 99; i++){
            int rdm = random.nextInt(10);

            set.add(rdm);
            System.out.println(rdm);
        }

        System.out.println(random.equals(""));
        System.out.println(set.toString());
    }


    static class OOMObject{}

   /* public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while(true){
            list.add(new OOMObject());
        }
    }*/
    @org.junit.Test
    public void testOOM(){

        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }
    }

    @org.junit.Test
    public void testIntern(){
        String s1 = String.valueOf("hello world");
        String s2 = String.valueOf("hello world");
        String s3 = String.valueOf("hello world").intern();
        String s4 = String.valueOf("hello world");
        String s5 = "hello world";
        System.out.println("s1 == s2: " + s1 == s2);//false
        System.out.println("s3 == s4: " + s3 == s4);
        System.out.println("s3 == s5: " + s3 == s5);
    }

    @org.junit.Test
    public void testString(){

        String string = "hello whrld";
        string = string.replaceAll("hello", "world");
        System.out.println(string);
    }

    @org.junit.Test
    public void testBooleanDefaultValue(){
        System.out.println(booleanDefaultValue(null));
    }

    public Boolean booleanDefaultValue(Boolean b){
        if (Boolean.FALSE.equals(b)){
            return true;
        }else {
            return false;
        }
    }

    @org.junit.Test
    public void testIndexOf(){
        String string = "sdfsdfsdfsdf";
        System.out.println(string.indexOf("f"));
    }

    @org.junit.Test
    public void testJSONparseArray(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1", "1");
        jsonObject.put("key2", "2");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject);
        List<String> list = JSON.parseArray(jsonArray.toJSONString(), String.class);
        for (String string : list){
            System.out.println(string);
        }
    }

    @org.junit.Test
    public void testNumeric(){
        String num = "2";

        System.out.println(StringUtils.isNumericSpace(num));
        StringUtils.isNumeric("");
    }

    @org.junit.Test
    public void testLogger(){
        String topicId = "topicId";
        String deviceId = "deviceId";
        String userId = "userId";
        StringUtils.isEmpty("");
        logger.error("用户[{}] 使用设备[{}] 查看视频[{}]", new Object[]{userId, deviceId, topicId});
    }

    @org.junit.Test
    public void testIsBlank(){
        String blank = "   ";
        System.out.println(StringUtils.isBlank(blank));
    }

    @org.junit.Test
    public void testWebapp(){
        System.out.println(System.getenv());
    }

    @org.junit.Test
    public void  testStringLength(){
        String deviceId = "725090133b1e6bb946423b45c52b0665";
        System.out.println(deviceId.length());
//        deviceId.
        JSONObject jsonObject = new JSONObject(Boolean.parseBoolean("sdf"));
        jsonObject.getString("");
    }

    @org.junit.Test
    public void testJsonArray(){
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 10; i ++){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("key" + i, i);
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toString());
        System.out.println(jsonArray);
        System.out.println("+++++++++");
        JSONArray array = JSON.parseArray(jsonArray.toString());

        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        String[] strings = new String[10];
        int j = -9;

        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i< array.size(); i++){
            j= i;
            jsonObject = array.getJSONObject(i);
//            hashMap.put(i, jsonObject);
            hashMap.put(i, j);
//            arrayList.add(jsonObject);
            arrayList.add(j);
//            strings[i] = jsonObject.toString();
            strings[i] = String.valueOf(j);
        }
        System.out.println(hashMap);
        System.out.println(arrayList.toString());
        System.out.println(Arrays.toString(strings));

    }

    @org.junit.Test
    public void testCurrent(){
        long time = System.currentTimeMillis();

        System.out.println(time);
        System.out.println(String.valueOf(time).length());
    }

    @org.junit.Test
    public void testLength(){
        String ip = "123.126.70.237, 123.126.70.237";

        if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        System.out.println(ip);
    }

    @org.junit.Test
    public void testMessage(){
        int[] array = getEnvConfigInts("", new int[]{1,2,3,4});
        System.out.println(Arrays.toString(array));
    }

    public static int[] getEnvConfigInts(String config, int[] defaultConfig){
        String env = " , ";
        if (StringUtils.isBlank(env)){
            return defaultConfig;
        }
        String[] configs = StringUtils.split(env, ",");
        if (configs.length < 1){
            return defaultConfig;
        }
        List<Integer> list = new ArrayList<Integer>(configs.length);
        for (String conf : configs){
            if (StringUtils.isNumeric(conf)){
                list.add(Integer.valueOf(conf));
            }else {
                return defaultConfig;
            }
        }
        return Ints.toArray(list);
    }

    @org.junit.Test
    public void testLength2(){
        String no = "1";
        System.out.println(StringUtils.length(no));

        System.out.println(fenToYuan(1000));
        String name = null;

    }

    public String fenToYuan(int count) {
        DecimalFormat f = new DecimalFormat();
        f.applyPattern("#.##");
        return f.format((double)count/ 100);
    }

    public static void main(String[] args){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(DATE);
        System.out.println(simpleDateFormat.format(date));
    }

    // TODO: 2017/7/4

    Integer READ_ARTICLE_CODE = 6;
    @org.junit.Test
    public void testEquals(){

        System.out.println(hasValidateReadArticleParas("5", "1", "2", "4"));
    }

    private boolean hasValidateReadArticleParas(String changeType, String topicId, String topicHeight, String viewTime){
        if (!changeType.equals(READ_ARTICLE_CODE.toString()) || (StringUtils.isBlank(topicId) ||
                !StringUtils.isNumeric(topicHeight) || !StringUtils.isNumeric(viewTime))){
            return false;
        }
        return true;
    }

    @org.junit.Test
    public void testPair(){
        Pair<Integer, String> pair = Pair.of(10, "hello");
//        Pair.of(10, "hello");
        System.out.println(pair.getLeft());
        System.out.println(pair.getRight());
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }

    @org.junit.Test
    public void testJSONObject(){
        long startTime = 1499616000000L;
        DateTime dateTime = new DateTime();
        long endTime = dateTime.plusDays(1).withTimeAtStartOfDay().getMillis();
        int maxReward = 50;

        String startTimeStr = "9:00";
        String endTimeStr = "10:55";
        JSONObject jObject = new JSONObject();
        jObject.put("subTaskId", 1);
        jObject.put("startTime", startTimeStr);
        jObject.put("endTime", endTimeStr);
        jObject.put("hasDone", 1);

        String startTimeStr2 = "11:00";
        String endTimeStr2 = "14:00";
        JSONObject jObject2 = new JSONObject();
        jObject2.put("startTime", startTimeStr2);
        jObject2.put("endTime", endTimeStr2);
        jObject2.put("subTaskId", 2);
//        jObject2.put("hasDone", 1);

        JSONArray timesArray = new JSONArray();
        timesArray.add(jObject);
        timesArray.add(jObject2);
        JSONArray timesArray2 = new JSONArray();
        timesArray2.add(jObject2);

        JSONObject taskObject1 = new JSONObject();

        taskObject1.put("taskId", 1);
        taskObject1.put("startTime", startTime);
        taskObject1.put("endTime", endTime - 1);
        taskObject1.put("maxReward", maxReward);
        taskObject1.put("times", timesArray);

        JSONObject taskObject2 = new JSONObject();
        taskObject2.put("taskId", 2);
        taskObject2.put("startTime", endTime);
        taskObject2.put("endTime", 1502294400000L);
        taskObject2.put("maxReward", maxReward);
        taskObject2.put("times", timesArray2);

        JSONObject data = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(taskObject1);
        jsonArray.add(taskObject2);

        data.put("task", jsonArray);
        data.put("loadtime", System.currentTimeMillis());

        System.out.println(data);
    }

    @org.junit.Test
    public void testJoda(){
        DateTime dateTime = new DateTime();
        long time = dateTime.plusDays(1).withTimeAtStartOfDay().getMillis()-1;
        DateTime today = dateTime.withTimeAtStartOfDay();

        DateTime time1 = new DateTime(1501171199999L);
        System.out.println(time1);
        System.out.println(time1.withTimeAtStartOfDay());
        System.out.println(time);
        System.out.println(today);
        System.out.println(today.getMillis());
        System.out.println(today.equals(time1));
        System.out.println(today.withTimeAtStartOfDay().getMillis() == time1.withTimeAtStartOfDay().getMillis());
        System.out.println(today.withTimeAtStartOfDay().isEqual(time1.withTimeAtStartOfDay().getMillis()));

    }

    @org.junit.Test
    public void testGson(){
        Gson gson = new Gson();
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setName("name" + i);
            p.setAge(i * 5);
            persons.add(p);
        }
        String str = gson.toJson(persons);
//        gson.toJson(persons);
        System.out.println(str);
    }

    @org.junit.Test
    public void testStringToJsonArray(){
        String string = "[{\"earnCoin\":10,\"thatDaySigned\":0,\"isToday\":1,\"hasTreasure\":0},{\"earnCoin\":15,\"thatDaySigned\":0,\"isToday\":0,\"hasTreasure\":0},{\"earnCoin\":20,\"thatDaySigned\":0,\"isToday\":0,\"hasTreasure\":0},{\"earnCoin\":25,\"thatDaySigned\":0,\"isToday\":0,\"hasTreasure\":0},{\"earnCoin\":30,\"thatDaySigned\":0,\"isToday\":0,\"hasTreasure\":0},{\"earnCoin\":35,\"thatDaySigned\":0,\"isToday\":0,\"hasTreasure\":0},{\"earnCoin\":100,\"thatDaySigned\":0,\"isToday\":0,\"hasTreasure\":1}]";

        JSONArray jsonArray = JSON.parseArray(string);
        System.out.println(jsonArray);
    }

    public int getTimeDiff2Latest() {
        DateTime dateTime = new DateTime();
        return Seconds.secondsBetween(dateTime, dateTime.plusDays(1).withTimeAtStartOfDay()).getSeconds();
    }

    @org.junit.Test
    public void testGetTimeDiff2Latest(){
        System.out.println(getTimeDiff2Latest());
        System.out.println(1501516800 - 1501490643);

        System.out.println(getTimeOfToday());
    }

    @org.junit.Test
    public void testLong(){
        Long num = 0L;
        Long num2 = null;
        Long num3 = new Long(0);


        System.out.println(num);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num3 < 0);
//        System.out.println(num2 < 0);
        System.out.println(num.equals(num3));
    }

    public static long getTimeOfToday() {
        DateTime dateTime = new DateTime();
        return dateTime.withTimeAtStartOfDay().getMillis();
    }

    @org.junit.Test
    public void testTimeFormat(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(simpleDateFormat.format(date));

        System.out.println(getBeginTimeByDiff(-1));
    }

    public static long getBeginTimeByDiff(Integer diffDays) {
        DateTime dateTime = new DateTime();
        return dateTime.minusDays(diffDays).withTimeAtStartOfDay().getMillis();
    }

    private int getRandomReward(int minReward, int maxReward){
        Random random = new Random();
        int randomReward = random.nextInt(maxReward - minReward + 1);
        randomReward += minReward;
        return randomReward;
    }

    @org.junit.Test
    public void testGetRandomReward(){
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < 1000; i++){
            int random = getRandomReward(10, 50);
            if (treeMap.containsKey(random)){
                int count = treeMap.get(random) + 1;
                treeMap.put(random, count);
            }else {
                treeMap.put(random, 1);
            }
        }
        Iterator iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " ---  " + entry.getValue());
        }
    }

    @org.junit.Test
    public void testTime(){

        System.out.println(getMsOfDay("09:00"));
        System.out.println(getTimeString(32400000L, "HH:mm"));
    }
    private Integer getMsOfDay(String time) {
        String[] timeArray = time.split(":");
        Integer hour = Integer.valueOf(timeArray[0]);//小时
        Integer minute = Integer.valueOf(timeArray[1]);//分钟
        System.out.println(timeArray[0]);
        System.out.println(timeArray[1]);
        System.out.println(hour);
        System.out.println(minute);
        return 1000*60*60*hour+1000*60*minute;
    }

    private String getTimeString(long time, String format) {
        DateTime dateTime = new DateTime(time);
        return dateTime.toString(format);
    }

    @org.junit.Test
    public void testBR(){
        String message = "不要贪心，<br>每个任务只能参与一次哦";
        Long mun = 2L;
        String mmm = new String(mun.toString());

        System.out.println(message);

    }

    @org.junit.Test
    public void testinstanceof(){
        long num = 1L;
        Long big = 1L;
        System.out.println(big.equals(num));
    }

    private String getUserReadHistory(String userId, String topicId, Integer changeType) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("userRead");
        stringBuilder.append(":");
        stringBuilder.append(userId);
        stringBuilder.append(":");
        stringBuilder.append(topicId);
        stringBuilder.append(":");
        stringBuilder.append(changeType);
        return stringBuilder.toString();
    }
    @org.junit.Test
    public void testGetUserReadHistory(){
        System.out.println(getUserReadHistory("userId", "topicId000", 8));

        String timestamp = "1502437181";
        System.out.println(timestamp.length());

    }

    public boolean hasTimestampValid(String timestamp){
        return true;
    }

    public static Set<Integer> user_set = ImmutableSet.<Integer>builder()
            .add(1)
            .add(12)
            .build();

    @org.junit.Test
    public void testSet(){
        System.out.println(user_set.contains(1));
        System.out.println(user_set.contains(3));
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(45);
        System.out.println(hashSet);
    }

    public boolean versionFrom1Six(String appVersion) throws Exception{
        System.out.println(appVersion);
        if (StringUtils.isBlank(appVersion)){
            return false;
        }
        String[] versions = appVersion.split("\\.");

        System.out.println(Arrays.toString(versions));
        if (Integer.parseInt(versions[0]) > 1){
            return true;
        }
        if (Integer.parseInt(versions[0]) == 1 && Integer.parseInt(versions[1]) >= 6){
            return true;
        }
        return false;
    }

    @org.junit.Test
    public void testVersionFrom1Six(){
        try {
            System.out.println(versionFrom1Six("v1.5"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    @org.junit.Test
    public void testTimeForma(){
        System.out.println(getCurrentDate());
//        System.out.println(IdcardUtils.validateCard("348755197907209197"));
        System.out.println(IdentityUtils.IDCardValidate("348755197907209197d"));
    }

    private static String getCurrentDate() {
        DateTime dateTime = new DateTime();
        return dateTime.toString("MM");
    }

    @org.junit.Test
    public void testDecrpt(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", 1);
        jsonObject.put("key", "keyValue");

        String key = "1234567890";
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.toJSONString());
        String encrypt_data = XXTEA.encryptToBase64String(jsonObject.toString(), key);
        System.out.println(encrypt_data);

        String decrypt = XXTEA.decryptBase64StringToString(encrypt_data, key);
        System.out.println(decrypt);
        JSONObject object = JSON.parseObject(decrypt);
        System.out.println(object.get("a"));
        System.out.println(object.get("key"));
    }

    @org.junit.Test
    public void testPraseJson(){


        JSONObject valueObject = new JSONObject();
        valueObject.put("userId", "user09111053");
        valueObject.put("token", "0e3966fa8ffdc6b6161aef75f0bef569");
        valueObject.put("did", "0e3966fa8ffdc6b6161aef75f0bef569");
        valueObject.put("appName", "2");
        valueObject.put("sourceType", "1");
        valueObject.put("timestamp", 1496990695000L);
        valueObject.put("sign", "DEEBFC7A77A552848D86B3C2A284993C");
        valueObject.put("appVersion", "1.6.1");
        valueObject.put("mid", "eU2kDzZf/hHqEunlxS4rgAdoTJerfHf3xJj2xeELBqcKibJT");
        valueObject.put("pid", "zhangsan");
        valueObject.put("name", "张三");//姓名
        valueObject.put("identity", "541893197611011987");//身份证号码
        valueObject.put("os", "1");
//        String v = ValidateParamsSignUtil.xxTeaEncrypt(valueObject.toString(), "YEk7h1PcQ43B25");
//        System.out.println(v);
//        System.out.println(v.length());
//        System.out.println(v.equals("pgFOghAsjHWkA5Ur3BImEXaIYH6D1ct1d9jgVeKDV7W9OkqjGclp5bYSWp2f5WM1p9zAgEHnIudjejUnUIEXXGsZbRJIG/zWZKjQk54sVqSVpivEXR9rrNfEGhHxK6sPBiOpFMmkvKguGjxNKObXhegKAuvIaJeJLNKp+USbHm9Mu5VKbu5eI4mc6A2XkhuYggTtDZVztOtkgun9/rJopX0vBh7YDNYO1bO7zTCMzV88g0ccTDyRoZuE7Bfh4/lxnkURtBlWDLWeQyDpMYlukPyw3soSj35NHYL9lhJh33b2wRPn3/DSjBLOZciCa0gtxVovL21Gfin4+Zaexf3Q3tUiL0zsMUxV7vXzStHpY3KKM5rFb5LEAen9RDyCO3UgCSMrEKfgPgs/LCuh7LD/7QK7sbFzr51ADwGrBBuvkh++X6CjzxbeOAdxKTLNcspGLaEKgn4C6f+yXsTF7ZzR9OZY1xijQ6rg1wq2dQ=="));

//        System.out.println(ValidateParamsSignUtil.xxTeaEncrypt("0e3966fa8ffdc6b6161aef75f0bef569", "XSmpXne22Qc3cR"));
        /*String value = valueObject.getString("value");
        if (StringUtils.isBlank(value)){
            System.out.println("value  empty");
            return;
        }
        String valueDecrypt = ValidateParamsSignUtil.xxTeaDecrypt("123", "key");

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = JSON.parseObject(valueDecrypt);
        }catch (Exception e){
            System.out.println("jsonObject exception" + e);
            return;
        }
        if (null == jsonObject){
            System.out.println("jsonObject is empty");
            return;
        }
        System.out.println(jsonObject.toString());*/
    }

    @org.junit.Test
    public void testEncryptTime(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++){
            JSONObject valueObject = new JSONObject();
            valueObject.put("userId", "user" + i);
            valueObject.put("token", "0e3966fa8ffdc6b6161aef75f0bef569");
            valueObject.put("did", "0e3966fa8ffdc6b6161aef75f0bef569");
            valueObject.put("appName", "2");
            valueObject.put("sourceType", "1");
            valueObject.put("timestamp", 1);
            valueObject.put("sign", "DEEBFC7A77A552848D86B3C2A284993C");
            valueObject.put("appVersion", "1.6.1");
            valueObject.put("mid", "eU2kDzZf/hHqEunlxS4rgAdoTJerfHf3xJj2xeELBqcKibJT");
            valueObject.put("name", "zhangsan");
            valueObject.put("identity", "123");
//            String v = ValidateParamsSignUtil.xxTeaEncrypt(valueObject.toString(), "YEk7h1PcQ43B25");
        }
        //一万次421
        //百万次6205
        System.out.println(System.currentTimeMillis() - start);
    }

    @org.junit.Test
    public void testEncryptPartTime(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++){
            JSONObject valueObject = new JSONObject();
            valueObject.put("userId", "user" + i);
            valueObject.put("token", "0e3966fa8ffdc6b6161aef75f0bef569");
            valueObject.put("did", "0e3966fa8ffdc6b6161aef75f0bef569");
            valueObject.put("appName", "2");
            valueObject.put("sourceType", "1");
            valueObject.put("timestamp", 1);
            valueObject.put("sign", "DEEBFC7A77A552848D86B3C2A284993C");
            valueObject.put("appVersion", "1.6.1");
//            valueObject.put("mid", ValidateParamsSignUtil.xxTeaEncrypt("0e3966fa8ffdc6b6161aef75f0bef569", "YEk7h1PcQ43B25"));
            valueObject.put("name", "zhangsan");
            valueObject.put("identity", "123");
            valueObject.toString();
        }
        //一万次371
        //百万次 3879
        System.out.println(System.currentTimeMillis() - start);
    }

    @org.junit.Test
    public void testKeyLength(){
        System.out.println("oZUSHwjfwMKVEbm7Wu0WWEACT9U0".length());
        System.out.println("oZUSHwjfwMKVEbm7Wu0WWEACT9U0".length());
    }

    @org.junit.Test
    public void testHome(){
        JSONObject identityObject = new JSONObject();
        identityObject.put("userId", "5982aa0276035a0001a80d00");
        identityObject.put("identity", "374548198507019345");
        identityObject.put("realName", "张三");
        identityObject.put("id", 10);
//        String message = ValidateParamsSignUtil.xxTeaEncrypt(identityObject.toString(), "gjl7ZyVasJyH3P");
//        System.out.println(message);
//        System.out.println(message.getBytes().length);
        /*try {
            System.out.println(message.getBytes("UTF-8").length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
//        System.out.println(ValidateParamsSignUtil.xxTeaDecrypt(message, "gjl7ZyVasJyH3P"));

    }

    @org.junit.Test
    public void testDecrypt(){
//        System.out.println(ValidateParamsSignUtil.xxTeaDecrypt("z1bP9+OYZCPM8FYcs7QHdZfH9IB5fyx7LCnLp5Y/GKD9hCo6qIHimZUBqAgDNE4rOb81jL2RGlEH3OA7X+L9Zu0a1Qnb3bCxv8WgOGCDw3o07Ohu7/hhpzknGDekI2AgKa8WhTFzlI6YnsEOLPzmitb0oHa4OElq3SVzdbVwpXAVE9OdvSR/vZY+uMHitX2ZzRTtDOrldmnDrv8BhWTBLZcR9QYRrHA3d5SHYDaYj1yj9cPkfEoUhODU0uvWNTfF2MpPexGjswF6wDMTB2Z/K54g8bfztiE89uhrYO0tEIEIstMeKErihMxl25tKwcmvaMHTdd/FbX0FqkID/kAcr6IonAW7piQLHA/f0r6WAgSHrrdVZGh7bIOnR6mBeysGDeK8eCuGcruaHE4ZU5qCX04/DPm6eUadIAjYVblGWMjpo+Ht1R4Nkee0d9VY0qFgvRzqIK1uugG06xvkwSwkw9U0xcHQCOWUlQdkeu2HdaPipdvaILo7Ui79gDg003QIzag3qWXa2Z5tZq8z23kDy6J0d3U=", "YEk7h1PcQ43B25"));
    }

    @org.junit.Test
    public void testEqual(){
//        System.out.println(ValidateParamsSignUtil.isDidSignValid("6ec33e91-9f28-3bc4-9a71-edb2b620c702", ));
//        System.out.println(ValidateParamsSignUtil.xxTeaEncrypt("f2d0757a3a0a4ed152fa6114db772eca1", "XSmpXne22Qc3cR" ));
        System.out.println("i8N62qznYKriW+cBTaEXIQb1n/8NEsBAy2NufDG5cCS/fWvwWVr0xA==");
    }

    @org.junit.Test
    public void testNumrical(){
        System.out.println("0860707038440987300000448000CN01".length());
        System.out.println(StringUtils.isNumeric("0"));

        System.out.println(getEnvConfigInt("0", 80000));
    }

    public int getEnvConfigInt(String config, int defaultConfig) {
        String env = config;
        return StringUtils.isNumeric(env)?Integer.valueOf(env).intValue():defaultConfig;
    }

    public String token = "";
    @org.junit.Test
    public void testListToArray(){
        List<String> list = new ArrayList<String>();
        list = null;
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        /*String[] strings = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(strings));
        for (int i = 0; i < 10; i++){
            if (StringUtils.isEmpty(token)){
                System.out.println("token is empty");
                token = "hello";
            }
            System.out.println(i + token);
        }*/
    }

    @org.junit.Test
    public void testNull(){
        int status = false ? 1 : null;
        System.out.println(status);
    }

    @org.junit.Test
    public void testIsSimplifiedChinese(){
        String realName = "雪克来提·扎克尔.雪克来提·扎克尔";
        realName = "一、乙、乃、了、力、丁、刀、刁、二、又、人、入、七、十、几、口、干、工、弓、久、己、土、大、丈、女、己、巾、勺、丸、也、于、弋、巳、兀、三、下、上、乞、士、夕、千、子、寸、小、山、川、巳、才、凡、公、孔、亢、勾、中、之、丹、井、介、今、内、及、太、天、屯、斗、斤、牛、丑、支、允、元、勿、午、友、尤、尹、引、文、月、日、牙、王、云、匀、牛、四、丑、仁、什、切、升、收、壬、少、心、手、日、氏、水、尤、仍、双、尺、仇、止、才、不、互、分、匹、化、卡、卞、肥、反、夫、巴、幻、户、方、木、比、毛、仆、丰、火、片、古、切、可、瓜、甘、刊、五、丘、加、去、句、叫、外、巧、巨、玉、甲、令、加、占、主、巨、冬、他、代、只、仗、另、句、召、尼、正、田、旦、奴、凸、立、叮、仝、伏、台、奶、凹、五、外、央、右、未、永、以、戊、玉、瓦、由、幼、仕、巧、丘、仙、兄、司、且、史、左、世、出、市、玄、仔、冉、穴、示、生、申、充、主、仞、仟、册、加、去、只、叫、求、正、甲、申、石、匝、甩、丙、平、母、弘、末、包、本、弗、北、必、丕、半、布、皿、目、乏、禾、皮、疋、矛、乎、付、兄、卉、戊、民、冰、玄、白、卯、伉、光、匡、共、各、考、交、件、价、企、伍、伎、仰、吉、圭、曲、机、艮、六、仲、吉、州、朱、兆、决、匠、地、旨、朵、吏、列、年、劣、同、打、汀、至、臼、灯、竹、老、舟、伎、吊、吏、圳、的、宅、机、老、肉、虫、伊、仰、伍、印、因、宇、安、屹、有、羊、而、耳、衣、亦、吃、夷、奸、聿、丞、企、休、任、先、全、再、冲、刑、向、在、夙、如、宅、守、字、存、寺、式、戌、收、早、旭、旬、曲、次、此、求、系、肉、臣、自、舌、血、行、圳、西、休、交、件、企、匠、吉、尖、而、至、色、伏、后、名、回、好、妃、帆、灰、牟、百、份米、伐、亥、卉、冰、刑、合、向、旭、朴、系、行、汜、复、克、告、改、攻、更、杆、谷、况、伽、估、君、吴、吸、吾、圻、均、坎、研、完、局、岐、我、扣、杞、江、究、见、角、言、住、占、低、佃、况、里、冷、伶、利、助、努、君、吝、昌、壮、妓、妞、局、弄、廷、弟、彤、志、托、杖、杜、呆、李、江、男、究、良、见、角、具、皂、里、舟、佟、你、体、足、甸、町、豆、吞、玎、位、佐、佘、冶、吾、吟、吴、吻、完、尾、巫、役、忘、我、修、言、邑、酉、吟、吴、研、呆、角、七、伸、佐、作、些、伽、些、初、吹、呈、坐、孝、宋、岐、希、岑、床、序、巡、形、忍、成、杏、材、杉、束、村、杞、步、汝、汐、池、私、秀、赤、足、身、车、辰、系、占、伺、住、余、助、劭、劬、邵、吸、坐、壮、妆、局、床、志、汕、江、灶、见、即、却、克、早、何、布、伯、伴、佛、兵、判、别、含、坊、坂、吵、宏、旱、每、甫、牡、况、免、孚、孝、尾、巫、希、庇、形、忙、杏、呆、步、汛、贝、儿、供、侃、刻、卦、固、坤、姑、官、冈、庚、快、抗、昆、果、空、亟、其、具、券、卷、奇、委、季、宜、居、届、岢、岸、杰、佳、京、侄、佳、来、例、制、到、兔、两、典、卷、周、呢、坦、奈、妮、宙、定、居、屉、帖、底、店、征、忝、忠、念、技、投、政、枝、东、林、汰、决、玖、知、的、直、纠、金、两、乳、侏、佰、侗、佻、佬、具、冽、卓、拈、妲、妯、宕、岱、岭、帖、帙、底、抒、林、杼、沓、炉、竺、长、依、侑、味、夜、委、宜、宛、岳、岸、岩、往、亚、武、於、易、昂、旺、沅、沃、汪、物、艾、卧、佯、儿、咏、抑、昀、炎、杳、事、享、侍、使、侈、然、刹、刺、协、卒、洽、沁、取、受、步、垂、奇、始、炊、姓、妻、妾、尚、屈、弦、所、承、昌、升、昔、松、欣、沙、"+
                "沈、社、舍、炊、采、长、青、幸、亟、徇、佳、舍、儿、争、其、刷、券、制、效、卷、姐、姒、姗、季、炙、宗、届、岫、征、承、昔、析、枕、状、八、并、佩、函、和、命、坡、坪、奉、孟、帛、水、府、佛、彼、忽、或、戽、房、扮、枇、扶、放、昏、朋、服、明、杭、杯、枚、板、沛、沐、汾、版、牧、虎、门、阜、杷、盲、非、冠、奎、皈、客、故、柑、柯、况、看、科、肝、革、屋、癸、砍、禹、轨、页、九、亭、亮、柱、俊、侣、冒、段、劲、南、姬、姜、姣、宦、帝、度、痔、建、峙、待、律、怠、急、招、拒、拓、拙、拉、昭、架、柱、柳、注、治、炭、界、皆、突、纪、纣、耐、肚、致、计、订、军、酊、俐、胃、百、厘、咨、姝、姿、柁、沱、炭、妆、纣、重、珏、盅、眈、俄、俞、勇、威、娃、姻、姚、姨、屋、幽、彦、奕、哀、哇、玟、怡、押、映、昱、韦、油、泳、沿、姚、畏、烟、盈、禹、约、耶、衍、要、页、音、昱、易、柚、胤、易、信、侠、系、俗、促、俏、前、则、奏、型、姹、妊、姝、姿、室、宣、巷、咱、哉、思、性、施、昨、是、春、星、查、柴、栅、柔、染、泉、帅、甚、相、省、砂、祈、秋、穿、肖、重、首、酉、食、香、侵、俟、峙、旭、注、沐、炷、祉、贞、昌、泓、侯、保、便、冒、勉、匍、奔、品、佩、杯、封、哈、皇、拔、抱、怕、柏、柄、泌、法、泡、炳、玫、盆、眉、红、美、虹、秒、表、负、面、风、飞、眄、胃、勃、厚、咸、叛、孩、奂、屏、枰、某、河、泛、赴、库、恭、拱、格、桂、根、耕、耿、股、肯、贡、高、个、刚、哥、宫、径、挂、皋、径、徒、倜、恬、拯、指、拿、料、旅、晋、朕、桌、桔、桃、桐、洞、流、洛、酒、烈、特、玲、珍、真、矩、祝、秩、租、站、级、纸、纳、纽、者、肩、芝、记、讨、酌、酒、针、钉、只、挑、借、倒、值、俱、倪、倘、伦、兼、唐、哲、娘、旃、娟、娜、展、峻、准、凌、洲、套、爹、特、留、俩、倜、庭、恫、耻、烙、料、栗、株、津、玳、畜、砧、恩、按、案、鸟、洋、秧、翁、纹、耘、育、芽、芸、蚊、袁、烟、倚、原、员、埃、宴、峨、倚、娱、容、峪、晏、移、益、差、师、席、座、徐、恰、息、恕、肩、持、拳、拾、时、书、曹、校、朔、桑、栽、殊、气、洽、珊、祠、神、祖、秦、秤、索、素、纱、纾、纯、虔、讫、训、财、起、轩、芩、闪、迅、倩、幸、修、仓、城、夏、孙、宰、容、射、峡、厝、叟、奚、畜、春、乘、借、准、淞、宵、指、拭、牲、洵、洳、狩、兹、珊、炸、租、站、宸、挈、旁、晃、桓、活、洪、畔、亩、眠、破、炮、秘、粉、纺、肺、肥、航、般、芳、芙、花、配、马、侯、倍、俯、俸、们、圃、埋、娩、峰、肪、涵、畔、埔、害、恢、恍、恒、柏、派、洹、玻、泌、珉、祜、呗、国、寇、昆、康、苦、袍、规、贯、够、勘、崞、岗、梗、珙、偕、假、健、停、侦、剪、动、翎、念、基、坚、堂、堆、婧、寄、专、张、得、教、救、朗、条、梁、梯、械、梨、浙、浪、珠、略、皎、眷、窕、竟、第、终、累、舵、苓、架、诀、近、钓、顶、鸟、将、那、庶、振、挺、捉、捐、甜、祭、趾、囵、堆、凌、崃、带、帐、徕、悌、画、梁、梃、桶、町、娄、伟、偶、务、唯、问、婉、寅、尉、帷、庸、悟、悠、悦、敖、晚、梧、浴、眼、研、移、胃、苑、英、迎、野、鱼、欲、浣、翌、圉、乾、做、区、卿、参、售、启、商、唱、娶、妇、宿、崇、崎、崔、常、强、从、悄、叙、旋、晨、晟、族、消、爽、犀、祥、绅、细、紫、组、绍、婧、羞、习、邢、舷、船、茄、若、处、术、袖、设、讼、责、赦、雀、雪、顷、彩、常、孰、侦、匙、圊、执、将、专、就、峥、崧、巢、庶、彩、悉、施、曹、浙、笙、钏、阡、凰、毫、培、婚、婆、妇、密、彬、彪、患、斌、曼、海、浩、烽、班、瓶、毕、盒、符、邦、胡、背、胞、胖、舶、范、茅、苗、袍、被、觅、访、货、返、贩、闭、麦、麻、邦、壶、票、冕、副、埠、屏、涵、捕、敏、皓、梅、第、珩、艴、苹、敢、款、淦、筐、给、贵、辜、开、凯、昆、诒、询、几、蛟、植、堵、堤、奠、岚、帧、掌、掘、捷、掏、掎推、探、接、敦、景、智、晶、替、朝、椒、棠、栈、殖、淘、添、淡、" +
                "净、焦、街、诊、理、荔、眨、贴、屠、贷、轸、迢、迪、迦、量、钧、钮、间、集、杰、劳、单、婷、喋、传、塘、塔、暖、楠、殿、渡、汤、帏、幄、惟、掩、椅、涯、液、渊、焰、为、异、砚、围茵、越、阮、轶、雁、雅、寓、云、雯、媛、喻、贻、婺、焱、琬、琰、畲、劳、博、堡、报、富、寒、嵋、帽、幅、帮、弼、复、彭徨、偏、整、理、惠、扉、排、斑、酣、普、棉、棒、棚、涵、混、淼、淮、淝、牌、画、番、发、皓、脉、茗、评、贺、费、买、贸、迫、邯、闵、防、阪、黄、傅、傍、媒、媚、黑、瓿   匮、块、干、感、揆、手、楷、港、琨、莞、夸、鼓、该、贾、传、仅、涂、塔、塘、廊、谦、提、敬、斟、极、楠、殿汤、渡、绢、经、茎、莒、获、莅、庄、莉、蜀、里、装、解、詹、鼎、贾、路、迹、退、铃、钜、陀、电、雷、靖、顿、暖、桢、路、嫁、农、贮、贷、贴、轸、迪、钠、湍、琳、当、略、铃、鼓、励、庸、园、圆、奥、爱、意、扬、援、握、榆、业、杨、椰涌、渝、渭、游、炜、爷、烟、兽、犹、煜、碗、筠、义、肄、莞、莠、虞、蛾、裕、诣、郁、钰、雍、阿、预、饮、衙、莹、蓊、晕、渥、琬、琰、畹、筵、裔、淡、催、传、勤、势、嗣、塞、嵩、厦、新、喧、楸、楚、岁湘、测、凑、煦、琴、琪、琦、睡、祺、稔、稠、筮、粲、绣、群、圣、莎、裙、诩、诗、试、诠、详、资、载、送、铅、阻、雌、颂、驰、熙、暄、琼、塞、嵩、想、桢、椿、岁、渚、煮、琛、庄、裟、输、轼、幕、汇、惶、挥、描、换、楣、枫、湖、浑、渺、涣、煤烦、琶、琥、盟、睦、碑、禀、聘、腑、荷、莫、号、蜂、补、话、酩、附、颁、饭、晕、募、焕   廓、愧、沟、管、纲、诰、闺、魁、构、歌、恺、斡、荣构、嘏、通、连、这、甄、兢、喜、团、图、奖、嫡、对、僚、侥屡、嶂、崭、彰、廖、熊、溜、监、祯、种、端、箕、筝、精、绿、紧、绫、纶、置、璋、畅、榔、糍、滇、尔、莱、赵、铬、领、瑙、奁、闻、嫣、愿、温、源、溢、尔、瑜、瑛、瑗、玮、与舞、苑、诱、语、郢、银、摇、榕、荣、温、荥、溶、菸、菀、鞅、瑛、僖、逑、速、逍、肾、寿、塾、尘、嫩、实、像、侨、岖、慈滋、沧、溶、溪、熊、狮、瑞、瑟、硕、算、粹、绸、综、绰、绮、翠、菁、菜、菖、裳、认、誓、诵、说、诚、轻、菘、造、速、衔、铨、限、需、韶、饲、饰、旗、畅、荣、榕、齐、熏、僦、尝、墅、奖、实、寨、慎、准、溯、搴、逢、梦、仆、幕、滑、瑚、珲、碧、福、绵、翡、腑、萍华、菩、蜜、裴、豪、宾、辅、郝、铭、阀、陌、颇、饮、凤、鸣、榜、槐、滏  宽、广、慷、惯、概、瑰、葛、葵、课、逵、郭、稿、靠溉、锆、俭、著、价、厉、剧、剑、刘、妖、履、帜、弹、徵、德虑、摘、敌、整、暂、椿、闾、乐、楼、樟、滴、渐、涨、浆、练、缔、蒂、骀、落、董、葶、蝶、调、谆、谈、诋、诤、谅、论、质、驼、践、轮、逮、进、醇、铝、阵、震、霆、驾、驻、稽、稻、稷、节、剪、几、鲁、黎、侬、涤、墩、幢、嶙、锻、褚、亿、仪、影、慰、忧、乐、样、欧、毅、演、渔、熬、熠熨、瑶、缘、纬、腰、万、莹、叶、苇、谊、逸、邮、阅、院、鞍、颐、养、欲、颍、粗、缓、卫、葳、骑、妩、鉴、署、啸、增、婵、审、层、厂、厨、厮、庆、摧、数、枢漆、熟、热、线、肠、兴、萱、冲、褚、谁、请、贤、赏、赐、趣、娴、醉、锐、销、爽、霄、驷、确、磁、穷、箭、箱、竖、辍、帜、漩、渐、箴、节、绪、翦、葸、诤、谆、质、醇、罚、划、哗、坟、墨、币、庙、废、慧、慕、慢、暮、樊标、模、流、浒、汉、满、漫、漂、玛、缓、编、腹、铺、葆、葡、复、卖、赋、辉、辈、部、锋、陛、盘、码、篇、范、麾、劈、幡、慧、摩、沪、漠、磐、褒、弼、荭   窥、糕、膏、盖、钢、龟、购、器、垦、横、橄、篙、馆尽、坛、导、惮、战、撰、整、历、瞳、昙、暨、机、橘、洁、潭、灯、瑾、璋、庐、积、筑、蒸、诸、、谛、诺、练、猪、赖、蹄、辑、道、达、都、录、锦、锭、陆、陶、陵、霓、霖、静、颊、头、雕、疆、腿、臻、赚、骆、莅、俦、橙、润、澈、笃、缙、萤   萤、卫、谓、谒、谙、谕、豫、逾、游、运、阴、余、壅赢、蓉、蓊、勋、儒、器、学、宪、熹、憧、晓、桥、樵、橙、橡、树润、潮、甑、莳、璇、聪、融、亲、谌、谐、输、遂、醒、" +
                "钱、错、陈、陲、赛、蓄、苍、侪、澍、莼、谊、铮、锡、阊、桦、壁、奋、播、抚、横、潘、磨、蒙、衡、谋、讳、讽辨、锚、陪、默、蒲、蓓、滨、嬖、凭、颖、蓉、运、阴、馀 恳、桧、糠、馆、阶、瞰、励、岭、懂、挡、担、据、捡、激、浓、烛、瞳、璐、矶磷、绩、联、胶、膛、临、举、莲、蔗、蒋、讲、递、辗、镀、锻、钟、键、隆、队、骏、黛、点、泽、沣、潞、澄、优、婴、屿、狱、赢、应、忆、拥、澳、营、蔚、荫、舆锾、闱、阳、偿、择、擅、操、泽、澡、燧、禧、穗、簇、纵、总、聪声、膝、襄、谦、逮、邹、乡、隋、虽、霞、霜、鲜、戏、鸿、壕、嫔、弥、帮、桧、篷、缝、繁、褒、锚、韩、蔓徵、擘、扶  柜、圹、归、缋、蒉、磬、纩、戴、拟、抬、挤、爵、涛、礼、简、粮、职、旧、蕉、谨转、遮、题、镇、储、藜、芷、迟、鲤、翼、芸、讴、医、隘、额、瑷、莸、镒、隗、彝、潍、储、丛、曙、湿、织、萧、蕊、蝉、瑞、适、双、绣、锁垒、戴、断、柠、涛、泞、璐、礼、粮、藜、槟、滨、获、壁、环、蕃、丰、庞、璧、馥   扩、关、铿、庐、疆、祷、荐、勒、襟、谭、证、轿、辽、邻、郑、邓类、鲸、丽、麓、镜、觉、际、橹、栎、泺、辚、链、韵、稳、薏、薇、膺、臆、蚁、袄、遗、雾、愿、艳、蓣蕹、韫、玺、薛、薪、绳、蟹、识、赞、遵、迁、选、庞、渖、荐谯、镟、锵、镞、铲、际、颡、鹑、暹、攀、簿、绘、鹏、庞、瀑、宝、祢、薜、谱、镆、镘  矿、阚、岿、藉、蓝、拢、沥、泷、竞、篮、罗、舰、觉、警、钟、露、腾、党、枥、槠、滤、濑、炉、窦、笞、筹、镦、荩、严、瀛、耀、译、议、邀、懿、赢、萨、藏、薰、壤、悬、曦、琼、筹、脐、馨、释、献、坏、孀、籍、藉、谵、锈、钟、宝、怀、瀚、缤、还、迈、飘、膑、朦、濒、铧   顾、钚、俪、栏、铁、鸡、镯、藤、览、镭、铎、铛、膑、丽、斓、樱、艺、藕、誉、跃、迩、莺、险、续、随、属、攘、誉、茑、鸡、藩、轰、辩、癖、霸、鹤、钚  灌、垄、叠、笼、听、芦、览、读、铸、籁、苈、链、懿、蔼、隐、璎、蕴、鳙、欢、边、鳗、镔、沣、镬  矿、恋、兰、体、滩、铄、鳞、驿、验、缨、织、显、钻、变、蘩 罐、赣、雳、灵、陇、酿、鹰、霭、坝、嬖 观、戆、厅、篱、钥、瑷、镶、黉、颢 逻、驴、湾、灒 銮、骥、湾、钻、骧 鹦、艳 鹳、郁 吁";

//        realName = "壹乙乃了力丁刀刁二又人入七十幾口幹工弓久己土大丈女己巾勺丸也於弋巳兀三下上乞士夕千子寸小山川巳才凡公孔亢勾中之丹井介今內及太天屯鬥斤牛醜支允元勿午友尤尹引文月日牙王雲勻牛四醜仁什切升收壬少心手日氏水尤仍雙尺仇止才不互分匹化卡卞肥反夫巴幻戶方木比毛仆豐火片古切可瓜甘刊五丘加去句叫外巧巨玉甲令加占主巨冬他代只仗另句召尼正田旦奴凸立叮仝伏臺奶凹五外央右未永以戊玉瓦由幼仕巧丘仙兄司且史左世出市玄仔冉穴示生申充主仞仟冊加去只叫求正甲申石匝甩丙平母弘末包本弗北必丕半布皿目乏禾皮疋矛乎付兄卉戊民冰玄白卯伉光匡共各考交件價企伍伎仰吉圭曲機根六仲吉州朱兆決匠地旨朵吏列年劣同打汀至臼燈竹老舟伎吊吏圳的宅機老肉蟲伊仰伍印因宇安屹有羊而耳衣亦吃夷奸聿丞企休任先全再沖刑向在夙如宅守字存寺式戌收早旭旬曲次此求系肉臣自舌血行圳西休交件企匠吉尖而至色伏後名回好妃帆灰牟百份米伐亥卉冰刑合向旭樸系行記復克告改攻更桿谷況伽估君吳吸吾圻均坎研完局岐我扣杞江究見角言住占低佃況裏冷伶利助努君吝昌壯妓鈕局弄廷弟彤誌托杖杜呆李江男究良見角具皂裏舟佟妳體足甸釘豆吞丁位佐佘冶吾吟吳吻完尾巫役忘我修言邑酉吟吳研呆角七伸佐作些伽些初吹呈坐孝宋岐希岑床序巡形忍成杏材杉束村杞步汝汐池私秀赤足身車辰系占伺住余助劭劬邵吸坐壯妝局床誌汕江竈見即卻克早何布伯伴佛兵判別含坊阪吵宏旱每甫牡況免孚孝尾巫希庇形忙杏呆步汛貝兒供侃刻卦固坤姑官岡庚快抗昆果空亟其具券卷奇委季宜居屆苛岸傑佳京侄佳來例制到兔兩典卷周呢坦奈妮宙定居屜帖底店征忝忠念技投政枝東林汰決玖知的直糾金兩乳侏佰侗佻佬具冽卓拈妲妯宕岱嶺帖帙底抒林抒踏爐竺長依侑味夜委宜宛嶽岸巖往亞武於易昂旺元沃汪物艾臥佯兒詠抑昀炎杳事享侍使侈然剎刺協卒洽沁取受步垂奇始炊姓妻妾尚屈弦所承昌升昔松欣沙沈社舍炊采長青幸亟徇佳舍兒爭其刷券制效卷姐似姍季炙宗屆岫征承昔析枕狀八並佩函和命坡坪奉孟帛水府佛彼忽或戽房扮枇扶放昏朋服明杭杯枚板沛沐汾版牧虎門阜杷盲非冠奎皈客故柑柯況看科肝革屋癸砍禹軌頁九亭亮柱俊侶冒段勁南姬姜姣宦帝度痔建峙待律怠急招拒拓拙拉昭架柱柳註治炭界皆突紀紂耐肚致計訂軍酊俐胃百厘咨殊姿柁沱炭妝紂重玨盅眈俄俞勇威娃姻姚姨屋幽彥奕哀哇玟怡押映昱韋油泳沿姚畏煙盈禹約耶衍要頁音昱易柚胤易信俠系俗促俏前則奏型姹妊殊姿室宣巷咱哉思性施昨是春星查柴柵柔染泉帥甚相省砂祈秋穿肖重首酉食香侵俟峙旭註沐主祉貞昌泓侯保便冒勉葡奔品佩杯封哈皇拔抱怕柏柄泌法泡炳玫盆眉紅美虹秒表負面風飛眄胃勃厚鹹叛孩奐屏枰某河泛赴庫恭拱格桂根耕耿股肯貢高個剛哥宮徑掛臯徑徒倜恬拯指拿料旅晉朕桌桔桃桐洞流洛酒烈特玲珍真矩祝秩租站級紙納紐者肩芝記討酌酒針釘只挑借倒值俱倪倘倫兼唐哲娘旃娟娜展峻準淩洲套爹特留倆倜庭恫恥烙料栗株津玳畜砧恩按案鳥洋秧翁紋耘育芽蕓蚊袁煙倚原員埃宴峨倚娛容峪晏移益差師席座徐恰息恕肩持拳拾時書曹校朔桑栽殊氣洽珊祠神祖秦秤索素紗紓純虔訖訓財起軒芩閃迅倩幸修倉城夏孫宰容射峽昔叟奚畜春乘借準淞宵指拭牲旬如狩茲珊炸租站辰挈旁晃桓活洪畔畝眠破炮秘粉紡肺肥航般芳芙花配馬侯倍俯俸們圃埋娩峰肪涵畔埔害恢恍恒柏派洹玻泌瑉祜唄國寇昆康苦袍規貫夠勘崞崗梗拱偕假健停偵剪動翎念基堅堂堆婧寄專張得教救朗條梁梯械梨浙浪珠略皎眷窕竟第終累舵苓架訣近釣頂鳥將那庶振挺捉捐甜祭趾圇堆淩崍帶帳徠悌畫梁梃桶釘婁偉偶務唯問婉寅尉帷庸悟悠悅敖晚梧浴眼研移胃苑英迎野魚欲浣翌幸乾做區卿參售啟商唱娶婦宿崇崎崔常強從悄敘旋晨晟族消爽犀祥紳細紫組紹婧羞習邢舷船茄若處術袖設訟責赦雀雪頃彩常孰偵匙青執將專就崢崧巢庶彩悉施曹浙笙釧阡凰毫培婚婆婦密彬彪患斌曼海浩烽班瓶畢盒符邦胡背胞胖舶範茅苗袍被覓訪貨返販閉麥麻邦壺票冕副埠屏涵捕敏皓梅第珩艴蘋敢款淦筐給貴辜開凱昆詒詢幾蛟植堵堤奠嵐幀掌掘捷掏椅推探接敦景智晶替朝椒棠棧殖淘添淡凈焦街診理荔眨貼屠貸軫迢迪迦量鈞鈕間集傑勞單婷喋傳塘塔暖楠殿渡湯幃幄惟掩椅涯液淵焰為異硯圍茵越阮軼雁雅寓雲雯媛喻貽婺火琬琰畬勞博堡報富寒嵋帽幅幫弼復彭徨偏整理惠扉排斑酣普棉棒棚涵混渺淮淝牌畫番發皓脈茗評賀費買貿迫邯閔防阪黃傅傍媒媚黑瓿匱塊幹感揆手楷港琨莞誇鼓該賈傳僅塗塔塘廊謙提敬斟極楠殿湯渡絹經莖莒獲蒞莊莉蜀裏裝解詹鼎賈路跡退鈴鉅陀電雷靖頓暖楨路嫁農貯貸貼軫迪鈉湍琳當略鈴鼓勵庸園圓奧愛意揚援握榆業楊椰湧渝渭遊煒爺煙獸猶煜碗筠義肄莞秀虞蛾裕詣郁鈺雍阿預飲衙瑩蓊暈渥琬琰畹筵裔淡催傳勤勢嗣塞嵩廈新喧楸楚歲湘測湊煦琴琪琦睡祺稔稠筮粲繡群聖莎裙詡詩試詮詳資載送鉛阻雌頌馳熙暄瓊塞嵩想楨椿歲諸煮琛莊裟輸軾幕匯惶揮描換楣楓湖渾渺渙煤煩琶琥盟睦碑稟聘腑荷莫號蜂補話酩附頒飯暈募煥廓愧溝管綱誥閨魁構歌愷斡榮構嘏通連這甄兢喜團圖獎嫡對僚僥屢章嶄彰廖熊溜監禎種端箕箏精綠緊綾綸置璋暢榔糍滇爾萊趙鉻領瑙奩聞嫣願溫源溢爾瑜瑛援瑋與舞苑誘語郢銀搖榕榮溫滎溶淤菀鞅瑛僖逑速逍腎壽塾塵嫩實像僑嶇慈滋滄溶溪熊獅瑞瑟碩算粹綢綜綽綺翠菁菜菖裳認誓誦說誠輕松造速銜銓限需韶飼飾旗暢榮榕齊熏就嘗墅獎實寨慎準溯搴逢夢仆幕滑瑚琿碧福綿翡腑萍華菩蜜裴豪賓輔郝銘閥陌頗飲鳳鳴榜槐滏寬廣慷慣概瑰葛葵課逵郭稿靠溉鋯儉著價厲劇劍劉妖履幟彈徵德慮摘敵整暫椿閭樂樓樟滴漸漲漿練締蒂駘落董葶蝶調諄談詆諍諒論質駝踐輪逮進醇鋁陣震霆駕駐稽稻稷節剪幾魯黎儂滌墩幢嶙鍛褚億儀影慰憂樂樣歐毅演漁熬熠熨瑤緣緯腰萬瑩葉葦誼逸郵閱院鞍頤養欲潁粗緩衛葳騎嫵鑒署嘯增嬋審層廠廚廝慶摧數樞漆熟熱線腸興萱沖褚誰請賢賞賜趣嫻醉銳銷爽霄駟確磁窮箭箱豎輟幟漩漸箴節緒翦葸諍諄質醇罰劃嘩墳墨幣廟廢慧慕慢暮樊標模流滸漢滿漫漂瑪緩編腹鋪葆葡復賣賦輝輩部鋒陛盤碼篇範麾劈幡慧摩滬漠磐褒弼葒窺糕膏蓋鋼龜購器墾橫橄篙館盡壇導憚戰撰整歷瞳曇暨機橘潔潭燈瑾璋廬積築蒸諸諦諾練豬賴蹄輯道達都錄錦錠陸陶陵霓霖靜頰頭雕疆腿臻賺駱蒞儔橙潤澈篤縉螢螢衛謂謁諳諭豫逾遊運陰余壅贏蓉蓊勛儒器學憲熹憧曉橋樵橙橡樹潤潮甑蒔璇聰融親諶諧輸遂醒錢錯陳陲賽蓄蒼儕澍蒓誼錚錫閶樺壁奮播撫橫潘磨蒙衡謀諱諷辨錨陪默蒲蓓濱嬖憑穎蓉運陰餘懇檜糠館階瞰勵嶺懂擋擔據撿激濃燭瞳璐磯磷績聯膠膛臨舉蓮蔗蔣講遞輾鍍鍛鐘鍵隆隊駿黛點澤灃潞澄優嬰嶼獄贏應憶擁澳營蔚蔭輿鍰闈陽償擇擅操澤澡燧喜穗簇縱總聰聲膝襄謙逮鄒鄉隋雖霞霜鮮戲鴻壕嬪彌幫檜篷縫繁褒錨韓蔓徵擘扶櫃壙歸繢蕢磬纊戴擬擡擠爵濤禮簡糧職舊蕉謹轉遮題鎮儲藜芝遲鯉翼蕓謳醫隘額璦蕕鎰愧彜濰儲叢曙濕織蕭蕊蟬瑞適雙繡鎖壘戴斷檸濤濘璐禮糧藜檳濱獲壁環蕃豐龐璧馥擴關鏗廬疆禱薦勒襟譚證轎遼鄰鄭鄧類鯨麗麓鏡覺際櫓櫟濼轔鏈韻穩薏薇膺臆蟻襖遺霧願艷蕷蕹韞璽薛薪繩蟹識贊遵遷選龐瀋薦譙鏇鏘鏃鏟際顙鶉暹攀簿繪鵬龐瀑寶禰薜譜鏌鏝礦闞巋藉藍攏瀝瀧競籃羅艦覺警鐘露騰黨櫪櫧濾瀨爐竇笞籌鐓藎嚴瀛耀譯議邀懿贏薩藏薰壤懸曦瓊籌臍馨釋獻壞孀籍藉譫銹鐘寶懷瀚繽還邁飄臏朦瀕鏵顧鈈儷欄鐵雞鐲藤覽鐳鐸鐺臏麗斕櫻藝藕譽躍邇鶯險續隨屬攘譽蔦雞藩轟辯癖霸鶴鈈灌壟疊籠聽蘆覽讀鑄籟藶鏈懿藹隱瓔蘊鱅歡邊鰻鑌灃鑊礦戀蘭體灘鑠鱗驛驗纓織顯鉆變蘩罐贛靂靈隴釀鷹靄壩嬖觀戇廳籬鑰璦鑲黌顥邏驢灣灒鑾驥灣鉆驤鸚艷鸛郁籲";
        realName = realName.replaceAll("、", "").replaceAll(" ", "");
        System.out.println(realName);
        String[] array = realName.split("");
        long startTime = System.currentTimeMillis();
//        System.out.println(isSimplifiedChinese(realName));
        for (String name : array){
            isSimplifiedChinese(name);
            /*if (isSimplifiedChinese(name)){
                System.out.println(name + "***************************************************");
            }*/
//            System.out.println(name + " : " + isSimplifiedChinese(name));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - startTime));

        System.out.println(realName.length());
    }
    public boolean JGZ(String zj){
        boolean flog = false;
        Matcher m = Pattern.compile("[\\u4e00-\\u9fa5]*").matcher(zj);
        if(m.matches()){
            flog = true;
        }
        return flog;
    }

    public boolean isSimplifiedChinese(String realName){
//        realName = realName.trim();
//        System.out.println(realName.length());
        int length = realName.length();
        /*if (length < 2 || length > 20){
            return false;
        }*/
        Pattern pattern = Pattern.compile("[[\\u4e00-\\u9fa5]+[﹒·.]?[\\u4e00-\\u9fa5]+]*");
        Matcher matcher = pattern.matcher(realName);
        return matcher.matches();
    }

    @org.junit.Test
    public void testReplace(){
        String name = "你是谁你";
        name = name.replaceAll("你", "我");
        System.out.println(name);
        System.out.println("··.");
    }


    @org.junit.Test
    public void testWWW(){
        String realName = "雪克来提·扎克尔.雪克来提·扎克尔";
        //简体字
//        realName = "一乙乃了力丁刀刁二又人入七十几口干工弓久己土大丈女己巾勺丸也于弋巳兀三下上乞士夕千子寸小山川巳才凡公孔亢勾中之丹井介今内及太天屯斗斤牛丑支允元勿午友尤尹引文月日牙王云匀牛四丑仁什切升收壬少心手日氏水尤仍双尺仇止才不互分匹化卡卞肥反夫巴幻户方木比毛仆丰火片古切可瓜甘刊五丘加去句叫外巧巨玉甲令加占主巨冬他代只仗另句召尼正田旦奴凸立叮仝伏台奶凹五外央右未永以戊玉瓦由幼仕巧丘仙兄司且史左世出市玄仔冉穴示生申充主仞仟册加去只叫求正甲申石匝甩丙平母弘末包本弗北必丕半布皿目乏禾皮疋矛乎付兄卉戊民冰玄白卯伉光匡共各考交件价企伍伎仰吉圭曲机艮六仲吉州朱兆决匠地旨朵吏列年劣同打汀至臼灯竹老舟伎吊吏圳的宅机老肉虫伊仰伍印因宇安屹有羊而耳衣亦吃夷奸聿丞企休任先全再冲刑向在夙如宅守字存寺式戌收早旭旬曲次此求系肉臣自舌血行圳西休交件企匠吉尖而至色伏后名回好妃帆灰牟百份米伐亥卉冰刑合向旭朴系行汜复克告改攻更杆谷况伽估君吴吸吾圻均坎研完局岐我扣杞江究见角言住占低佃况里冷伶利助努君吝昌壮妓妞局弄廷弟彤志托杖杜呆李江男究良见角具皂里舟佟你体足甸町豆吞玎位佐佘冶吾吟吴吻完尾巫役忘我修言邑酉吟吴研呆角七伸佐作些伽些初吹呈坐孝宋岐希岑床序巡形忍成杏材杉束村杞步汝汐池私秀赤足身车辰系占伺住余助劭劬邵吸坐壮妆局床志汕江灶见即却克早何布伯伴佛兵判别含坊坂吵宏旱每甫牡况免孚孝尾巫希庇形忙杏呆步汛贝儿供侃刻卦固坤姑官冈庚快抗昆果空亟其具券卷奇委季宜居届岢岸杰佳京侄佳来例制到兔两典卷周呢坦奈妮宙定居屉帖底店征忝忠念技投政枝东林汰决玖知的直纠金两乳侏佰侗佻佬具冽卓拈妲妯宕岱岭帖帙底抒林杼沓炉竺长依侑味夜委宜宛岳岸岩往亚武於易昂旺沅沃汪物艾卧佯儿咏抑昀炎杳事享侍使侈然刹刺协卒洽沁取受步垂奇始炊姓妻妾尚屈弦所承昌升昔松欣沙沈社舍炊采长青幸亟徇佳舍儿争其刷券制效卷姐姒姗季炙宗届岫征承昔析枕状八并佩函和命坡坪奉孟帛水府佛彼忽或戽房扮枇扶放昏朋服明杭杯枚板沛沐汾版牧虎门阜杷盲非冠奎皈客故柑柯况看科肝革屋癸砍禹轨页九亭亮柱俊侣冒段劲南姬姜姣宦帝度痔建峙待律怠急招拒拓拙拉昭架柱柳注治炭界皆突纪纣耐肚致计订军酊俐胃百厘咨姝姿柁沱炭妆纣重珏盅眈俄俞勇威娃姻姚姨屋幽彦奕哀哇玟怡押映昱韦油泳沿姚畏烟盈禹约耶衍要页音昱易柚胤易信侠系俗促俏前则奏型姹妊姝姿室宣巷咱哉思性施昨是春星查柴栅柔染泉帅甚相省砂祈秋穿肖重首酉食香侵俟峙旭注沐炷祉贞昌泓侯保便冒勉匍奔品佩杯封哈皇拔抱怕柏柄泌法泡炳玫盆眉红美虹秒表负面风飞眄胃勃厚咸叛孩奂屏枰某河泛赴库恭拱格桂根耕耿股肯贡高个刚哥宫径挂皋径徒倜恬拯指拿料旅晋朕桌桔桃桐洞流洛酒烈特玲珍真矩祝秩租站级纸纳纽者肩芝记讨酌酒针钉只挑借倒值俱倪倘伦兼唐哲娘旃娟娜展峻准凌洲套爹特留俩倜庭恫耻烙料栗株津玳畜砧恩按案鸟洋秧翁纹耘育芽芸蚊袁烟倚原员埃宴峨倚娱容峪晏移益差师席座徐恰息恕肩持拳拾时书曹校朔桑栽殊气洽珊祠神祖秦秤索素纱纾纯虔讫训财起轩芩闪迅倩幸修仓城夏孙宰容射峡厝叟奚畜春乘借准淞宵指拭牲洵洳狩兹珊炸租站宸挈旁晃桓活洪畔亩眠破炮秘粉纺肺肥航般芳芙花配马侯倍俯俸们圃埋娩峰肪涵畔埔害恢恍恒柏派洹玻泌珉祜呗国寇昆康苦袍规贯够勘崞岗梗珙偕假健停侦剪动翎念基坚堂堆婧寄专张得教救朗条梁梯械梨浙浪珠略皎眷窕竟第终累舵苓架诀近钓顶鸟将那庶振挺捉捐甜祭趾囵堆凌崃带帐徕悌画梁梃桶町娄伟偶务唯问婉寅尉帷庸悟悠悦敖晚梧浴眼研移胃苑英迎野鱼欲浣翌圉乾做区卿参售启商唱娶妇宿崇崎崔常强从悄叙旋晨晟族消爽犀祥绅细紫组绍婧羞习邢舷船茄若处术袖设讼责赦雀雪顷彩常孰侦匙圊执将专就峥崧巢庶彩悉施曹浙笙钏阡凰毫培婚婆妇密彬彪患斌曼海浩烽班瓶毕盒符邦胡背胞胖舶范茅苗袍被觅访货返贩闭麦麻邦壶票冕副埠屏涵捕敏皓梅第珩艴苹敢款淦筐给贵辜开凯昆诒询几蛟植堵堤奠岚帧掌掘捷掏掎推探接敦景智晶替朝椒棠栈殖淘添淡净焦街诊理荔眨贴屠贷轸迢迪迦量钧钮间集杰劳单婷喋传塘塔暖楠殿渡汤帏幄惟掩椅涯液渊焰为异砚围茵越阮轶雁雅寓云雯媛喻贻婺焱琬琰畲劳博堡报富寒嵋帽幅帮弼复彭徨偏整理惠扉排斑酣普棉棒棚涵混淼淮淝牌画番发皓脉茗评贺费买贸迫邯闵防阪黄傅傍媒媚黑瓿匮块干感揆手楷港琨莞夸鼓该贾传仅涂塔塘廊谦提敬斟极楠殿汤渡绢经茎莒获莅庄莉蜀里装解詹鼎贾路迹退铃钜陀电雷靖顿暖桢路嫁农贮贷贴轸迪钠湍琳当略铃鼓励庸园圆奥爱意扬援握榆业杨椰涌渝渭游炜爷烟兽犹煜碗筠义肄莞莠虞蛾裕诣郁钰雍阿预饮衙莹蓊晕渥琬琰畹筵裔淡催传勤势嗣塞嵩厦新喧楸楚岁湘测凑煦琴琪琦睡祺稔稠筮粲绣群圣莎裙诩诗试诠详资载送铅阻雌颂驰熙暄琼塞嵩想桢椿岁渚煮琛庄裟输轼幕汇惶挥描换楣枫湖浑渺涣煤烦琶琥盟睦碑禀聘腑荷莫号蜂补话酩附颁饭晕募焕廓愧沟管纲诰闺魁构歌恺斡荣构嘏通连这甄兢喜团图奖嫡对僚侥屡嶂崭彰廖熊溜监祯种端箕筝精绿紧绫纶置璋畅榔糍滇尔莱赵铬领瑙奁闻嫣愿温源溢尔瑜瑛瑗玮与舞苑诱语郢银摇榕荣温荥溶菸菀鞅瑛僖逑速逍肾寿塾尘嫩实像侨岖慈滋沧溶溪熊狮瑞瑟硕算粹绸综绰绮翠菁菜菖裳认誓诵说诚轻菘造速衔铨限需韶饲饰旗畅荣榕齐熏僦尝墅奖实寨慎准溯搴逢梦仆幕滑瑚珲碧福绵翡腑萍华菩蜜裴豪宾辅郝铭阀陌颇饮凤鸣榜槐滏宽广慷惯概瑰葛葵课逵郭稿靠溉锆俭著价厉剧剑刘妖履帜弹徵德虑摘敌整暂椿闾乐楼樟滴渐涨浆练缔蒂骀落董葶蝶调谆谈诋诤谅论质驼践轮逮进醇铝阵震霆驾驻稽稻稷节剪几鲁黎侬涤墩幢嶙锻褚亿仪影慰忧乐样欧毅演渔熬熠熨瑶缘纬腰万莹叶苇谊逸邮阅院鞍颐养欲颍粗缓卫葳骑妩鉴署啸增婵审层厂厨厮庆摧数枢漆熟热线肠兴萱冲褚谁请贤赏赐趣娴醉锐销爽霄驷确磁穷箭箱竖辍帜漩渐箴节绪翦葸诤谆质醇罚划哗坟墨币庙废慧慕慢暮樊标模流浒汉满漫漂玛缓编腹铺葆葡复卖赋辉辈部锋陛盘码篇范麾劈幡慧摩沪漠磐褒弼荭窥糕膏盖钢龟购器垦横橄篙馆尽坛导惮战撰整历瞳昙暨机橘洁潭灯瑾璋庐积筑蒸诸谛诺练猪赖蹄辑道达都录锦锭陆陶陵霓霖静颊头雕疆腿臻赚骆莅俦橙润澈笃缙萤萤卫谓谒谙谕豫逾游运阴余壅赢蓉蓊勋儒器学宪熹憧晓桥樵橙橡树润潮甑莳璇聪融亲谌谐输遂醒钱错陈陲赛蓄苍侪澍莼谊铮锡阊桦壁奋播抚横潘磨蒙衡谋讳讽辨锚陪默蒲蓓滨嬖凭颖蓉运阴馀恳桧糠馆阶瞰励岭懂挡担据捡激浓烛瞳璐矶磷绩联胶膛临举莲蔗蒋讲递辗镀锻钟键隆队骏黛点泽沣潞澄优婴屿狱赢应忆拥澳营蔚荫舆锾闱阳偿择擅操泽澡燧禧穗簇纵总聪声膝襄谦逮邹乡隋虽霞霜鲜戏鸿壕嫔弥帮桧篷缝繁褒锚韩蔓徵擘扶柜圹归缋蒉磬纩戴拟抬挤爵涛礼简粮职旧蕉谨转遮题镇储藜芷迟鲤翼芸讴医隘额瑷莸镒隗彝潍储丛曙湿织萧蕊蝉瑞适双绣锁垒戴断柠涛泞璐礼粮藜槟滨获壁环蕃丰庞璧馥扩关铿庐疆祷荐勒襟谭证轿辽邻郑邓类鲸丽麓镜觉际橹栎泺辚链韵稳薏薇膺臆蚁袄遗雾愿艳蓣蕹韫玺薛薪绳蟹识赞遵迁选庞渖荐谯镟锵镞铲际颡鹑暹攀簿绘鹏庞瀑宝祢薜谱镆镘矿阚岿藉蓝拢沥泷竞篮罗舰觉警钟露腾党枥槠滤濑炉窦笞筹镦荩严瀛耀译议邀懿赢萨藏薰壤悬曦琼筹脐馨释献坏孀籍藉谵锈钟宝怀瀚缤还迈飘膑朦濒铧顾钚俪栏铁鸡镯藤览镭铎铛膑丽斓樱艺藕誉跃迩莺险续随属攘誉茑鸡藩轰辩癖霸鹤钚灌垄叠笼听芦览读铸籁苈链懿蔼隐璎蕴鳙欢边鳗镔沣镬矿恋兰体滩铄鳞驿验缨织显钻变蘩罐赣雳灵陇酿鹰霭坝嬖观戆厅篱钥瑷镶黉颢逻驴湾灒銮骥湾钻骧鹦艳鹳郁吁";
        //对应的繁体
        realName = "壹乙乃了力丁刀刁二又人入七十幾口幹工弓久己土大丈女己巾勺丸也於弋巳兀三下上乞士夕千子寸小山川巳才凡公孔亢勾中之丹井介今內及太天屯鬥斤牛醜支允元勿午友尤尹引文月日牙王雲勻牛四醜仁什切升收壬少心手日氏水尤仍雙尺仇止才不互分匹化卡卞肥反夫巴幻戶方木比毛仆豐火片古切可瓜甘刊五丘加去句叫外巧巨玉甲令加占主巨冬他代只仗另句召尼正田旦奴凸立叮仝伏臺奶凹五外央右未永以戊玉瓦由幼仕巧丘仙兄司且史左世出市玄仔冉穴示生申充主仞仟冊加去只叫求正甲申石匝甩丙平母弘末包本弗北必丕半布皿目乏禾皮疋矛乎付兄卉戊民冰玄白卯伉光匡共各考交件價企伍伎仰吉圭曲機根六仲吉州朱兆決匠地旨朵吏列年劣同打汀至臼燈竹老舟伎吊吏圳的宅機老肉蟲伊仰伍印因宇安屹有羊而耳衣亦吃夷奸聿丞企休任先全再沖刑向在夙如宅守字存寺式戌收早旭旬曲次此求系肉臣自舌血行圳西休交件企匠吉尖而至色伏後名回好妃帆灰牟百份米伐亥卉冰刑合向旭樸系行記復克告改攻更桿谷況伽估君吳吸吾圻均坎研完局岐我扣杞江究見角言住占低佃況裏冷伶利助努君吝昌壯妓鈕局弄廷弟彤誌托杖杜呆李江男究良見角具皂裏舟佟妳體足甸釘豆吞丁位佐佘冶吾吟吳吻完尾巫役忘我修言邑酉吟吳研呆角七伸佐作些伽些初吹呈坐孝宋岐希岑床序巡形忍成杏材杉束村杞步汝汐池私秀赤足身車辰系占伺住余助劭劬邵吸坐壯妝局床誌汕江竈見即卻克早何布伯伴佛兵判別含坊阪吵宏旱每甫牡況免孚孝尾巫希庇形忙杏呆步汛貝兒供侃刻卦固坤姑官岡庚快抗昆果空亟其具券卷奇委季宜居屆苛岸傑佳京侄佳來例制到兔兩典卷周呢坦奈妮宙定居屜帖底店征忝忠念技投政枝東林汰決玖知的直糾金兩乳侏佰侗佻佬具冽卓拈妲妯宕岱嶺帖帙底抒林抒踏爐竺長依侑味夜委宜宛嶽岸巖往亞武於易昂旺元沃汪物艾臥佯兒詠抑昀炎杳事享侍使侈然剎刺協卒洽沁取受步垂奇始炊姓妻妾尚屈弦所承昌升昔松欣沙沈社舍炊采長青幸亟徇佳舍兒爭其刷券制效卷姐似姍季炙宗屆岫征承昔析枕狀八並佩函和命坡坪奉孟帛水府佛彼忽或戽房扮枇扶放昏朋服明杭杯枚板沛沐汾版牧虎門阜杷盲非冠奎皈客故柑柯況看科肝革屋癸砍禹軌頁九亭亮柱俊侶冒段勁南姬姜姣宦帝度痔建峙待律怠急招拒拓拙拉昭架柱柳註治炭界皆突紀紂耐肚致計訂軍酊俐胃百厘咨殊姿柁沱炭妝紂重玨盅眈俄俞勇威娃姻姚姨屋幽彥奕哀哇玟怡押映昱韋油泳沿姚畏煙盈禹約耶衍要頁音昱易柚胤易信俠系俗促俏前則奏型姹妊殊姿室宣巷咱哉思性施昨是春星查柴柵柔染泉帥甚相省砂祈秋穿肖重首酉食香侵俟峙旭註沐主祉貞昌泓侯保便冒勉葡奔品佩杯封哈皇拔抱怕柏柄泌法泡炳玫盆眉紅美虹秒表負面風飛眄胃勃厚鹹叛孩奐屏枰某河泛赴庫恭拱格桂根耕耿股肯貢高個剛哥宮徑掛臯徑徒倜恬拯指拿料旅晉朕桌桔桃桐洞流洛酒烈特玲珍真矩祝秩租站級紙納紐者肩芝記討酌酒針釘只挑借倒值俱倪倘倫兼唐哲娘旃娟娜展峻準淩洲套爹特留倆倜庭恫恥烙料栗株津玳畜砧恩按案鳥洋秧翁紋耘育芽蕓蚊袁煙倚原員埃宴峨倚娛容峪晏移益差師席座徐恰息恕肩持拳拾時書曹校朔桑栽殊氣洽珊祠神祖秦秤索素紗紓純虔訖訓財起軒芩閃迅倩幸修倉城夏孫宰容射峽昔叟奚畜春乘借準淞宵指拭牲旬如狩茲珊炸租站辰挈旁晃桓活洪畔畝眠破炮秘粉紡肺肥航般芳芙花配馬侯倍俯俸們圃埋娩峰肪涵畔埔害恢恍恒柏派洹玻泌瑉祜唄國寇昆康苦袍規貫夠勘崞崗梗拱偕假健停偵剪動翎念基堅堂堆婧寄專張得教救朗條梁梯械梨浙浪珠略皎眷窕竟第終累舵苓架訣近釣頂鳥將那庶振挺捉捐甜祭趾圇堆淩崍帶帳徠悌畫梁梃桶釘婁偉偶務唯問婉寅尉帷庸悟悠悅敖晚梧浴眼研移胃苑英迎野魚欲浣翌幸乾做區卿參售啟商唱娶婦宿崇崎崔常強從悄敘旋晨晟族消爽犀祥紳細紫組紹婧羞習邢舷船茄若處術袖設訟責赦雀雪頃彩常孰偵匙青執將專就崢崧巢庶彩悉施曹浙笙釧阡凰毫培婚婆婦密彬彪患斌曼海浩烽班瓶畢盒符邦胡背胞胖舶範茅苗袍被覓訪貨返販閉麥麻邦壺票冕副埠屏涵捕敏皓梅第珩艴蘋敢款淦筐給貴辜開凱昆詒詢幾蛟植堵堤奠嵐幀掌掘捷掏椅推探接敦景智晶替朝椒棠棧殖淘添淡凈焦街診理荔眨貼屠貸軫迢迪迦量鈞鈕間集傑勞單婷喋傳塘塔暖楠殿渡湯幃幄惟掩椅涯液淵焰為異硯圍茵越阮軼雁雅寓雲雯媛喻貽婺火琬琰畬勞博堡報富寒嵋帽幅幫弼復彭徨偏整理惠扉排斑酣普棉棒棚涵混渺淮淝牌畫番發皓脈茗評賀費買貿迫邯閔防阪黃傅傍媒媚黑瓿匱塊幹感揆手楷港琨莞誇鼓該賈傳僅塗塔塘廊謙提敬斟極楠殿湯渡絹經莖莒獲蒞莊莉蜀裏裝解詹鼎賈路跡退鈴鉅陀電雷靖頓暖楨路嫁農貯貸貼軫迪鈉湍琳當略鈴鼓勵庸園圓奧愛意揚援握榆業楊椰湧渝渭遊煒爺煙獸猶煜碗筠義肄莞秀虞蛾裕詣郁鈺雍阿預飲衙瑩蓊暈渥琬琰畹筵裔淡催傳勤勢嗣塞嵩廈新喧楸楚歲湘測湊煦琴琪琦睡祺稔稠筮粲繡群聖莎裙詡詩試詮詳資載送鉛阻雌頌馳熙暄瓊塞嵩想楨椿歲諸煮琛莊裟輸軾幕匯惶揮描換楣楓湖渾渺渙煤煩琶琥盟睦碑稟聘腑荷莫號蜂補話酩附頒飯暈募煥廓愧溝管綱誥閨魁構歌愷斡榮構嘏通連這甄兢喜團圖獎嫡對僚僥屢章嶄彰廖熊溜監禎種端箕箏精綠緊綾綸置璋暢榔糍滇爾萊趙鉻領瑙奩聞嫣願溫源溢爾瑜瑛援瑋與舞苑誘語郢銀搖榕榮溫滎溶淤菀鞅瑛僖逑速逍腎壽塾塵嫩實像僑嶇慈滋滄溶溪熊獅瑞瑟碩算粹綢綜綽綺翠菁菜菖裳認誓誦說誠輕松造速銜銓限需韶飼飾旗暢榮榕齊熏就嘗墅獎實寨慎準溯搴逢夢仆幕滑瑚琿碧福綿翡腑萍華菩蜜裴豪賓輔郝銘閥陌頗飲鳳鳴榜槐滏寬廣慷慣概瑰葛葵課逵郭稿靠溉鋯儉著價厲劇劍劉妖履幟彈徵德慮摘敵整暫椿閭樂樓樟滴漸漲漿練締蒂駘落董葶蝶調諄談詆諍諒論質駝踐輪逮進醇鋁陣震霆駕駐稽稻稷節剪幾魯黎儂滌墩幢嶙鍛褚億儀影慰憂樂樣歐毅演漁熬熠熨瑤緣緯腰萬瑩葉葦誼逸郵閱院鞍頤養欲潁粗緩衛葳騎嫵鑒署嘯增嬋審層廠廚廝慶摧數樞漆熟熱線腸興萱沖褚誰請賢賞賜趣嫻醉銳銷爽霄駟確磁窮箭箱豎輟幟漩漸箴節緒翦葸諍諄質醇罰劃嘩墳墨幣廟廢慧慕慢暮樊標模流滸漢滿漫漂瑪緩編腹鋪葆葡復賣賦輝輩部鋒陛盤碼篇範麾劈幡慧摩滬漠磐褒弼葒窺糕膏蓋鋼龜購器墾橫橄篙館盡壇導憚戰撰整歷瞳曇暨機橘潔潭燈瑾璋廬積築蒸諸諦諾練豬賴蹄輯道達都錄錦錠陸陶陵霓霖靜頰頭雕疆腿臻賺駱蒞儔橙潤澈篤縉螢螢衛謂謁諳諭豫逾遊運陰余壅贏蓉蓊勛儒器學憲熹憧曉橋樵橙橡樹潤潮甑蒔璇聰融親諶諧輸遂醒錢錯陳陲賽蓄蒼儕澍蒓誼錚錫閶樺壁奮播撫橫潘磨蒙衡謀諱諷辨錨陪默蒲蓓濱嬖憑穎蓉運陰餘懇檜糠館階瞰勵嶺懂擋擔據撿激濃燭瞳璐磯磷績聯膠膛臨舉蓮蔗蔣講遞輾鍍鍛鐘鍵隆隊駿黛點澤灃潞澄優嬰嶼獄贏應憶擁澳營蔚蔭輿鍰闈陽償擇擅操澤澡燧喜穗簇縱總聰聲膝襄謙逮鄒鄉隋雖霞霜鮮戲鴻壕嬪彌幫檜篷縫繁褒錨韓蔓徵擘扶櫃壙歸繢蕢磬纊戴擬擡擠爵濤禮簡糧職舊蕉謹轉遮題鎮儲藜芝遲鯉翼蕓謳醫隘額璦蕕鎰愧彜濰儲叢曙濕織蕭蕊蟬瑞適雙繡鎖壘戴斷檸濤濘璐禮糧藜檳濱獲壁環蕃豐龐璧馥擴關鏗廬疆禱薦勒襟譚證轎遼鄰鄭鄧類鯨麗麓鏡覺際櫓櫟濼轔鏈韻穩薏薇膺臆蟻襖遺霧願艷蕷蕹韞璽薛薪繩蟹識贊遵遷選龐瀋薦譙鏇鏘鏃鏟際顙鶉暹攀簿繪鵬龐瀑寶禰薜譜鏌鏝礦闞巋藉藍攏瀝瀧競籃羅艦覺警鐘露騰黨櫪櫧濾瀨爐竇笞籌鐓藎嚴瀛耀譯議邀懿贏薩藏薰壤懸曦瓊籌臍馨釋獻壞孀籍藉譫銹鐘寶懷瀚繽還邁飄臏朦瀕鏵顧鈈儷欄鐵雞鐲藤覽鐳鐸鐺臏麗斕櫻藝藕譽躍邇鶯險續隨屬攘譽蔦雞藩轟辯癖霸鶴鈈灌壟疊籠聽蘆覽讀鑄籟藶鏈懿藹隱瓔蘊鱅歡邊鰻鑌灃鑊礦戀蘭體灘鑠鱗驛驗纓織顯鉆變蘩罐贛靂靈隴釀鷹靄壩嬖觀戇廳籬鑰璦鑲黌顥邏驢灣灒鑾驥灣鉆驤鸚艷鸛郁籲";

        long startTime = System.currentTimeMillis();
        for (char name : realName.toCharArray()){
            ChineseHelper.isTraditionalChinese(name);
//            System.out.println(name + " : " + ChineseHelper.isTraditionalChinese(name));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time: " + (endTime - startTime));

        System.out.println(realName.length());
    }

    @org.junit.Test
    public void testParse(){
        String string = "{\"cmsTaskId\":7,\"endTime\":1530374399000,\"maxReward\":50,\"minReward\":30,\"rewardType\":1,\"singleRewardLimit\":10000000,\"startTime\":1505232000000,\"status\":1,\"subTasks\":{25:{\"cmsPeriodId\":25,\"cmsTaskId\":7,\"endTime\":34200000,\"startTime\":32400000,\"status\":1},26:{\"cmsPeriodId\":26,\"cmsTaskId\":7,\"endTime\":45000000,\"startTime\":43200000,\"status\":1},27:{\"cmsPeriodId\":27,\"cmsTaskId\":7,\"endTime\":59400000,\"startTime\":57600000,\"status\":1},28:{\"cmsPeriodId\":28,\"cmsTaskId\":7,\"endTime\":77400000,\"startTime\":75600000,\"status\":1}},\"taskName\":\"2\"}";
        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println(jsonObject.toString());
    }

    @org.junit.Test
    public void testStringFormat() {
        String format = String.format("%02d", 100);
        System.out.println(format);
    }

    @org.junit.Test
    public void testDateTime() {
       /* System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        System.out.println(getBeginHourTime());*/

//        DateTime dateTime = new DateTime(System.currentTimeMillis());
//        long time = dateTime.withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0).getMillis();
//        System.out.println(time);

        System.out.println(getBeginHourTime(System.currentTimeMillis()));
    }



    public  long getBeginHourTime(long timestamp) {
        DateTime dateTime = new DateTime(timestamp);
        return dateTime.withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0).getMillis();
    }

    @org.junit.Test
    public void testToJson() {

        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            System.out.println(random.nextInt(10));
        }
    }
}
