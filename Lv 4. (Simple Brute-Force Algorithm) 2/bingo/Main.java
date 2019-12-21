import java.util.Scanner;

public class Main {
	static int answer[][];
	static int arr[][];
	static int result[][];
	static int k = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		arr = new int[5][5];
		answer = new int[5][5];
		result = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				answer[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				input(i, j);
				if (check()) {
					System.out.println(i * 5 + j + 1);
					return;
				}

			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
			}
		}

	}

	public static void input(int y, int x) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == answer[y][x]) {

					result[i][j] = 1;

				}

			}
		}

	}

	public static boolean check() {

		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			for (k = 0; k < arr[i].length; k++) {

				if (result[i][k] == 0) {
					break;
				}
			}

			if (k == 5) {
				count++;
			}

			for (k = 0; k < arr[i].length; k++) {

				if (result[k][i] == 0) {
					break;
				}
			}
			if (k == 5) {
				count++;
			}

		}

		for (k = 0; k < arr.length; k++) {
			if (result[k][k] == 0) {
				break;
			}

		}
		if (k == 5) {
			count++;
		}

		for (k = 0; k < arr.length; k++) {
			if (result[k][arr.length - k - 1] == 0) {
				break;
			}

		}
		if (k == 5) {
			count++;
		}

		if (count >= 3) {
			return true;
		} else {
			return false;
		}

	}
}