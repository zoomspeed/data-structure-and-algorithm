import java.util.Scanner;
public class Main{
  
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc = new Scanner(System.in);
      
      int N =sc.nextInt();
      
      int answer = factorial(N);
      
      System.out.println(answer);
    }
    
    public static int factorial(int n){

      if(n==1){
        return 1;
      }
      
      return n * factorial(n-1);
    }
}