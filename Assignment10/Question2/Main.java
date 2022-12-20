import java.util.Scanner;

class OverflowException extends Exception{
    OverflowException(){
        super("Overflow");
    }
}

class UnderflowException extends Exception{
    UnderflowException(){
        super("Underflow");
    }
}

class Stack{
    int list[];
    int top,size;
    Stack(int n){
        size=n;
        top=-1;
        list=new int[size];
    }
    public void push(){
        Scanner scn=new Scanner(System.in);
        try {
            if(top==size-1){
                throw new OverflowException();
            }
            System.out.print("Enter data: ");
            int item=scn.nextInt();
            list[++top]=item;
        } catch (OverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public void pop(){
        try {
            if(top==-1){
                throw new UnderflowException();
            }
            top--;
        } catch (UnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Stack st=new Stack(4);
        st.push();
        st.push();
        st.push();
        st.push();
        st.push();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
    }
}