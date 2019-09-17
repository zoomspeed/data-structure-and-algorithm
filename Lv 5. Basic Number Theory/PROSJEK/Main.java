import java.util.Scanner;
public class Main{
  static int N =0;
  static int arr[];
  static int answer[];
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       
       N =sc.nextInt();
       
       arr = new int[N];
       answer = new int[N];
       
       
       
       for(int i=0; i<N; i++){
         arr[i] = sc.nextInt();
       }
       

       if(N==1){
         
         System.out.println(arr[0]);
         return;
       }
       answer[0] = arr[0];
       
       for(int i=1; i<N; i++){
         answer[i] = (arr[i]*(i+1)) - getNum(i);
       }
       
       for(int i=0; i<answer.length; i++){
         System.out.print(answer[i]+" ");
       }
    }
    
    public static int getNum(int n){
      
      int sum=0;
      
      for(int i=0; i<n; i++){
        sum = sum+answer[i];
      }
      
      return sum;
    }
}
