import java.util.Scanner;

public class Main {
	static int N;
	static int sum = 0;
	static int arr[][];
	static int answer[];
	static int ab[] = new int[2];
	static int row = 0;
	static int column = 0;
	static int count = 0;
	static int j = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		arr = new int[N][N];
		answer = new int[N];

		for (int i = 0; i < N; i++) {
			for (j = 0; j < N; j++) {

				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			count = 0;
			for (j = 0; j < N; j++) {

				if (arr[j][i] != 0) {
					ab[count++] = arr[j][i];

					if (count == 1) {
						row = j;
					}
					if (count == 2) {
						column = j;
					}

					if (count >= 2) {
						break;
					}
				}
			}
			answer[i] = (ab[0] + ab[1] - arr[row][column]) / 2;
			count = 0;
		}

		for (int i = 0; i < answer.length - 1; i++) {
			System.out.print(answer[i] + " ");
		}
		System.out.println(answer[answer.length - 1]);

	}

}