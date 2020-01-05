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

        
        arr = new int[N];
        
        left = new int[N];
        right = new int[N];
        

        for(int i=0; i<N; i++){
          
          arr[i] = sc.nextInt();
        }
        
        q = sc.nextInt();
        
        int question[] = new int[q];
        int answer[] = new int[q];
                
        
        for(int i=0; i<q; i++){
          
          question[i] = sc.nextInt();
        } 
        

        quickSort(0, arr.length-1);        

        for(int i=0; i<answer.length; i++){
          answer[i] = binarySearch(0, arr.length-1, question[i]);        
        }
        
        for(int i=0; i<answer.length; i++){
          if(answer[i]!=-1){
            System.out.println(1);
          }
          else{
            System.out.println(0);
          }
        }        
                
    }
    
    public static int binarySearch(int start, int end, int val){
      //value의 index를 반환함
      //없을시 -1
      
      int mid;

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
    
    public static void quickSort(int start, int end){
    

      int left_cnt;
      int right_cnt;
      
      if(start>=end){
        
        return;
      }
      int pivot = arr[start];      
      //피봇을 배열의 맨 첫번째 위치로 지정해서 start+1로 함.
      

      
      left_cnt = getLeft(start+1, end, pivot);
      right_cnt = getRight(start+1, end, pivot);
      
      //5 9 2 8 3 7 4 6 1 10
      //2 3 4 1   5<-pivot   9 8 7 6 10 
      for(int i=0; i<left_cnt; i++){
        
        arr[start+i] = left[i];
        //System.out.println(left[i]);
      }
      
      arr[start+left_cnt] = pivot;
      
      for(int i=0; i<right_cnt; i++){
        
        arr[start+left_cnt+1+i] = right[i];
      }
      
      quickSort(start, start+left_cnt-1);
      quickSort(start+left_cnt+1, end);
    }
    
    public static int getLeft(int start, int end, int pivot){
      
      int leftindx=0;
      for(int i=start; i<=end; i++){
        
        if(arr[i]<=pivot){
          
          left[leftindx++] = arr[i];
        }
      }
      //System.out.println(leftindx);
      return leftindx;
      
    }
    

    public static int getRight(int start, int end, int pivot){
      
      int rightindx=0;
      for(int i=start; i<=end; i++){
        
        if(arr[i]>pivot){
          
          right[rightindx++] = arr[i];
        }
      }
      
      return rightindx;      
    }    
}    
