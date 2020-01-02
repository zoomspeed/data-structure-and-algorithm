import java.util.Scanner;
public class Main{
  static int count=0;
  static int compare=0;
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc = new Scanner(System.in);
      
      String q = sc.next();
      String a = sc.next();
      boolean isBreak=false;

      for(int i=0; i<q.length(); i++){
        
        if(count == a.length()){
           break;
        }                 
        
        compare=count;
      
        if(q.charAt(i)==a.charAt(count)){
           count++;
         }
     
        if(compare>=count){
          count=0;
          compare=0;
        }
      }

      if(count==a.length()){
        System.out.println("YES");
      }
      else {
        System.out.println("NO");
      }
    }
}