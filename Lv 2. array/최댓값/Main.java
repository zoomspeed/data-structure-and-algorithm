import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc = new Scanner(System.in);
      int arr[] = new int[9];
      int index=0;
      
      for(int i=0; i<9; i++){
        
        arr[i] = sc.nextInt();        
      }
      
      index = 0;
      for(int i=0; i<9; i++){
        
        if(arr[index]<arr[i]){
          index = i;
        }        
      }
      
      System.out.println(arr[index]);
      System.out.println(index+1);
    }
}