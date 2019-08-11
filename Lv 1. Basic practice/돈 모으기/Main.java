import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       
       int N = sc.nextInt();
       int time =1;
       int sum = 0;
       for(int i=1; sum<N; i++){
         
         sum = sum+i;
         
         if(sum>=N){
           
           System.out.println(time);
           return;
         }
         
         
         time++;
       }
    }
}