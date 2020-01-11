import java.util.*;

public class Main {

	static int N;
	static int M;

	static final int MAX = 1050;

	static int[][] arr = new int[MAX][MAX];
	static int[][] sum = new int[MAX][MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				arr[i][j] = sc.nextInt();
			}
		}
		sum[0][0] = arr[0][0];

		for (int i = 1; i < N; i++) {

			sum[i][0] = sum[i - 1][0] + arr[i][0];
		}

		for (int i = 1; i < M; i++) {

			sum[0][i] = sum[0][i - 1] + arr[0][i];
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {

				if (sum[i - 1][j] > sum[i][j - 1]) {

					sum[i][j] = sum[i - 1][j] + arr[i][j];
				} else {
					sum[i][j] = sum[i][j - 1] + arr[i][j];
				}
			}

		}

		System.out.println(sum[N - 1][M - 1]);

	}

}
