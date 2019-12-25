import java.util.Scanner;
public class Main{
  static int N=0;
  static int M=0;
  static int arr[][];
  static int sum=0;
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc=  new Scanner(System.in);
      
      N = sc.nextInt();
      M = sc.nextInt();
      
      if(N==0){
        System.out.println(1);
        return;
      }
      else if(N==1){
        System.out.println(1);
        return;
      }
      
      arr = new int[N+1][N+1];
      
      arr[0][0] = 1;
      arr[1][0] = 1;
      arr[1][1] = 1;
      
      
      
      for(int i=2; i<arr.length; i++){
        
        for(int j=0; j<arr[0].length; j++){
          
          if(j!=0){
            arr[i][j] = arr[i][j] + arr[i-1][j-1];
          }
          arr[i][j] = arr[i][j] + arr[i-1][j];
        }
      }

      
      System.out.println(arr[N][M]);

    }
}