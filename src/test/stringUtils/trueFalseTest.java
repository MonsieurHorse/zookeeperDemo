package stringUtils;

import java.util.HashMap;
import java.util.Random;


public class trueFalseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		trueFalseTest t= new trueFalseTest(); 
		
		HashMap a = new HashMap();
		
		String arg = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		long startTime =System.currentTimeMillis();
		for(int i=0;i<1700000;i++)
        {
			String value = t.getRandomFromArray(arg,4);
			//System.out.print(value);
			a.put(value, value);
        }
		System.out.println(a.size());
		long endTime =System.currentTimeMillis();
		
		System.out.println(endTime-startTime);
////		Set<String> appNameSet = new HashSet<String>() {
////			{
////				add("0");
////				add("1");
////				add("2");
////				add("3");
////				add("4");
////			}
////		};
////		
////		System.out.print(appNameSet.contains(null));
////		System.out.print(appNameSet.contains(""));
//		Integer a =100;
//		System.out.println(-a);
//		System.out.println(-a>0);
////		List noticeParams = new ArrayList();
////		noticeParams.add("1");
////		noticeParams.add("2");
////		noticeParams.add("3");
////		noticeParams.add("4");
////		String content = String.format("%s-%s-%s-%s", noticeParams,noticeParams,noticeParams,noticeParams);
////		System.out.println(content);
//		
//        for(int i=0; i<1000;i++)
//        {
//        	System.out.println(PointConstants.fenToYuan(i));
//        	System.out.println(PointConstants.getNowFormat());
//        	try {
//				Thread.sleep(1000L);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        }
	}
	
	public String getRandomFromArray(String array, int count) {  
	    // ArrayList<Integer>arrayList =null;  
	    String a = array;  
	    String result = "";  
	    boolean r[] = new boolean[array.length()];  
	    Random random = new Random();  
	    int m = count; // 要随机取的元素个数  
	    if (m > a.length() || m < 0)  
	        return a;  
	    int n = 0;  
	    while (true) {  
	        int temp = random.nextInt(a.length());  
	        if (!r[temp]) {  
	            if (n == m) // 取到足量随机数后退出循环  
	                break;  
	            n++;  
	            //System.out.println("得到的第" + n + "个随机数为：" + a[temp]);  
	            result += a.substring(temp, temp+1);  
	            r[temp] = true;  
	        }  
	    }  
	    return result;  
	}

}
