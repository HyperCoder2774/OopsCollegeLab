import java.util.*;
class Student{
	String name,dept;
	int roll;
	float avg;
	Student list[];
	int size,top;
	Student(int n){
		top=-1;
		size=n;
		list= new Student[n];
	}
	Student(String n,String d,int r,float a){
		name=n;
		dept=d;
		roll=r;
		avg=a;
	}
	void add(){
		Scanner sc=new Scanner(System.in);
		String n,d;
		int r;
		float a;
		System.out.println("Name ");
		n=sc.next();
		System.out.println("Dept");
		d=sc.next();
		System.out.println("Roll");
		r=sc.nextInt();
		System.out.println("Avg marks");
		a=sc.nextFloat();
		top++;
		list[top]= new Student(n,d,r,a);
	}
	void show(){
		System.out.println("Name\t\tDept\t\tAvgmarks\tRoll");
		System.out.println(this.name+"\t\t"+this.dept+"\t\t"+this.avg+"\t\t"+this.roll);
	}
	void display(){
		int i;
		for(i=0;i<=top;i++){
			list[i].show();
		}
	}
	
}
class CSE_list extends Student {
	CSE_list(int n){
		super(n);
	}
}
class IT_list extends Student{
	IT_list(int n){
		super(n);
	}
}
class  ECE_list extends Student {
	ECE_list(int n){
		super(n);
	}
}
class StudentDemo{
	public static void main(String args[]){
		Student st;
		Scanner sc= new Scanner(System.in);
		int n;
		System.out.println("\nEnter maximum number of students\n");
		n=sc.nextInt();
		CSE_list cs=new CSE_list(n);
		IT_list it =new IT_list(n);
		ECE_list ec=new ECE_list(n);
		int ch;
		do{
			System.out.println("\n1->CSE\n2->ECE\n3->IT\n");
			System.out.println("Select:");
			ch=sc.nextInt();
			if(ch==1){
				st=cs;
			}
			else if(ch==2){
				st=ec;
			}
			else if(ch==3){
				st=it;
			}
			else{
				System.out.println("Wrong Selection");
				continue;
			}
			System.out.println("\n1->Add\n2->Display\n4->Exit\n");
			System.out.println("Select");
			ch=sc.nextInt();
			switch(ch){
				case 1:
				st.add();
				break;
				case 2:
				st.display();
				break;
			
				default:System.out.println("Wrong Selection.");break;
			}
		}while(ch!=4);
	}
}