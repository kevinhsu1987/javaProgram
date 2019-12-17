class Count2 extends Thread
{
    private int delay = 1000;
    private int count = 10;
    Count2()
    {
        super("my extending thread");
        System.out.println("my thread created" + this);
        start();
    }
    Count2(String name, int count, int delay)
    {
        super(name);
        this.delay = delay;
        this.count = count;
        System.out.println("my thread created" + this);
        start();
    }
    Count2(String name, int count){
        super(name);
        this.count = count;
        System.out.println("my thread created" + this);
        start();
    }

    public void run()
    {
        try
        {
            System.out.println(this.getName() + ": I will run until " + this.count + ". period :" + this.delay + " ms.");
            for (int i=0 ;i <= count;i++)
            {
                System.out.println(this.getName() + ": it's count :"  + i);
                Thread.sleep(delay);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(this.getName() + "interrupted");
        }
        System.out.println(this.getName() + " is over" );
    }
}
class ExtendingExample1
{
    public static void main(String args[])
    {
        Count2 cnt1, cnt2, cnt3;
        cnt1 = new Count2("thread1", 10);
        cnt2 = new Count2("thread2", 15, 900);
        cnt3 = new Count2("thread3", 12);
        cnt1.setPriority(1);
        cnt2.setPriority(2);
        cnt3.setPriority(3);
        try
        {
            while(cnt1.isAlive()||cnt2.isAlive()||cnt3.isAlive())
            {
                System.out.println("Main thread will be alive till the child thread is live");
                Thread.sleep(1500);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread's run is over" );
    }
}