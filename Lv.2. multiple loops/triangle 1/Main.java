import java.util.Scanner;
public class Main{
  static int N = 0;
    public static void main(String[] args){

       // Please Enter Your Code Here
       
       Scanner sc = new Scanner(System.in);
       
       N = sc.nextInt();
       
       for(int i=0; i<N; i++){
         
         for(int j=N-i-1; j<N; j++){
           
           System.out.print("*");
         }
         System.out.println();
       }

    }
}
