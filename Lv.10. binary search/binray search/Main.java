import java.util.Scanner;
public class Main{
  static int N;
  static int q;
  static int arr[];
  static  int[] left;
  static  int[] right;
  
    public static void main(String[] args){

       // Please Enter Your Code Here
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        q = sc.nextInt();
        
        arr = new int[N];
        
        left = new int[N];
        right = new int[N];
        
        int question[] = new int[q];
        int answer[] = new int[q];
        
        for(int i=0; i<N; i++){
          
          arr[i] = sc.nextInt();
        }
        

        
        for(int i=0; i<q; i++){
          
          question[i] = sc.nextInt();
        } 
        



        for(int i=0; i<answer.length; i++){
          answer[i] = binarySearch(0, arr.length-1, question[i]);        
        }
        

        
        for(int i=0; i<answer.length; i++){
          if(answer[i]!=-1){
            System.out.println("YES");
          }
          else {
            System.out.println("NO");
          }
          //System.out.println(answer[i]);          
        }
 /*       for(int i=0; i<question.length; i++){
          System.out.println(question[i]);          
        }*/
                
    }
    
    public static int binarySearch(int start, int end, int val){
      //value의 index를 반환함
      //없을시 -1
      
      int mid;
      
/*      if(arr[start]>val){
        return -1;
      }
      else if()*/
      
      
      if(start>end){
        return -1;
      }
      
      if(start==end){
        
        if(arr[start]==val){
          return start;
        }
        else {
          return -1;
        }
      }
      //1 2 4 8 10 11 12 14 15 19
      mid = (start+end)/2;
      
      if(arr[mid]==val){
        return mid;
      }
      else if(arr[mid]>val){
        return binarySearch(start, mid-1, val);
      }
      else{
        return binarySearch(mid+1, end, val);
      }
      

    }
 
}    


