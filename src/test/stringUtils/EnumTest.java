package stringUtils;

/**
 * Created by junbaoma on 2017/7/27.
 */
public class EnumTest {
    public static void main(String[] args){
        //直接引用
        Day day =Day.MONDAY;
        System.out.println(day);
        System.out.println(Day.FRIDAY.name());

        Day dd;
        System.out.println();


    }

}
//定义枚举类型
enum Day {
    MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
