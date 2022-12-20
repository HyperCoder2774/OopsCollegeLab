#include<iostream>
using namespace std;
class Matrix
{
	int row,col;
	int m[10][10];
	public:
	Matrix()
	{
		row=col=0;
	}
	Matrix(int r,int c)
	{
		row=r;
		col=c;
		
	}
	
void init()
{
	int i,j;
	for(i=0;i<row;i++)
	{
		for(j=0;j<col;j++)
		{
			cin>>m[i][j];
		}
	}
}
void display()
{
	int i,j;
	for(i=0;i<row;i++)
	{   
		cout<<endl;
		for(j=0;j<col;j++)
		{
			cout<<m[i][j]<<"  ";
		}
	}
}
friend Matrix operator +(Matrix ob1,Matrix ob2);
friend Matrix operator *(Matrix ob1, Matrix ob2);

};
Matrix operator +( Matrix ob1, Matrix ob2)
	{
		Matrix temp;
		temp.row=ob1.row;
		temp.col=ob1.col;
		int i,j;
		for(int i=0;i<ob1.row;i++)
		{
			for(int j=0;j<ob1.col;j++)
			{
				temp.m[i][j]= ob1.m[i][j] + ob2.m[i][j];
			}
		}
		return temp;
	}
	
	
Matrix operator *(Matrix ob1, Matrix ob2)
{
		Matrix temp(ob1.row,ob2.col);
		int i,j,k;
		for(i=0;i<temp.row;i++)
		{
			for(j=0;j<temp.col;j++)
			{
				for(k=0;k<ob1.col;k++)
				{
					temp.m[i][j] +=ob1.m[i][k]+ob2.m[k][j];
				}
			}
		}
		return temp;
}



int main()
{
		int r1,c1,r2,c2;
		cout<<"Enter row and column for first :"<<endl;
		cin>>r1>>c1;
		Matrix m1(r1,c1);
		cout<<"Enter row and column for 2nd"<<endl;
		cin >>r2>>c2;
		Matrix m2(r2,c2);
		Matrix m3(0,0);
		if(r1 != r2 || c1 != c2)
		{
			cout<<endl<<"Addition is not possible"<<endl;
		}
		else {
			cout<< "Input all elements of first matrix "<< endl;
			m1.init();
			cout<<"Input all elements for 2nd matrix"<<endl;
			m2.init();
			//Matrix m3(0,0);
			m3=m1 + m2;
			cout<<endl<<"After addition"<<endl;
			m3.display();
		}
		 if(c1 != r2)
		 {
			 cout<< "\n Multiplication is not possible"<<endl;
		 }
		 else{
			 m3=m1*m2;
			 cout << "\nAfter multiplication"<<endl;
			 m3.display();
			 return 0;
		 }
}
