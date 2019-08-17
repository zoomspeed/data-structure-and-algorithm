import java.util.*;

public class Main {

	static int N = 0;

	static final int MAX = 1050;
	static int arr[] = new int[MAX];
	static int colorcnt = 6;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		if(N<3){
			
			System.out.println("NO");
			return;
		}
		
		for(int i=0; i<N; i++){
			
			int color = sc.nextInt();
			
			arr[color]++;
			
		}
		//System.out.println(total);
		
		for(int i=0; i<MAX; i++){
			
			
			if(arr[i]>0){
				
				if(arr[i]>2){
					
					colorcnt -= 2; 
				}
				else{
					
					colorcnt -= arr[i];
				}
			}
		}
		
		
		if(colorcnt>0){
			System.out.println("NO");
			
		}
		else{
			System.out.println("YES");
		}
		

		
	}
	


}
