import java.util.Scanner;
public class Main{
  static int n=0;
  static int r = 0;
  static String alpabet[] = {"a","b","c","d","e","f","g","h","i","j"};
  static String arr[];
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc = new Scanner(System.in);
      
      n = sc.nextInt();
      r = sc.nextInt();
      

      arr = new String[r];
      
      if(r==0){
        return;
      }      
      
      for(int i=0; i<n; i++){
        
        solution(i, 0);
      }
      
    }
    
    
    public static void solution(int index,int length){
      
      if(index>=n){
        return;
      }
      
      if(check(index, length)){//같은값이 배열에 있을경우 return
        return;
      }
      arr[length] = alpabet[index];
    
      if(length==r-1){
        printAll();
        return;
      }

      for(int i=0; i<n; i++){
        solution(i, length+1);
      }
      
      return;
      
    }
    
    
    public static void printAll(){
      
      String s ="";
      for(int i=0; i<arr.length; i++){
        
        s=s+""+arr[i];
      }
      System.out.println(s);
    }
    

    public static boolean check(int index, int length){
      
      for(int i=0; i<length; i++){
        
        if(alpabet[index].equals(arr[i])){
          return true;
        }
      }
      return false;
    }    
    
    
}