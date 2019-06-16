import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
      //A가이기면 1 B가이기면2 비기면 0
      Scanner sc = new Scanner(System.in);
      int A[] = new int[10];
      int B[] = new int[10];
      int result[] = new int[10];
      int Awin=0;
      int Bwin=0;
      
      for(int i=0; i<10; i++){
        A[i] = sc.nextInt();  
      }
      

      for(int i=0; i<10; i++){
        B[i] = sc.nextInt();  
      }      
      
      
      for(int i=0; i<10; i++){
        if(A[i]>B[i]){
          result[i] = 1;
        } else if(A[i]<B[i]){
          result[i] = 2;
        } else {
          result[i] = 0;
        }
      }
      
      
      for(int i=0; i<10; i++){
        if(result[i]==1){
          Awin++;
        } else if(result[i]==2){
          Bwin++;
        }
      } 
      

      if(Awin>Bwin){
        System.out.println('A');
      } else if(Awin<Bwin){
        System.out.println('B');
      } else {
        System.out.println('D');
      }
      
    }
}