package Thread;

class MyThread3 implements Runnable{
    private int tickect=5;
    public void run(){
        for (int i = 0; i <100 ; i++) {
            synchronized (this){
                if (tickect>0){
                    try {
                        Thread.sleep(300);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("卖票：ticket="+tickect--);
                }
            }
        }
    }
}
public class ThreadSync {
    public static void main(String[] args){
        MyThread3 myThread=new MyThread3();
        Thread thread=new Thread(myThread);
        Thread thread1=new Thread(myThread);
        Thread thread2=new Thread(myThread);
        thread.start();
        thread1.start();
        thread2.start();
    }

}
