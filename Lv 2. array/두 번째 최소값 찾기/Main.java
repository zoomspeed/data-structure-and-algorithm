import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc = new Scanner(System.in);
      int arr[] = new int[9];
      int answer[] = new int[9];
      int index=0;
      int temp=0;
      
      for(int i=0; i<9; i++){
        
        arr[i] = sc.nextInt();        
      }
      
      for(int i=0; i<9; i++){
        
        answer[i] = arr[i];  
      }      
     
      
      for(int i=0; i<9; i++){
        index=i;
        for(int j=i; j<9; j++){
          if(answer[index]>answer[j]){
            index = j;
          }

        }
        temp  = answer[index];
        answer[index] = answer[i];
        answer[i] = temp;
      }
/*      
      for(int i=0; i<answer.length; i++){
        
        System.out.print(answer[i]+" ");
      }*/

      System.out.println(answer[1]);

      
      for(int i=0; i<arr.length; i++){
        if(answer[1]==arr[i]){
          System.out.println(i+1);
          return;
        }
      }
            
      
    }
}