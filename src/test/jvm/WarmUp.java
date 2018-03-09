package jvm;

/**
 * Created by junbaoma on 2018/2/24.
 */
public class WarmUp {
    public static void main (String [] args)
    {
        // Create an ITimer using the Factory class:
//        final ITimer timer = TimerFactory.newTimer ();

        for (int repeat = 0; repeat < 25000; ++ repeat)
        {
            long start = System.nanoTime();
            sum (100);
            long end = System.nanoTime();

            System.out.println (repeat + ": " + (end - start));
//            timer.reset ();
        }
    }

    public static int sum (int n)
    {
        if (n <= 1)
            return 1;
        else
            return n + sum (n - 1);
    }
}
