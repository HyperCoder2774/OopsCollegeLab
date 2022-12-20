
public class Main{
	int counter = 1;

	static int N;

	public void printOddNumber()
	{
		synchronized (this)
		{
			while (counter < N) {
				while (counter % 2 == 0) {
					try {
						wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("Odd Number from printOddNumber:"+counter + " \n");
				counter++;
				notify();
			}
		}
	}
	public void printEvenNumber()
	{
		synchronized (this)
		{
			while (counter < N) {
				while (counter % 2 == 1) {
					try {
						wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("Even Number from printEvenNumber:"+counter + " \n");
				counter++;
				notify();
			}
		}
	}
    public void printFibonacciNumber()
	{
		try
          {
               int a=0, b=1, c=0;
               int n=1;
               while (N>=n)
               {
                    System.out.print("Fibonacci Number from printFibonacciNumber:"+c+" \n");
                    a=b;
                    b=c;
                    c=a+b;
                    n=n+1;
               }
          }
          catch (Exception ex)
          {
               ex.printStackTrace();
          }

	}
	boolean isPrime(int num){
        for(int i=2;i*i<=num;i++){
            if(num%i==0)return false;
        }
        return true;
    }
    public void printPrimeNumber()
	{
		try
          {
               int n=2;
               while (N>=n)
               {
                    if(isPrime(n))System.out.println("Prime Numbers from printPrimeNumber:"+n);
                    n=n+1;
               }
          }
          catch (Exception ex)
          {
               ex.printStackTrace();
          }

	}
    public static void main(String[] args)
	{
		N = 10;
		Main mt = new Main();
		Thread t1 = new Thread(new Runnable() {
			public void run()
			{
				mt.printEvenNumber();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run()
			{
				mt.printOddNumber();
			}
		});
        Thread t3 = new Thread(new Runnable() {
			public void run()
			{
				mt.printFibonacciNumber();
			}
		});
        Thread t4 = new Thread(new Runnable() {
			public void run()
			{
				mt.printPrimeNumber();
			}
		});
		t1.start();
		t2.start();
        t3.start();
        t4.start();
	}
}
