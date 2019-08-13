import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here


      Scanner sc = new Scanner(System.in);
      int count=0;
      int val=0;
      int sum=0;
      int N = sc.nextInt();
      
      for(int i=0; i<N; i++){
        val = sc.nextInt();
        
        if(val==1){
          count++;
          sum = sum+count;
        } else {
          count = 0;
        }
      }
      
      System.out.println(sum);
    }
}