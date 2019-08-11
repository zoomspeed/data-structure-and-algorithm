import java.util.Scanner;
public class Main{
  static final int MAX = 10050;
  static int arr[] = new int[MAX];
    public static void main(String[] args){

       // Please Enter Your Code Here
        Scanner sc = new Scanner(System.in);
        
        int len = 1;
        
        int A = sc.nextInt();
        int B =sc.nextInt();
        
        for(int i=1; i<=A; i++){
          
          
          if(A%i==0){
            arr[len++] = i;
          }
        }
        
        if(B>len-1){
          
          System.out.println(0);
        }
        else{
          System.out.println(arr[B]);
        }
    }
}