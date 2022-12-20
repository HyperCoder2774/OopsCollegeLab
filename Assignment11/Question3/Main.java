class Q{
    int n;
    boolean valueSet=false;
    synchronized void get(){
        if(valueSet==false){
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    
        System.out.println("Got: "+n);
        valueSet=false;
        notify();
       // return n;
    }
    synchronized void put(int n){
        if(valueSet==true){
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        this.n=n;
       
        System.out.println("Put: "+n);
        valueSet=true;
        notify();
    }
}


class Producer implements Runnable{
    Q q;
    Thread t;
    Producer(Q q){
        this.q=q;
        t=new Thread(this);
        t.start();
    }
    public void run(){
        int i=0;
        while(true){
            q.put(i++);
        }
    }
}

class Consumer implements Runnable{
    Q q;
    Thread t;
    Consumer(Q q){
        this.q=q;
        t=new Thread(this);
        t.start();
    }
    public void run(){
        while(true){
            q.get();
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Q q=new Q();
        Producer p=new Producer(q);
        Producer c=new Producer(q);
        //p.t.start();
        //c.t.start();
    }
}