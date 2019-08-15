import java.util.*;

public class Main {

	static int N = 0;

	static final int MAX = 10;
	static int arr[][] = new int[MAX][MAX];
	static int answer[][] = new int[MAX][MAX];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		
		for(int i=0; i<MAX; i++){
			
			for(int j=0; j<MAX; j++){
				
				
				arr[i][j] = -1;
			}
		}
		
		
		for(int i=1; i<=5; i++){
			
			for(int j=1; j<=5; j++){
				
				
				arr[i][j] = sc.nextInt();
			}
		}
		

		
		
		for(int i=1; i<=5; i++){
			
			for(int j=1; j<=5; j++){
				
				
				if(arr[i-1][j]!=-1){
					
					if(arr[i][j]<arr[i-1][j]){
						
						answer[i][j]++;
					}
				}
				else{
					
					answer[i][j]++;
				}
				
				
				
				if(arr[i+1][j]!=-1){
					
					if(arr[i][j]<arr[i+1][j]){
						
						answer[i][j]++;

					}
				}
				else{
					
					answer[i][j]++;
				}
				
				
				
				
				if(arr[i][j-1]!=-1){
					
					if(arr[i][j]<arr[i][j-1]){
						
						answer[i][j]++;
						
					}
				}
				else{
					
					answer[i][j]++;
				}
				
				
				
				
				if(arr[i][j+1]!=-1){
					
					if(arr[i][j]<arr[i][j+1]){
						
						answer[i][j]++;
						
					}
				}
				else{
					
					answer[i][j]++;
				}
				
				
			}
		}
		
		//System.out.println(arr[3][6]);
		for(int i=1; i<=5; i++){
			
			for(int j=1; j<=5; j++){
				
				if(answer[i][j]==4){
					
					System.out.print("* ");
				}
				else{
					
					System.out.print(arr[i][j]+" ");
				}
			}
			System.out.println();

		}
		
		
	}
	


}
