package p1;
import java.util.Scanner;

public class Array{
    int Array[];
    int length;
    public Array(int length){
        this.length=length;
        Array=new int [length];
    }

    public void input(){
        Scanner scn=new Scanner(System.in);
        for (int i = 0; i < Array.length; i++) {
            Array[i]=scn.nextInt();
        }
    }

    public void output(){
        for (int i = 0; i < Array.length; i++) {
            System.out.print(Array[i]+" ");
        }
    }
}