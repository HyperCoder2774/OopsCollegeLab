package package2;
import package1.*;

class A extends package1.Main{
    void print(){
        main(null);
        print1();
        /**
          * 
          * print2();//The method print2() from the type Main is not visible
          *
        **/
    }
}

public class Main{
    public static void main(String[] args) {
        A a=new A();
        a.print();
        package1.Main nw=new package1.Main();
        nw.main(null);
        /*
         *nw.print1();
         * //The method print1() from the type Main is not visible
        */
        /*
         *nw.print2();//The method print2() from the type Main is not visible
        */
    }
}
