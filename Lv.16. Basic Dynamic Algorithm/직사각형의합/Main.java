import java.util.Scanner;

public class Main {

	static final int MAX = 1050;
	static int arr[][] = new int[MAX][MAX];
	static int sum[][] = new int[MAX][MAX];
	static int N, M, Q = 0;
	static int position1[] = new int[2];
	static int position2[] = new int[2];
	static int answer = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		Q = sc.nextInt();
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {

			sum[i][0] = arr[i][0];
		}

		for (int i = 0; i < N; i++) {

			for (int j = 1; j < M; j++) {

				sum[i][j] = arr[i][j] + sum[i][j - 1];
			}
		}

		for (int i = 0; i < Q; i++) {
			answer = 0;
			position1[0] = sc.nextInt();
			position1[1] = sc.nextInt();

			position2[0] = sc.nextInt();
			position2[1] = sc.nextInt();

			for (int j = position1[0]; j <= position2[0]; j++) {

				if (position1[1] == 0) {
					answer = answer + sum[j][position2[1]];
				} else {
					answer = answer + sum[j][position2[1]] - sum[j][position1[1] - 1];
				}

			}
			System.out.println(answer);
		}
	}

}