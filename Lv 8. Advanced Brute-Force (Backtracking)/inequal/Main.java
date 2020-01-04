import java.util.Scanner;
public class Main{
  static int N=0;
  static int arr[];
  static String inequal[];
  static int k=0;
  static int rank[] = new int[10];
  static boolean endroop = false;
  static boolean isBreak = false;
    public static void main(String[] args){
       // Please Enter Your Code Here
      Scanner sc=  new Scanner(System.in);
      N =sc.nextInt();
      
      arr=new int[N+1];
      inequal = new String[N];
      //최대값 구하기
      for(int i=0; i<N; i++){

        inequal[i] = sc.next();
      }
      
      for(int i=9; i>=0; i--){

        arr[0]=i;        
        
        for(int j=9; j>=0; j--){
          desc(j,1); 
          if(isBreak){
            endroop = true;
            break;
          }
        }
        
        if(endroop){
          break;
        }
      }
      
      
      
      
      endroop=false;
      isBreak=false;
      
      
        ////오름차순
        
        for(int i=0; i<arr.length; i++){
          arr[i] = -1;
        }      
      
      
      
      for(int i=0; i<10; i++){

        arr[0]=i;
                
        for(int j=0; j<10; j++){
          asc(j,1); 
          if(isBreak){
            endroop = true;
            break;
          }
        }

        
        if(endroop){
          break;
        }
      }
            
      
    }
    
    public static void desc(int num, int index){
      
      String s;
      //boolean isBreak=false;
      
      if(isBreak){
        return;
      }
      
      if(check(num,index-1)){
        //System.out.println("중복수 발견");
        return;
      }
      
      s = inequal[index-1]; //부등호 비교
      
      
      if(s.equals(">")&&arr[index-1]<=num){
        return;
      }
      else if(s.equals("<")&&arr[index-1]>=num){
        return;
      }
      
      arr[index] = num;

      
      if(index==N){ //출력
        isBreak = true;
        printAll();
        return;
      }
      
      for(int i=9; i>=0; i--){
        
        desc(i,index+1);
  
        
      }
      arr[index] = -1;     
      
      return;
    }
    
    
    
    
    public static void asc(int num, int index){
      
      String s;
      //boolean isBreak=false;
      
      if(isBreak){
        return;
      }
      
      if(check(num,index-1)){
        //System.out.println("중복수 발견");
        return;
      }
      
      s = inequal[index-1]; //부등호 비교
      
      
      if(s.equals(">")&&arr[index-1]<=num){
        return;
      }
      else if(s.equals("<")&&arr[index-1]>=num){
        return;
      }
      
      arr[index] = num;

      
      if(index==N){ //출력
        isBreak = true;
        printAll();
        return;
      }
      
      for(int i=0; i<=10; i++){
        
        asc(i,index+1);
  
        
      }
      arr[index] = -1;     
      
      return;      
    }
    
    public static boolean check(int num, int index){
      
      for(int i=0; i<index; i++){
        if(arr[i]==num){
          return true;
        }
      }
      return false;
    }
    
    public static void printAll(){
      
      for(int j=0; j<arr.length; j++){
        System.out.print(arr[j]);
      }
      System.out.println();
    }        
}