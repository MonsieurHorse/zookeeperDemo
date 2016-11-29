package stringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import sun.util.locale.provider.TimeZoneNameProviderImpl;
import sun.util.resources.TimeZoneNames;

import java.awt.*;
import java.io.*;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.*;
import java.util.List;

/**
 * Created by MHorse on 2016/8/15.
 */
public class Test {

    @org.junit.Test
    public void testListSplit(){
        String string = "çµå½± ";
        System.out.println(StringUtils.substringBetween("a[sfd]f[asd]", "[","]"));

    }

    String string = "04ad441f302122d1ad6bfa6905612706";
    @org.junit.Test
    public void testMD5(){

        System.out.println(string2MD5("123456"));
        System.out.println(convertMD5(string2MD5("123456")));
        System.out.println(convertMD5(convertMD5(string2MD5("123456"))));

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
        Random random = new Random();
        for (int i = 0; i< 99; i++){
            System.out.println(random.nextInt(101));
        }
        random.equals("");
    }


    static class OOMObject{}

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while(true){
            list.add(new OOMObject());
        }
    }
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
}
