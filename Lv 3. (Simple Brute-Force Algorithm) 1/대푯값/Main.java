import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc = new Scanner(System.in);
      
      int arr[] = new int[10];
      
      int avg=0;
      int bin[] = new int[10];
      int sum=0;
      int result=0;
      int max=0;
      
      for(int i=0; i<10; i++){
        
        arr[i] = sc.nextInt();
      }
      

      for(int i=0; i<10; i++){
        
        sum = arr[i] + sum;
        
      }
      int temp = arr[0];
      
      for(int i=0; i<arr.length; i++){
        for(int j=0; j<arr.length-i-1; j++){
          
          if(arr[j]<arr[j+1]){
            temp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = temp;
          }
        }
      }
      
      
      
      for(int i=0; i<arr.length; i++){
        for(int j=i; j<arr.length; j++){
          if(i==j){
            continue;
          }
          else if(arr[i]==arr[j]){
            bin[i]++;
          }
        }
      }
      
      result = 0;
      max=bin[result];
      for(int i=0; i<bin.length; i++){
        if(bin[i]>max){
          result=i;
          max=bin[i];
        }

      }
      
      avg=sum/10;
      
      System.out.println(avg);
      System.out.println(arr[result]);
    }
}