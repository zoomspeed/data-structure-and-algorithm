import java.util.*;

public class Main {
	static final int range = 1050;
	static String s1 = "";
	static String s2 = "";
	static int arr[][] = new int[range][range];

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		s1 = sc.next();
		s2 = sc.next();

		// arr[0][0] = 0;
		// 초기화값 처음부터 0으로 되어있음.

		for (int i = 0; i < s1.length(); i++) {

			arr[i + 1][0] = i + 1;
		}

		for (int i = 0; i < s2.length(); i++) {

			arr[0][i + 1] = i + 1;
		}

		for (int i = 0; i < s1.length(); i++) {

			for (int j = 0; j < s2.length(); j++) {

				if (s1.charAt(i) == s2.charAt(j)) {

					arr[i + 1][j + 1] = arr[i][j];
				} else {
					arr[i + 1][j + 1] = Math.min(arr[i][j + 1], arr[i + 1][j]) + 1;
				}
			}

		}

		System.out.println(arr[s1.length()][s2.length()]);

	}
}