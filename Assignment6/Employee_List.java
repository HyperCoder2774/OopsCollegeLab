import java.util.Scanner;

class Employee{
    String Name;
    int Age;
    long Salary;
    public void set(){
        Scanner scn=new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        Name=scn.nextLine();
        System.out.print("Enter Employee Age: ");
        Age=scn.nextInt();
        System.out.print("Enter Employee Salary: ");
        Salary=scn.nextLong();
    }
    public void print(){
        System.out.println("Employee Name: "+Name+", Age: "+Age+", Salary: "+Salary);
    }
}

class EmployeeNode{
    Employee data;
    EmployeeNode next;
}

public class Employee_List{
    EmployeeNode head;
    public Employee_List(){
        head=new EmployeeNode();
    }
    public void create(){
        EmployeeNode ptr=head;
        int ch;
        Scanner scn=new Scanner(System.in);
        do{
            ptr.data=new Employee();
            ptr.data.set();
            System.out.println("Press 1 to Continue or else otherwise");
            ch=scn.nextInt();
            if(ch==1){
                ptr.next=new EmployeeNode();
                ptr=ptr.next;
            }
        }while(ch==1);
    }

    public void search(){
        Scanner scn=new Scanner(System.in);
        System.out.println("Search by :-\n1)Name\n2)Age\n3)Salary\nEnter the Index: ");
        int index=scn.nextInt();
        switch (index) {
            case (1):{
                System.out.print("Enter the Name: ");
                String name=scn.nextLine();
                for(EmployeeNode temp=head;temp!=null;temp=temp.next){
                    if(temp.data.Name==name)temp.data.print();
                }
                break;
            }
            case 2:{
                System.out.print("Enter the Age: ");
                int n=scn.nextInt();
                for(EmployeeNode temp=head;temp!=null;temp=temp.next){
                    if(temp.data.Age==n)temp.data.print();
                }
                break;
            }
            case 3:{
                System.out.print("Enter the Salary: ");
                long n=scn.nextInt();
                for(EmployeeNode temp=head;temp!=null;temp=temp.next){
                    if(temp.data.Salary==n)temp.data.print();
                }
                break;
            }
            default:
                System.out.println("Index not Found.");
                break;
        }
    }

    public void display(){
        for(EmployeeNode temp=head;temp!=null;temp=temp.next){
            temp.data.print();
        }
    }
    public static void main(String[] args) {
        Employee_List nw=new Employee_List();
        System.out.println("Create Function: ");
        nw.create();
        System.out.println("Search Function: ");
        nw.search();
        System.out.println("Display Function");
        nw.display();
    }
}