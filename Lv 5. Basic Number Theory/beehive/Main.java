import java.util.Scanner;

public class Main {
	
	public static void main(String args[]){
		
		Scanner scan = new 	Scanner(System.in);
		int N=0,count=0;
		N = scan.nextInt();
		
		
		for(int i=1; i<N; i=i+6*count){
			
			count++;
			
			
		}
		System.out.println(count+1);
	}

}