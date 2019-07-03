package Thread;

import javax.sound.sampled.Line;

class info{
    private String name="zj";
    private boolean flag=false;
    private String content="android";
    public synchronized void set(String name,String content){
        if (!flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name);
        try {
            Thread.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.setContent(content);
        flag=false;
        super.notify();
    }
    public synchronized void get(){
        if (flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(this.getName()+"---------->"+this.getContent());
        flag=true;
        super.notify();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
class Producer implements Runnable{
    private info info=null;
    public Producer(info info){
        this.info=info;
    }
    public void run(){
        boolean flag=false;
        for (int i = 0; i <50 ; i++) {
            if (flag){
                this.info.set("张健","Android");
                flag=false;
            }else {
                this.info.set("ryi","proxy");
                flag=true;
            }
        }
    }
}
class Consumer implements Runnable{
    private info info=null;
    public Consumer(info info){
        this.info=info;
    }
    public void run(){
        for (int i = 0; i <50 ; i++) {
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();

            }
            this.info.get();
        }
    }
}
public class Custom {
   public static  void main(String args[]){
       info info=new info();
       Producer producer=new Producer(info);
       Consumer consumer=new Consumer(info);
       new Thread(producer).start();
       new Thread(consumer).start();
   }
}
