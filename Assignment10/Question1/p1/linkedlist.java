package p1;
import java.util.Scanner;

class Node{
    int data;
    Node next;
}

public class linkedlist{
    Node head;
    public linkedlist(){
        head=new Node();
    }
    public void create(){
        Node ptr=head;
        Scanner scn=new Scanner(System.in);
        int ch;
        do{
            System.out.println("Enter Data");
            ptr.data=scn.nextInt();
            System.out.println("Press 1 to Continue or else otherwise");
            ch=scn.nextInt();
            if(ch==1){
                ptr.next=new Node();
                ptr=ptr.next;
            }
        }while(ch==1);
        scn.close();
    }

    public void display(){
        for(Node tempNode=head;tempNode!=null;tempNode=tempNode.next){
            System.out.print(tempNode.data+" ");
        }
    }
}