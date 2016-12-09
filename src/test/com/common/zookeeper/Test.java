package com.common.zookeeper;

import com.sun.source.tree.Tree;
import org.codehaus.jackson.util.InternCache;

import java.io.UnsupportedEncodingException;
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
}
