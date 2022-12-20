import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student{
    String name;
    long rollNumber;
    double avgMarks;
    Student(String name,long rollNumber,double avgMarks){
        this.name=name;
        this.rollNumber=rollNumber;
        this.avgMarks=avgMarks;
    }
}

class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student a, Student b)
    {
        return a.name.compareTo(b.name);
    }
}

public class StudentList{
    Student[] list;
    int size,top;
    StudentList(int n){
        size=n;
        top=-1;
        list=new Student[size];
    }
    public void input(){
        Scanner scn=new Scanner(System.in);
        for(int i=0;i<size;i++){
            System.out.print("Enter Student's Name: ");
            String studentNameString=scn.nextLine();
            System.out.print("Enter Student's Roll Number: ");
            long rollNumber=scn.nextLong();
            while ((search(rollNumber)!=null)){
                System.out.println("Roll Number Already Exists");
                System.out.print("Enter Correct One: ");
                rollNumber=scn.nextLong();
            }
            System.out.print("Enter Student's Average Mark: ");
            double avgMarks=scn.nextDouble();
            scn.nextLine();
            Student temp=new Student(studentNameString,rollNumber,avgMarks);
            list[i]=temp;
            top++;
        }
    }
    public void output(){
        if(top==-1){
            System.out.println("No Data Exists");
            return;
        }
        System.out.println("Printing all the Student Data(Name,Roll Number,Average Mark): ");
        for(int i=0;i<=top;i++){
            System.out.println("Sl No: "+(i+1)+" Name: "+list[i].name+" || Roll Number: "+list[i].rollNumber+" || Average Mark: "+list[i].avgMarks);
        }
        System.out.println();
    }

    public Integer search(long rollNumber){
        for(int i=0;i<=top;i++){
            if(list[i].rollNumber==rollNumber){
                return i;
            }
        }
        return null;
    }

    public void sort(){
        Arrays.sort(list,0,top+1,new StudentComparator());
    }

    public void add(Student student){
        if(student==null){
            return;
        }
        if(search(student.rollNumber)==null){
            list[++top]=student;
        }else{
            System.out.println("Roll Number already exists.");
        }
    }
    
    public void remove1(long rollNumber){
        if(top==-1){
            System.out.println("No Student in Class.");
            return;
        }
        if(search(rollNumber)==null){
            System.out.println("No Match Found.");
        }else{
            int pos=search(rollNumber);
            for(int i=pos;i<top;i++){
                list[i]=list[i+1];
            }
            top--;
            System.out.println("Student DATA deleted");
        }
    }
    public void remove2(){
        if(top==-1){
            System.out.println("No Student in Class.");
            return;
        }
        top--;
        System.out.println("Student DATA deleted.");
    }
    public void remove(){
        Scanner scn=new Scanner(System.in);
        System.out.print("How you want to delete the Data:\n1)By Roll Number\n2)The Last one\nEnter Index Num which one you want to perform or Any key otherwise: ");
        int rmv=scn.nextInt();
        if(rmv==1){
            System.out.print("Enter the Student roll Number you want to Delete: ");
            long roll=scn.nextLong();
            remove1(roll);
        }else if(rmv==2){
            remove2();
        }else{
            System.out.println("Not Deleting any Data.");
        }
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the Length of Student List You want to create: ");
        int Length=scn.nextInt();
        StudentList list=new StudentList(Length);
        do {
            /**
             * 1) input() -> storing details of all student rrecord
             * 2) output()
             * 3) search() -> base on roll number
             * 4) sort all records according to their name
             * 5) add()
             * 6) remove()
             **/
            System.out.println("1)Input the Whole Student Data\n2)Output the Whole Student Data\n3)Search the Student Data\n4)Sorting all records according to their name\n5)Add a Student Data\n6)Remove a Student Data\n0)Exit\nEnter the Index: ");
            int input=scn.nextInt();
            switch (input) {
                case 1:{
                    list.input();
                    break;
                }
                case 2:{
                    list.output();
                    break;
                }
                case 3:{
                    System.out.print("Enter Student's Roll Number for Data: ");
                    long rollNumber=scn.nextLong();
                    Integer slNo=list.search(rollNumber);
                    if(slNo==null)break;
                    Student fStudent=list.list[slNo];
                    System.out.println("Sl No: "+slNo+" || Name: "+fStudent.name+" || Roll Number: "+fStudent.rollNumber+" || Average Mark: "+fStudent.avgMarks);
                    break;
                }
                case 4:{
                    list.sort();
                    break;
                }
                case 5:{
                    if(list.top==list.size-1){
                        System.out.println("More Data can't be Accepted,Class Capacity Full");
                        break;
                    }
                    scn.nextLine();
                    System.out.print("Enter Student's Name: ");
                    String nameString=scn.nextLine();
                    System.out.print("Enter Student's Roll Number: ");
                    long rollNumber=scn.nextLong();
                    System.out.print("Enter Student's Average Marks: ");
                    double avgMarks=scn.nextDouble();
                    Student student=new Student(nameString, rollNumber, avgMarks);
                    list.add(student);
                    break;
                }
                case 6:{
                    list.remove();
                    break;
                }
                case 0:{
                    return;
                }
                default:
                System.out.println("Index doesn't match.Please try again.");
                    break;
            }
            System.out.println();
        } while (true); 
    }
}