interface A
{
    public abstract void execute1();
}
interface B
{
    public abstract void execute2();
}
class C implements A,B
{
    public void execute1()
    {
        System.out.println("Hi.. I am from execute1");
    }
    public void execute2()
    {
        System.out.println("Hi.. I am from execute2");
    }
}
public class Main
{
	public static void main(String[] args) 
	{
		C obj = new C();
		obj.execute1();
		obj.execute2();
	}
}
