import java.util.Scanner;

public class Main {
	static final int RANGE = 100500;
	static int Table[] = new int[RANGE];
	static int N = 0;
	static int sum = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		/*
		 * 1+1+1+1 1+1+2 1+2+1 2+1+1 2+2 1+3 3+1
		 * 
		 * 
		 * 맨 뒤가 1로 끝나는 경우 1+1+1+1 1+2+1 2+1+1 3+1 맨 뒤가 2로 끝나는 경우 1+1+2 2+2 맨 뒤가
		 * 3으로 끝나는 경우 1+3
		 * 
		 * 1,T(3) 2,T(2) 3,T(1)
		 * 
		 * T(3) = 4가지 1+1+1 2+1 1+2 3
		 * 
		 * 1,T(2) = 2가지 1+1 2
		 * 
		 * 1,T(1) = 1가지
		 * 
		 * 
		 */

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		// T(1) = 1
		// T(2) = T(1) + 1;
		// T(3) = T(2) + T(1) + 1;
		// T(4) = T(3) + T(2) + T(1);

		Table[1] = 1;

		for (int i = 2; i <= 3; i++) {

			sum = sum + Table[i - 1];
			Table[i] = sum + 1;
		}

		for (int i = 4; i <= N; i++) {

			for (int j = i - 3; j <= i - 1; j++) {

				Table[i] = (Table[i] + Table[j]) % 1000007;

			}
		}

		System.out.println(Table[N]);

	}
}