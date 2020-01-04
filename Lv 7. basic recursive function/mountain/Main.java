import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      
      mountain(N);
      
    }
    
    public static void mountain(int N){
      
      if(N==1){
        System.out.print(N);
      } 
      else {
        mountain(N-1);
        System.out.print(N);
        mountain(N-1);
      }
    }
}