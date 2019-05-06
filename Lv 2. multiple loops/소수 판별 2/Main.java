import java.util.Scanner;
public class Main{
  static int N = 0;
  static int M = 0;
  static boolean isTrue = false;
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       
       N = sc.nextInt();
       M = sc.nextInt();
       
       for(int i=N; i<=M; i++){
    	   
         isTrue = true;
         
         for(int j=2; j<i; j++){
           
           if(i%j==0 || i==1){
             isTrue = false;
             break;
           }
         }
         if(isTrue && i!=1){
             System.out.print(i+" ");
         }

       }

    }
}