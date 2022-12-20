package package1;

class A{
    void printA(){
        print();
        print1();
        print2();
        print3();
    }
    private void print() {
        System.out.println("Print From Package package1 from A class\tPrivate");
    }
    
    protected void print1() {
        System.out.println("Print From Package package1 from A class\tProtected");
    }

    void print2(){
        System.out.println("Print From Packege package1 from A class\tDefault");
    }

    public void print3(){
        System.out.println("Print From Package package1 from A class\tPublic");
    }
}

public class Main{
    public static void main(String[] args) {
        System.out.println("Print From Package package1 from Main class\tPublic");
        A nw=new A();
        nw.printA();
        /*
         *
         * nw.print();//The method print() from the type A is not visible
         * 
        */
        nw.print1();
        nw.print2();
        nw.print3();
    }

    protected void print1() {
        System.out.println("Print From Package package1 from Main class\tProtected");
    }

    void print2(){
        System.out.println("Print From Packege package1 from Main class\tDefault");
    }
}