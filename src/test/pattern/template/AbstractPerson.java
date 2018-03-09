package pattern.template;

/**
 * Created by junbaoma on 2018/2/8.
 */
public abstract class AbstractPerson{
    //抽象类定义整个流程骨架
    public void prepareGotoSchool(){
        dressUp();
        eatBreakfast();
        takeThings();
        test();
    }

    public void test() {
        System.out.println("就是随便打印一行~~~");
    }
    //以下是不同子类根据自身特性完成的具体步骤
    protected abstract void dressUp();
    protected abstract void eatBreakfast();
    protected abstract void takeThings();
}