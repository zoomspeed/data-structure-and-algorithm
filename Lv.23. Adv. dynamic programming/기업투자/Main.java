import java.util.*;

public class Main {
	static int N = 0;
	static int M = 0;
	static final int MAX = 350;
	static int arr[][] = new int[MAX][MAX];
	static long dp[][] = new long[MAX][MAX];
	static long answer = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 1; i <= N; i++) {

			int n = sc.nextInt();

			for (int j = 0; j < M; j++) {

				arr[j][n] = sc.nextInt();
			}

		}

		for (int i = 0; i <= N; i++) {

			dp[0][i] = arr[0][i];
		}

		for (int i = 1; i < M; i++) {

			for (int j = 1; j <= N; j++) {
				long data = 0;

				for (int k = 0; k <= j; k++) {

					data = Math.max(dp[i - 1][k] + arr[i][j - k], data);
				}
				dp[i][j] = data;
			}
		}

		System.out.println(dp[M - 1][N]);
	}
}