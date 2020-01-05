import java.util.Scanner;
public class Main{
  
    static long N;
    
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextLong();

      long max = Long.parseLong("1000000000000000000");
      long answer = binarySearch(0, (long)Math.sqrt(max), N);
      System.out.println(answer);
    }
    
    
    public static long binarySearch(long start, long end, long val){
      //start는 언제나 mid보다 작다.
      //end는 언제나 mid보다 크다.
      //start에서 계사
      
      long mid = 0;
      
      
      if(start*start+start>val){
        
        return -1;
      }
      else if(check(start,val)){
        
        return start;
      }
      
      if(end*end+end<val){
        return -1;
      }
      else if(check(end,val)){
        
        return end;
      }
      

      
      while(start+1<end){
        
        mid = (start+end)/2;     
        if(check(mid,val)){
          return mid;
        }
        else if(mid*mid+mid<val){
          
          start = mid;
        }
        else{
          end = mid;
        }
      }
      
      return mid;
    }
    
    
    public static boolean check(long num, long val){
      
      if(num*num+num<=val&&(num+1)*(num+1)+num+1>val){
        
        return true;
      }
      
      return false;
    }
    

}