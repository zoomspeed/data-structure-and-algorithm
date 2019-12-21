
import java.util.Scanner;

public class Main {
	static int x = 0;
	static int y = 0;
	static int val = 0;
	static int i = 0;
	static int check;
	static int num = 122;
	static int answer = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		int N[][] = new int[q][3];
		int List[][] = new int[q][3];
		int arr[] = new int[3];

		for (int i = 0; i < q; i++) {

			List[i][0] = sc.nextInt();
			List[i][1] = sc.nextInt();
			List[i][2] = sc.nextInt();
		}

		for (int i = 0; i < q; i++) {

			N[i][0] = List[i][0] / 100;
			N[i][1] = (List[i][0] % 100) / 10;
			N[i][2] = List[i][0] % 10;
		}

		while (num < 987) {

			int myNum[] = getCandidate();

			for (i = 0; i < q; i++) {

				int check[] = getCheck(myNum, N[i]);

				if (check[0] != List[i][1]) {
					break;
				} else if (check[1] != List[i][2]) {
					break;
				} else {

				}
			}

			if (i == q) {
				answer++;
			}

		}
		System.out.println(answer);
	}

	public static int[] getCheck(int arr[], int check[]) {

		int SB[] = { 0, 0 };// strike,ball;

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {
				if (arr[i] == check[j]) {

					if (i == j) {
						SB[0]++;
					} else {
						SB[1]++;
					}
				}
			}
		}

		return SB;
	}

	public static int[] getCandidate() {

		int array[] = new int[3];

		num++;
		while (true) {

			array[0] = num / 100;
			array[1] = (num % 100) / 10;
			array[2] = num % 10;

			if (array[0] == array[1] || array[1] == array[2] || array[0] == array[2]) {
				num++;

			} else if (array[0] == 0 || array[1] == 0 || array[2] == 0) {
				num++;
			} else {
				break;
			}
		}
		return array;
	}

}