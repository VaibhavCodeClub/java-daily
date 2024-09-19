import java.util.*;
class rotateList 
{
    public static void main(String[] args) 
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=s.nextInt();
        int k=s.nextInt();

        while(k!=0)
        {
            int temp=arr[0];
            for(int i=0;i<n-1;i++)
                arr[i]=arr[i+1];
            arr[n-1]=temp;
            k--;
        }
        System.out.println(Arrays.toString(arr));
    }
}