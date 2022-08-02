import java.util.Scanner;

public class Prime {
    public static void main(String[] args)
    {
        int n=5;
        System.out.println("Given number is : "+n);
//        Scanner in=new Scanner(System.in);
//        n=in.nextInt();
        int count=0;
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
            {
                count++;
            }

        }
        if(count==2)
        System.out.println("The given number is PRIME");
        else
            System.out.println("The given is NOT PRIME");

    }
}
