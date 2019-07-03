package Thread;

class MyThread2 extends Thread{
    private int time;
    public MyThread2(String name,int time){
        super(name);
        this.time=time;
    }
    public void run(){
        try {
            Thread.sleep(this.time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"线程,休眠"+this.time+"毫秒.");
    }
}
public class ThreadExec {
    public static void main(String args[]){
        MyThread2 myThread2=new MyThread2("线程A",10000);
        MyThread2 myThread3=new MyThread2("线程B",20000);
        MyThread2 myThread4=new MyThread2("线程C",30000);
        MyThread2 myThread5=new MyThread2("线程D",40000);
        MyThread2 myThread6=new MyThread2("线程E",50000);
        MyThread2 myThread7=new MyThread2("线程F",60000);
        myThread2.start();
        myThread3.start();

        myThread4.start();

        myThread5.start();

        myThread6.start();

        myThread7.start();


    }


}
