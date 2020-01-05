import java.util.*;

public class Main{
  static int N;
  static int arr[];
  static int index=0;//중복을 피하기 위한 인덱스
  static int result[] = new int[2]; // 최솟값 출력할것
  static int temp[] = new int[2]; // 최솟값 출력할것
  static int min = 0;
  static int current = 0;//현재 이진탐색에서 가장 작은값 저장.
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
       // Please Enter Your Code Here
      N =sc.nextInt();
      arr = new int[N];
      
      for(int i=0; i<N; i++){
        arr[i] = sc.nextInt();
      }
      
      Arrays.sort(arr);

      result[0] = 1000000001;
      result[1] = 1000000001;
  
      int tempMin = Integer.MAX_VALUE;
      int arrIndx = 0;
      for(int i=0; i<arr.length; i++){
        
        min = Integer.MAX_VALUE;
        index = i;
        
        temp[0] = arr[i];
        arrIndx = binarySearch(0, arr.length-1, -arr[i]);
        temp[1] = arr[arrIndx];
        
        min = temp[0]+temp[1];

        if(Math.abs(tempMin)>Math.abs(min)){
          tempMin = min;
          result[1] = temp[1];
          result[0] = temp[0];          
          
        }
        else if(Math.abs(tempMin)==Math.abs(min)){
          if((temp[0]<result[0]&&temp[0]<result[1]) || (temp[1]<result[1]&&temp[1]<result[0])){
            
            result[1] = temp[1];
            result[0] = temp[0];
          }
        }
      }

      if(result[0]>result[1]){
        System.out.print(result[1]+ " "+result[0]);
      }
      else {
        System.out.print(result[0]+" "+result[1]);
      }
    }
    
    
    public static int binarySearch(int start, int end, int val){
      
      if(arr[start]==val){
        return start;
      }
      
      if(arr[end]==val){
        return end;
      }
      
      int mid = 0;
      
      while(start+1<end){
        
        mid = (start+end)/2;

        if(arr[mid]==val){
          
          return mid;
        }
        else if(arr[mid]<val){
          
          start = mid;
        }
        else{
          end = mid;
        }        
      }
      
      if(Math.abs(arr[start]-val)<Math.abs(arr[end]-val)){
        
        if(index==start){
          return end;
        }
        else return start;
      }
      else {
        if(index==end){
          return start;
        }
        else return end;
      }  

    }

    public static boolean check(int mid ,int val){
 
      return false;
    }    
    
}
    

