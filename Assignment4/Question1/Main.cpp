#include<iostream>
using namespace std;
class Matrix
{
	int row,col;
	int m[10][10];
	public:
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
			cout<<m[i][j];
		}
	}
	}

	
	Matrix operator +( Matrix mat)
	{
		Matrix temp(0,0);
		temp.row=row;
		temp.col=col;
		int i,j;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				temp.m[i][j]= m[i][j] + mat.m[i][j];
			}
		}
		return temp;
	}
	
	
	Matrix operator *(Matrix mat)
	{
		Matrix temp(0,0);
		temp.row=row;
		temp.col=mat.col;
		int i,j,k;
		for(i=0;i<temp.row;i++)
		{
			for(j=0;j<temp.col;j++)
			{				for(k=0;k<col;k++)
				{
					temp.m[i][j] +=m[i][k]+mat.m[k][j];
				}
			}
		}
		return temp;
	}
};


int main()
{
		int r1,c1,r2,c2;
		cout<<"Enter row and column for first :"<<endl;
		cin>>r1>>c1;
		Matrix m1(r1,c1);
		cout<<"Enter row and column for 2nd"<<endl;
		cin >>r2>>c2;
		Matrix m2(r2,c2);
		if(r1 != r2 || c1 != c2)
		{
			cout<<endl<<"Addition is not possible"<<endl;
		}
		else {
			cout<< "Input all elements of first matrix "<< endl;
			m1.init();
			cout<<"Input all elements for 2nd matrix"<<endl;
			m2.init();
			Matrix m3(0,0);
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
			 cout << "after multiplication"<<endl;
			 m3.dispaly();
			 
		 }
		 return 0;
		 
}
