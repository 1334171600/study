package Thread;

import java.util.stream.StreamSupport;

class MyThread1 implements Runnable{
    public void run(){
        for (int i = 0; i <1000 ; i++) {
            System.out.println(Thread.currentThread().getName()+"运行,i="+i);
        }
    }
}
public class ThreadName {
    public static void main(String args[]){
        MyThread1 myThread=new MyThread1();
        new Thread(myThread).start();
        new Thread(myThread,"线程-1").start();
        new Thread(myThread,"线程-2").start();
        new Thread(myThread).start();
        new Thread(myThread).start();
    }
}
