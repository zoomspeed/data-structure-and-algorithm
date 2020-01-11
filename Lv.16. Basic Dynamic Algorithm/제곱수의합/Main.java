import java.util.*;

public class Main {
	static int N;
	static final int MAX = 100050;
	static int dp[] = new int[MAX];
	static int count = Integer.MAX_VALUE;

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;

		for (int i = 1; i <= (int) Math.sqrt(100050); i++) {

			dp[i * i] = 1;
		}

		for (int i = 5; i <= N; i++) {

			if (dp[i] != 0) {
				continue;
			}

			for (int j = 2; j * j <= i; j++) {

				if (dp[i] == 0) {

					dp[i] = dp[i - (j * j)] + 1;
				} else if (dp[i] > dp[i - (j * j)] + 1) {

					dp[i] = dp[i - (j * j)] + 1;
				}

			}
		}

		System.out.println(dp[N]);

	}

}