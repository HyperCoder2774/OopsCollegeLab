#include<iostream>
using namespace std;

void pattern1(int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            cout<<"*";
        }
        cout<<"\n";
    }
}

void pattern2(int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            cout<<"* ";
        }
        cout<<"\n";
    }
}

void pattern3(int n){
    for(int i=0;i<n;i++){
        for(int j=0;j<=i;j++){
            cout<<"* ";
        }
        cout<<"\n";
    }
    for(int i=n-2;i>=0;i--){
        for(int j=0;j<=i;j++){
            cout<<"* ";
        }
        cout<<"\n";
    }
}

class pattern{
    int n;
    public :
    void set(int n){
        this->n=n;
    }
    void patterns(){
        int i;
        do{
            cout<<"1)pattern1()\n2)pattern2()\n3)pattern3()\n0)exit\n";
            cout<<"Enter the index :";
            cin>>i;
            switch (i)
            {
            case 1:{
                pattern1(n);
                break;
            }
            case 2:{
                pattern2(n);
                break;
            }
            case 3:{
                pattern3(n);
                break;
            }
            case 0:{
                return;
            }
            default:
                cout<<"Not a Correct Option";
            }
        }while (1);
    }
};

int main(){
    pattern* nw=new pattern();
    int i;
    do{
        cout<<"Enter the row number: ";
        cin>>i;
        nw->set(i);
        nw->patterns();
        cout<<"Enter -1 to stop: ";
        cin>>i;
        if(i==-1)break;
    }while(1);
    return 0;
}