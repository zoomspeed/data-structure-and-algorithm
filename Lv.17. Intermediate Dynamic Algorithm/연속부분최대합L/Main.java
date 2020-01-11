import java.util.*;

public class Main {
	static int N;
	static final int MAX = 1000500;
	static int Table[] = new int[MAX];
	static int SUM[] = new int[MAX];
	static int answer = -Integer.MAX_VALUE;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		// 연속부분 최대합 (동적계획법)

		// 1. Table 정의
		// 2. 점화식

		// Table(i) = i번째 숫자를 오른쪽 끝으로 하는 연속 부분 최대합
		// Table(i) = max(Table(i-1) + Data(i), Data(i))

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			Table[i] = sc.nextInt();
		}

		SUM[0] = Table[0];

		for (int i = 1; i < N; i++) {

			if (Table[i] > SUM[i - 1] + Table[i]) {

				SUM[i] = Table[i];
			} else {
				SUM[i] = SUM[i - 1] + Table[i];
			}

			if (answer < SUM[i]) {
				answer = SUM[i];
			}
		}

		System.out.println(answer);

	}

}