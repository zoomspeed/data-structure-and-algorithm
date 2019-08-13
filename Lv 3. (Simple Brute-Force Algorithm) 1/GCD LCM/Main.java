import java.util.Scanner;
public class Main{
  
  static int NMG[] = new int[2];
  static int N,M;

  
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       
       N = sc.nextInt();
       M = sc.nextInt();
       
       int min = 0;
       int GCD = 1;
       int LCM = 1;
       int val = 0;
       int LMOK = 0;
       int MMOK = 0;
       int arr[];
       boolean isContinue=true;
       /*
       int NMG = 0;
       int MK = 1;*/
       
       if(N>=M){
         min = M;
       }
       else {
         min = N;
       }
       
       arr = new int[min];
       val = min;
       LMOK=N;
       MMOK=M;
       
       while(isContinue){
         
         isContinue=false;
         
         for(int i=1; i<=val; i++){
           
           if(i!=1 && LMOK%i==0 && MMOK%i==0){
             GCD = GCD*i;
             isContinue=true;
             val=val/i;
             LMOK = LMOK/i;
             MMOK = MMOK/i;
             
             //System.out.println("GCD: "+GCD);
             //System.out.println("val: "+val);
             
             break;
           }
           
         }
         
         
         
       }
       
       
      LCM=N/GCD * M/GCD*GCD;
      
      System.out.println(GCD);
      System.out.println(LCM);
     
   
      
    }
}