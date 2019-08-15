import java.util.Scanner;
public class Main{
    public static void main(String[] args){

       // Please Enter Your Code Here
      Scanner sc = new Scanner(System.in);
      
      int N =sc.nextInt();
      
      int Class[][] = new int[N][5];
      int rank[][] = new int[N][N];
      int position = 0;
      int val = 0;
      int count=0;
      
      int max=0;
      int result=0;
      
      for(int i=0; i<N; i++){
        
        for(int j=0; j<5; j++){
          Class[i][j] = sc.nextInt();
        }
      }
      
      
      for(int k=0; k<N; k++){
        
        position=k;
        
        for(int i=0; i<5; i++){
          
          val = Class[k][i];
          
          for(int j=0; j<N; j++){
            
            
            if(j==position){
              continue;
            }
            else if(Class[j][i]==val){

              rank[k][j]++;
            }
          }

        }
      }
      
      for(int i=0; i<rank.length; i++){
        count=0;
        for(int j=0; j<rank[i].length;j++){
          if(rank[i][j]!=0){
            count++;
          }
          
          
        }
        
        if(i==0){
          max=count;
          result = i+1;
        }
        else if(max<count){
          max=count;
          result = i+1;
        }  
        
      }
      
      
      System.out.println(result);
      
    }
}