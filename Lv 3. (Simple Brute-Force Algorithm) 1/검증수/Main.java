import java.util.*;

public class Main {

	static int N = 0;

	static final int MAX = 10;
	static int total = 0;
	static int answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		
		for(int i=0; i<5; i++){
			
			int num = sc.nextInt();
			
			total += num*num;
			
			
		}
		//System.out.println(total);
		answer = total%10;
		
		System.out.println(answer);
		
	}
	


}