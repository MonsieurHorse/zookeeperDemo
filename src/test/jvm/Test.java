package jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by MHorse on 2016/10/17.
 */
public class Test {

    @org.junit.Test
    public void test(){
       /* static{
            i = 0;
            System.out.println(i);
        }
        static int i = 1;*/
//        PrintStream printStream = new PrintStream();

        String s = new String();
        Integer integer = 1;
        integer.intValue();
        integer.toString();
        System.out.println(integer);
        AtomicLong atomicLong;
        AtomicInteger atomicInteger;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abv");
        stringBuilder.append(new String());
        System.out.println(stringBuilder.toString());

        ArrayList arrayList = new ArrayList();
        arrayList.size();
        String[] strings = new String[]{""};
        System.out.println(strings.length);
    }


    @org.junit.Test
    public void testStatic() {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


        System.out.println(Integer.SIZE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.TYPE);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            arrayList.add(1);
            System.out.println("size: " + arrayList.size());
        }
        System.out.println("size: " + arrayList.size());
        System.out.println(arrayList.get(Integer.MAX_VALUE -1));
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        System.out.println("size: " + arrayList.size());
    }

    @org.junit.Test
    public void testSort() {

        Name nameArray[] = {
                new Name("John", "Lennon"),
                new Name("Karl", "Marx"),
                new Name("Groucho", "Marx"),
                new Name("Oscar", "Grouch"),
                new Name("Oscar", "A")
        };
        Arrays.sort(nameArray);
        for(int i=0;i<nameArray.length;i++){
            System.out.println(nameArray[i].toString());
        }

        System.out.println("a".compareTo("c"));
    }

    class Name implements Comparable<Name>{
        public String firstName,lastName;
        public Name(String firstName,String lastName){
            this.firstName=firstName;
            this.lastName=lastName;
        }
        public int compareTo(Name o) {          //实现接口
            int lastCmp=lastName.compareTo(o.lastName);
            return (lastCmp!=0?lastCmp:firstName.compareTo(o.firstName));
        }
        public String toString(){                //便于输出测试
            return firstName+" "+lastName;
        }
    }


}
