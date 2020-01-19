import java.util.*;

public class Main {

	static int N = 0;
	static int M = 0;
	static final int MAX = 600;
	static int arr[] = new int[MAX];
	static int sum[] = new int[MAX];
	static int dp[][] = new int[MAX][MAX];
	static int point = 0;
	static int answer[] = new int[MAX];
	static int temp[] = new int[MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N; i++) {

			arr[i] = sc.nextInt();
		}

		sum[0] = arr[0];

		for (int i = 1; i < N; i++) {

			sum[i] = arr[i] + sum[i - 1];
		}

		for (int i = 0; i < N; i++) {

			dp[0][i] = sum[i];
		}

		int left = 0;
		int right = 0;

		for (int i = 1; i < N; i++) {

			for (int j = i; j < N; j++) {

				int min = Integer.MAX_VALUE;

				for (int k = i - 1; k < j; k++) {

					int n = Math.max(dp[0][j] - dp[0][k], dp[i - 1][k]);

					if (min > n) {
						min = n;
					}
				}

				dp[i][j] = min;
			}
		}

		System.out.println(dp[M - 1][N - 1]);
	}
}
