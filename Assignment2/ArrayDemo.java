import java.util.Arrays;
import java.util.Scanner;

class ArrayList{
    static int arr[];
    static int size;
    static void create(int n){
        size=n;
        arr=new int[size];
    }
    static void input(){
        Scanner scn=new Scanner(System.in);
        for(int i=0;i<size;i++){
            System.out.println("Enter Data: ");
            arr[i]=scn.nextInt();
        }
        System.out.println("Fully Filled");
    }

    static void Output(){
        System.out.print("Elements of the Array is: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static void search(){
        Scanner scn=new Scanner(System.in);
        System.out.print("Enter thr Number you want to search: ");
        int point=scn.nextInt();
        for(int i=0;i<size;i++){
            if(arr[i]==point){
                System.out.println(point+" found on index "+i);
                return;
            }
        }
        System.out.println(point+" can't be found");
    }

    static void sort(){
        Arrays.sort(arr);
    }
}

public class ArrayDemo{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        ArrayList nw=new ArrayList();
        System.out.print("Enter the size of the array : ");
        int n=scn.nextInt();
        nw.create(n);
        do {
            System.out.println("1)input\n2)output\n3)search\n4)Sort\n0)exit");
            System.out.print("Enter Input with the index: ");
            int ch=scn.nextInt();
            switch (ch){
                case 1:{
                    nw.input();
                    break;
                }
                case 2:{
                    nw.Output();
                    break;
                }
                case 3:{
                    nw.search();
                    break;
                }
                case 4:{
                    nw.sort();
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