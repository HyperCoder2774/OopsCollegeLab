public class Question2 {
    public static void main(String[] args) {
        int n=Integer.parseInt(args[0]);
        int ans=1;
        for(int i=1;i<=n;i++)ans*=i;
        System.out.println(ans);
    }
}
