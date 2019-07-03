package eight;

interface Usb{
    public void start();
    public void stop();
}
class Computer{
    public static void plugin(Usb usb){
        usb.start();
        System.out.println("====usb设备开始工作====");
        usb.stop();
    }
}
class Flash implements Usb{
    public void start(){
        System.out.println("U盘开始工作");

    }
    public void stop(){
        System.out.println("U盘停止工作");

    }
}
class Print implements Usb{
    public void start(){
        System.out.println("打印机开始工作");

    }
    public void stop(){
        System.out.println("打印机停止工作");

    }

}
public class InterfaceDemo{
    public static void main(String args[]){
        Computer.plugin(new Flash());
        Computer.plugin(new Print());
    }
}