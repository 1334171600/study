package eight;

interface Window{
    public void open();
    public void close();
    public void activated();
    public void iconified();
    public void deiconified();
}
abstract class WindowAdapter implements Window{
    public void activated(){}
    public void close(){}
    public void deiconified(){}
    public void iconified(){}
    public void open(){}
}

class WindowImpl extends WindowAdapter{
        public void open(){
            System.out.println("窗口打开");
        }
        public void close(){
            System.out.println("窗口关闭");

        }
}

public class AdapterMode {
        public static void main(String[] args){
            Window window=new WindowImpl();
            window.open();
            window.close();

        }
}
