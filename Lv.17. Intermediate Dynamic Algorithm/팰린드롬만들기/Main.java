import java.util.*;

public class Main {
	static final int range = 1050;
	static String s = "";
	static int arr[][] = new int[range][range];

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		s = sc.next();

		for (int i = s.length() - 1; i >= 0; i--) {

			for (int j = i; j < s.length(); j++) { // 9 8 7 6 5 4 3 2 1 0

				if (i == j) {

					arr[i][j] = 0;
					continue;
				}

				if (s.charAt(i) == s.charAt(j)) {

					arr[i][j] = arr[i + 1][j - 1];
				} else if (s.charAt(i) != s.charAt(j)) {

					arr[i][j] = Math.min(arr[i][j - 1], arr[i + 1][j]) + 1;
				}
			}
		}

		System.out.println(arr[0][s.length() - 1]);

	}
}