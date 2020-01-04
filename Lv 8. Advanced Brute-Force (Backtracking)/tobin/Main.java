import java.util.Scanner;

public class Main{
  static int iszero=0;
  static int count = 0;
  static int index=0;
  static int n=0,k=0;
  static int arr[];
  
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       
       n = sc.nextInt();
       k = sc.nextInt();
       arr = new int[n];
       
        tobin(0,0);

    }

    
        
    public static void tobin(int width,int len){
      
      if(width>n){
        return;
      }
      else if(len>k){
        return;
      }
      else if(width==n){
        if(len==k){
          printAll();
        }
        return;
      }
      else{
        arr[width] = 1;
        tobin(width+1,len+1);
        arr[width] = 0;
        tobin(width+1,len);
        return;
      }

    }
    
    public static int test(){
        int check=0;
        for(int i=0; i<arr.length; i++){
          
          if(arr[i]==1){
            check++;
          }
        }
        
        return check;
    }
    
    public static void printAll(){
      
      for(int i=0; i<arr.length; i++){
        
        System.out.print(arr[i]);
      }
      System.out.println();
    }
          
    public static void reset(){
      
      for(int i=0; i<arr.length; i++){
        
        arr[i]=0;
      }
    }        

}