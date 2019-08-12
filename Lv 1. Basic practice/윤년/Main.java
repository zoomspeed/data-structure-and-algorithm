import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       
       int N = sc.nextInt();
       
       if(N%400==0){
         
         System.out.println("YES");
         return;
       }
       
       
       if(N%4==0 && N%100!=0){
         
         System.out.println("YES");
       }
       else{
         System.out.println("NO");
       }
    }
}