import java.util.*;

public class Main {

	static int N = 0;
	static int M = 0;
	static String s = "";
	static String reverse = "";
	static final int MAX = 1050;
	static int num[] = new int[MAX];
	static char character[] = new char[MAX];
	static int arr[][] = new int[MAX][MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		s = sc.next();

		for (int i = N - 1; i >= 0; i--) {

			reverse = reverse + s.charAt(i);
		}
		for (int i = 0; i < M; i++) {

			char c = sc.next().charAt(0);
			int insert = sc.nextInt();
			int delete = sc.nextInt();

			character[i] = c;
			num[i] = Math.min(insert, delete);
		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				if (s.charAt(i) == character[j]) {

					arr[0][i + 1] = arr[0][i] + num[j];
					break;
				}
			}

			for (int j = 0; j < M; j++) {

				if (reverse.charAt(i) == character[j]) {

					arr[i + 1][0] = arr[i][0] + num[j];
					break;
				}
			}
		}

		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= N; j++) {

				if (reverse.charAt(i - 1) == s.charAt(j - 1)) {

					arr[i][j] = arr[i - 1][j - 1];
				} else {

					int leftAlp = 0;
					int upAlp = 0;

					for (int k = 0; k < M; k++) {

						if (reverse.charAt(i - 1) == character[k]) {

							leftAlp = num[k];
							break;
						}
					}
					for (int k = 0; k < M; k++) {

						if (s.charAt(j - 1) == character[k]) {

							upAlp = num[k];
							break;
						}
					}

					int left = arr[i][j - 1] + upAlp;
					int up = arr[i - 1][j] + leftAlp;

					arr[i][j] = Math.min(left, up);
				}

			}
		}
		System.out.println(arr[N][N] / 2);
	}

}
