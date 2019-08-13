import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       
       int N = sc.nextInt();
       
       int arr[][] = new int[N][7];
       int add=0;
       int maxNum= 0;
       int maxCount = 0;
       int maxVal = 0;
       int result[] = new int[N];
       int answer=0;
       
       for(int i=0; i<N; i++){
         for(int j=0; j<3; j++){
           arr[i][sc.nextInt()]++;
         }
       }
       
       for(int i=0; i<N; i++){
         
         maxNum = 1;
         maxCount = arr[i][1];
         
         for(int j=1; j<6; j++){
           
           if(maxCount<=arr[i][j+1]){
             maxNum = j+1;
             maxCount = arr[i][j+1];
             
           }
      
         }

         if(maxCount==3){
           add = 10000;
           result[i] = add+maxNum*1000;
         } else if(maxCount==2){
           add=1000;
           result[i] = add+maxNum*100;
         } else if(maxCount==1){
           add=0;
           result[i] = maxNum*100;
         }
       }
       
       
       answer = result[0];
       for(int i=0; i<result.length-1; i++){
         if(answer<result[i+1]){
           answer = result[i+1];
         }
       }
       
       
       
       System.out.println(answer);
       

    }
}