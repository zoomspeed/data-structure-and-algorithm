import java.util.Scanner;
public class Main{
  static int N = 0;
  static int answer=0;
  static int arr[];
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextInt();
      arr = new int [N];
      
      for(int i=1; i<=N-1; i++){
        
        f(N-i,0,0);
      }

      System.out.println(answer);
    }
    
    
    static void f(int num,int sum,int count){
      
      sum=sum+num;
      
      if(num<1){
        return;
      }
      
      if(sum==N){
        arr[count] = num;
        printAll(count);
        answer++;
        return;
      }
      else if(sum>N){
        return;
      }
      arr[count] = num;
      
      for(int i=0; i<num; i++){
        f(num-i,sum,count+1);
      }
    }
    
    
   
    public static void printAll(int count){
      for(int j=0; j<count+1; j++){
        System.out.print(arr[j]);
        if(j!=count){
          System.out.print("+");
        }
      }
      System.out.println();
    }       
    //4 3 2 1 
    //3 2 1 1
}