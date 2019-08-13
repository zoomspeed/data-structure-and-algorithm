import java.util.*;

public class Main {

	static int N = 0;
	static int answer = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		for(int i=0; i<5; i++){
			
			int car = sc.nextInt();
			
			if(N==car){
				
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
	


}