import java.util.Scanner;

public class Main {
	static int C = 0;
	static int R = 0;
	static int arr[][];
	static int Flag = 1;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		C = sc.nextInt();
		R = sc.nextInt();
		int X = 0;
		X = sc.nextInt();

		arr = new int[R][C];
		int count = 1;// 숫자넣을것
		int point = 0;

		while (true) {

			if (count > R * C) {
				break;
			}

			if (Flag == 1) {
				for (int i = 0; i < arr.length - point; i++) {

					if (arr[arr.length - i - 1][point] == 0) {
						arr[arr.length - i - 1][point] = count++;
					}

				}
			}

			else if (Flag == 2) {

				for (int i = 0; i < arr[0].length; i++) {

					if (arr[point][i] == 0) {
						arr[point][i] = count++;
					}
				}
			}

			else if (Flag == 3) {

				for (int i = 0; i < arr.length; i++) {

					if (arr[i][arr[0].length - point - 1] == 0) {
						arr[i][arr[0].length - point - 1] = count++;
					}
				}
			}

			else if (Flag == 4) {

				for (int i = 0; i < arr[0].length; i++) {
					if (arr[arr.length - point - 1][arr[0].length - 1 - i] == 0) {
						arr[arr.length - point - 1][arr[0].length - 1 - i] = count++;
					}
				}
			}

			Flag++;

			if (Flag == 5) {
				point++;
				Flag = 1;
			}

		}
		boolean answer = false;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == X) {
					System.out.println((j + 1) + " " + (arr.length - i));
					answer = true;
				}
			}
		}

		if (!answer) {
			System.out.println(0);
		}

	}
}