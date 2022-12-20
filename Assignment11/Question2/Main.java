class A{
    synchronized void display(String msg){
        System.out.print("["+msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO: handle exception
            System.out.println(e);
        }
        System.out.println("]");
    }
}
class B implements Runnable{
    String msg;
    Thread t;
    A ref;
    B(A a,String x){
        msg=x;
        ref=a;
        t=new Thread(this);
        t.start();
    }
    public void run(){
        // synchronized(ref){
            ref.display(msg);
        // }
    }
}

public class Main{
    public static void main(String[] args) throws Exception{
        A obj=new A();
        B obj1=new B(obj, "one");
        B obj2=new B(obj, "two");
        B obj3=new B(obj, "three");
    }
}