import java.util.Scanner;

public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int arr[][] = new int[N][N];
       int count=0;
       int x=0,y=0;
       int number=1;
       
       for(int i=0; i<arr.length; i++){
         x=count;
         y=0;
         for(int j=count; j>=0; j--){
           
            arr[y++][x--] = number++;
         }
         count++;
       }

       for(int i=0; i<arr.length; i++){
         for(int j=0; j<arr[i].length; j++){
           if(arr[i][j]!=0)
            System.out.print(arr[i][j]+" ");
         }
         System.out.println();
       }       
    }
}