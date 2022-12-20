import java.util.Scanner;

class StackList{
    int st[];
    int top,size;
    void set(int n){
        st=new int[n];
        top=-1;
        size=n;
    }
    void push(){
        Scanner scn=new Scanner(System.in);
        if(top==size-1){
            System.out.println("Overflow");
            return;
        }
        System.out.print("Enter data: ");
        st[++top]=scn.nextInt();
    }

    void pop(){
        if(top==-1){
            System.out.println("Underflow");
            return;
        }
        top--;
    }

    void display(){
        if(top==-1){
            System.out.println("Empty Stack");
            return;
        }
        System.out.print("The Stack: ");
        for(int i=0;i<=top;i++){
            System.out.print(st[i]+" ");
        }
        System.out.println();
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        StackList sList=new StackList();
        System.out.print("Enter length of StackList you want to create: ");
        int n=scn.nextInt();
        sList.set(n);
        do {
            System.out.println("1)push\n2)pop\n3)display\n0)exit");
            System.out.print("Enter Input with the index: ");
            int ch=scn.nextInt();
            switch (ch){
                case 1:{
                    sList.push();
                    break;
                }
                case 2:{
                    sList.pop();
                    break;
                }
                case 3:{
                    sList.display();
                    break;
                }
                case 0:{
                    scn.close();
                    return;
                }
                default:{
                    System.out.println("Output doesn't match any output index");
                }
            }
        } while (true);
    }
}
