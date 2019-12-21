import java.util.Scanner;

public class Main {
	static int k = 0;
	static int MAX = 0;
	static int arr[][];
	static int C = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		C = sc.nextInt();
		int R = sc.nextInt();

		int horizon = 0;// 수평선 개수 확인
		int x = 0; // 블록 위치
		int y = 0;
		int count = 0; // 수평선 개수
		int place[][] = new int[C][2];
		int max = 0;// x찾을 값 비교용
		boolean isFail = false;

		arr = new int[R][C];// 테트리스 배열

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int length = arr[0].length;
		int temp1 = arr.length;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < arr.length; j++) {

				if (arr[arr.length - 1 - j][i] == 0) {
					place[i][0]++;
				} else {
					place[i][0] = 0;
				}
				if (place[i][0] == 1) {
					place[i][1] = j;
				}

			}
		}
		max = place[0][0];// 값 비교위해 x위치,제일큰값 0번째로 초기화
		x = 0;
		for (int i = 0; i < place.length; i++) {

			if (max < place[i][0]) {
				max = place[i][0];
				x = i;
				y = place[i][1];
			}

		}

		if (max < 4) {
			System.out.println(0 + " " + 0);
			return;
		}

		for (int i = 0; i < length; i++) {
			int temp = 0;
			if (place[i][0] < 4) {
				continue;
			}

			for (int j = arr.length - place[i][1] - 1; j > arr.length - place[i][1] - 5; j--) {
				arr[j][i]++;
			}

			temp = test();
			if (MAX < temp) {
				MAX = temp;
			}

			for (int j = arr.length - place[i][1] - 1; j > arr.length - place[i][1] - 5; j--) {
				arr[j][i]--;
			}
		}

		if (MAX == 0) {
			System.out.println(0 + " " + 0);
			return;
		} else {
			System.out.println((x + 1) + " " + MAX);
		}
	}

	public static int test() {

		int horizon = 0;

		// 수평선 메우기 확인
		for (int i = 0; i < arr.length; i++) {
			for (k = 0; k < arr[i].length; k++) {
				if (arr[i][k] == 0) {
					break;
				}
			}
			if (k == C) {
				horizon++;
			}
		}
		return horizon;
	}
}