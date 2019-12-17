package src;

class Count1 extends Thread
{
    String nam;
    int num;
    int delay;
    Count1(String nam , int num)
    {
        super("my extending thread");
        System.out.println("my thread created" + this);
        this.nam = nam;
        this.num = num;
        this.delay = 1000;
        start();
    }
    Count1(int delay)
    {
        super("my extending thread");
        System.out.println("my thread created" + this);
        this.num = 10;
        this.delay = delay;
        start();
    }
    public void run()
    {
        try
        {
            for (int i=0 ;i<this.num;i++)
            {
                System.out.println(this.nam +" Printing the count " + i);
                Thread.sleep(this.delay);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("my thread interrupted");
        }
        System.out.println("My thread run is over" );
    }
}
class ExtendingExample009
{
    public static void main(String args[])
    {
        String thread1 = "thread1";
        String thread2 = "thread2";
        String thread3 = "thread3";
        Count1 cnt1 = new Count1(thread1,3);
        Count1 cnt2 = new Count1(thread2,4);
        Count1 cnt3 = new Count1(thread3,5);
        Count1 cnt4 = new Count1(2000);
        cnt3.setPriority(4);
        cnt2.setPriority(3);
        cnt1.setPriority(2);
        cnt4.setPriority(1);

        try
        {
            while(cnt1.isAlive()|| cnt2.isAlive()|| cnt3.isAlive())
            {
                System.out.println("Main thread will be alive till the child thread is live");
                Thread.sleep(1500);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }
        //System.out.println("Main thread's run is over" );
    }
}