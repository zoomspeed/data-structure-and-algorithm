import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       
       int N = sc.nextInt();
       int M = sc.nextInt();
       int arr[][] = new int[N][M];
       int x=0,y=0;
       int count = 1;
       
       for(int i=0; i<N; i++){
         
         for(int j=0; j<M; j++){
           arr[i][j] = sc.nextInt();
         }
       }

       
       x=sc.nextInt();
       y=sc.nextInt();
       
       System.out.println(arr[x][y]);
    }
}