import  java.util.*;

abstract class Stack{
    int top,size,list[];
    Stack(int n){
        size=n;
        top=-1;
        list=new int[size];
    }
    abstract void push();
    void pop(){
        if(top==-1){
            System.out.println("Underflow");
        }
        else{
            System.out.println("Deleted item is :"+list[top]);
            top--;
        }
    }
    void display(){
        if(top==-1){
            System.out.println("Empty stack\n");
        }
        else{
            for(int  i=top;i>=0;i--)
            {
                System.out.println(list[i]+" ");
            }
        }
    }
}
class Growable_stack extends Stack{
    Growable_stack(int n){
        super(n);
    }
    void push(){
        if(top==size-1){
            int list1[]=new int[2*size];
            for(int i=0;i<size;i++){
                list1[i]=list[i];
            }
            size=size*2;
            list=list1;
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnetr an item");
        list[++top]=sc.nextInt();
    }
   
}

class Simple_stack extends Stack{
    Simple_stack(int n){
        super(n);
    }
    void push(){
        Scanner sc= new Scanner(System.in);
        if(top==size-1){
            System.out.println("Overflow\n");
        }
        else{
            System.out.println("Enter an item\n");
            list[++top]=sc.nextInt();
           
        }
    }
}

class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int x;
        System.out.println("Enter the size of the stack\n");
        x=sc.nextInt();
        Simple_stack s1=new Simple_stack(x);
        Growable_stack g1=new Growable_stack(x);
        Stack ref;
        int ch;
        do{
            System.out.println("\n1.Growable_stack\n2.Simple_stack\n");
            System.out.println("SELECT\n");
            ch=sc.nextInt();
            if(ch==1){
                ref=g1;
            }
            else if(ch==2){
                ref=s1;
            }
            else{
                System.out.println("Wrong Selection\n");
                continue;
            }
            System.out.println("\n1.Push\n2.Pop\n3.Display\n0.exit\n");
            System.out.println("Select\n");
            ch=sc.nextInt();
            switch(ch){
                case 1:ref.push();break;
                case 2:ref.pop();break;
                case 3:ref.display();break;
                case 0:break;
                default:  System.out.println("\nWrong Selection\n");
               
            }
           
        }while(ch!=0);
       
    }
}
