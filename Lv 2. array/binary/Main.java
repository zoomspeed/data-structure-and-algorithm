import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc = new Scanner(System.in);
      
      int N = sc.nextInt();
      int arr[] = new int[N];
      int index=0;    
        while(true){
          if(N==0){
            //System.out.print(0);
            arr[index++] = 0;
            break;
          }
          else if(N==1){
            //System.out.print(1);
            arr[index++] = 1;
            break;
          }
          //System.out.print(N%2);
          arr[index++] = N%2;
          N = N/2;
        }
        
        for(int i=0; i<index;i++){
          System.out.print(arr[index-i-1]);
        }
    }
}