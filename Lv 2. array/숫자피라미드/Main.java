import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int S = sc.nextInt();
       int index=0;
       String arr[][] = new String[N][2*(N-1)+1];
       int i=0,j=0;
       for(i=0;i<N;i++){
         index=0;

         
         for(j=0; j<N-i-1;j++){
           //System.out.print("#");
           arr[i][index++] = " ";
         }
         //System.out.print(index);
         //index=j;
         
         if(i%2==0){
           int count=0;
            for(j=index+i*2; j>=index; j--){
           
              if(S%10==0){
                S=1;
              }
              //System.out.print(S++%10);
              arr[i][j]=String.valueOf(S++%10);
              //System.out.print("ss"+arr[i][j]);
              count++;
            }
            index=index+count;
            
         }
         else {

           
           
            for(j=0; j<2*i+1; j++){
           
              if(S%10==0){
                S=1;
              }
              //System.out.print(S++%10);
              arr[i][index++]=String.valueOf(S++%10);
            }
          
         }
                  //System.out.print(index);
        //index=j;
         for(j=0; j<N-i-1;j++){
           //System.out.print("#");
           arr[i][index++]=" ";
         }
         
         //System.out.println();
       }
       
       for(i=0; i<arr.length; i++){
         for(j=0; j<arr[i].length; j++){
           System.out.print(arr[i][j]);
         }
         System.out.println();
       }
    }
}