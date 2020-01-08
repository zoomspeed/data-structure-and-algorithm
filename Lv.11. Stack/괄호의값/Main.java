import java.util.Scanner;
public class Main{
  
  static String s1;
  static char c;
  static int arr[] = new int[2];
  
    public static void main(String[] args){

       // Please Enter Your Code Here
       Scanner sc = new Scanner(System.in);
       s1  = sc.next();

       stack s = new stack();  
       
       s.create(s1.length());
       for(int i=0; i<s1.length(); i++){
         
         c = s1.charAt(i);
         
         if(s.isError(c)){
           
           System.out.println(0);
           return;
         }
         
         s.push(c);
         s.VPS(c);
         
         arr = s.getPoint();
         
         if(arr[0]<0 || arr[1]<0){
           
           System.out.println(0);
           return;
         }

       }
       
       
       arr = s.getPoint();
       
       if(arr[0]!=0 || arr[1]!=0){
         
         System.out.println(0);
         return;
         
       }
       
       System.out.println(s.getSum());    
        
  }
}

class stack{
    
    int base=1;
    int sum=0;
    int capacity = 0;
    char arr[];
    int len = 0;
    boolean isAdd = false;
    int point1 = 0;
    int point2 = 0;
    
    public stack(){
      
    }
    
    public int getSum(){
      
      return sum;
    }
    
    public void create(int  N){
      
      this.capacity = N;
      arr = new char[N];
    }
    
    public int size(){
      
      return arr.length;
    }

    public void push(char n){
        
        if(capacity==len){
          
          System.out.println("Overflow");
        }
        else{
          arr[len++] = n;
        }
    }
    
    public char pop(){
      
      if(len==0){
        
        System.out.println("Underflow");
        return '0';
      }
      else{
        
        return arr[--len];
      }
    }
    
    public char top(){
      
      if(len==0){
        
        System.out.println("NULL");
        return '0';
      }
      else{
        
        return arr[len-1];
      }
    }
    
    public int[] getPoint(){
      
      int pointArr[] = new int[2];
      
      pointArr[0] = point1;
      pointArr[1] = point2;
      
      return pointArr;
    }
    
    public void VPS(char c){
      

      if(c=='('){
        
        isAdd = true;
        base = base*2;
        point1++;
      }
      else if(c==')'){
        
        setAdd();        
        isAdd = false;
        base = base/2;
        point1--;
      }
      
      if(c=='['){
        
        isAdd = true;
        base = base*3;
        point2++;
      }
      else if(c==']'){
        
        setAdd();        
        isAdd = false;
        base = base/3;        
        point2--;
      }
      
      
    }
    
    
    
    public void setAdd(){
      
       if(isAdd){
        //System.out.println(base);
        sum = sum + base;
        }
      
    }
    
    
    public boolean isError(char n){
      
        if(len==0){
          
          return false;
        }
      
        if( n==')'){
          
          if(arr[len-1]=='['){
            
            return true;
          }
        }

          
        if(n==']'){
          
          if(arr[len-1]=='('){
            
            return true;
          }          
        }
        
        
        return false;
    }
  
 
}