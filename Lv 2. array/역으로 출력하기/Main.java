import java.util.Scanner;
public class Main{
  static int N = 0;
  static int M = 0;
  static final int MAX = 1500;
  static int arr[] = new int[MAX];
  static boolean isTrue = false;
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       
       N = sc.nextInt();

       
       
       for(int i=0; i<N; i++){
    	   
    	   arr[i] = sc.nextInt();
       }
       
       for(int i=N-1; i>=0; i--){
    	   
    	   System.out.print(arr[i]+" ");
       }
       
    }
}