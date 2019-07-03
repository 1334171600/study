package Thread;

import java.util.stream.StreamSupport;

class OwnThread extends Thread {
    private String name;

    public OwnThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + "运行,i=" + i);
        }
    }
}
class OwnRunnable implements Runnable{
    private String name;
    public OwnRunnable(String name){
        this.name=name;
    }
    public void run(){
        for (int i = 0; i <100 ; i++) {
            System.out.println(name+"run,i="+i);
        }
    }
}
public class MyThread {
        public static void main(String args[]){
            OwnThread ownThread1=new OwnThread("线程A");
            OwnThread ownThread2=new OwnThread("线程B");
            OwnRunnable ownRunnable1=new OwnRunnable("Runnable1");
            OwnRunnable ownRunnable=new OwnRunnable("Runnable2");
            Thread thread1=new Thread(ownRunnable);
            Thread thread=new Thread(ownRunnable1);
            thread.start();
            thread1.start();
            ownThread1.start();
            ownThread2.start();
        }
}
