import java.util.Scanner;

public class Main {
	static int sum = 0;
	static int k = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		String N = sc.next();
		String M = sc.next();
		String arrN[];
		String arrM[];
		String result[];

		int MOK = 0;
		int MINUS = 0;
		int isMinus = 1;

		if (N.length() >= M.length()) {

			arrN = new String[N.length() + 1];
			arrM = new String[N.length() + 1];
			result = new String[N.length() + 1];
		} else {

			arrN = new String[M.length() + 1];
			arrM = new String[M.length() + 1];
			result = new String[M.length() + 1];
		}

		for (int i = 0; i < N.length(); i++) {

			arrN[arrN.length - 1 - i] = N.charAt(N.length() - 1 - i) + "";
		}

		for (int i = arrN.length - N.length() - 1; i >= 0; i--) {

			arrN[i] = "0";
		}

		for (int i = 0; i < M.length(); i++) {

			arrM[arrM.length - 1 - i] = M.charAt(M.length() - 1 - i) + "";
		}

		for (int i = arrM.length - M.length() - 1; i >= 0; i--) {

			arrM[i] = "0";
		}

		if (N.length() < M.length()) {
			isMinus = -1;
			result[0] = "-";
		} else if (N.length() > M.length()) {
			isMinus = 1;
			result[0] = "+";
		} else if (N.length() == M.length()) {

			for (k = 0; k < arrN.length; k++) {
				if (Integer.valueOf(arrN[k]) > Integer.valueOf(arrM[k])) {
					isMinus = 1;
					result[0] = "+";
					break;
				}
				if (Integer.valueOf(arrN[k]) < Integer.valueOf(arrM[k])) {
					isMinus = -1;
					result[0] = "-";
					break;
				}
			}
			if (k == arrN.length) {
				System.out.println("0");
				return;

			}

		}

		for (int i = 1; i < arrN.length; i++) {

			int a = Integer.valueOf(arrN[i]);
			int b = Integer.valueOf(arrM[i]);

			if (isMinus == -1) {

				if (a > b) {
					sum = 10 - (a - b);
					for (int j = i; j >= 2; j--) {

						result[j - 1] = String.valueOf(Integer.valueOf(result[j - 1]) - 1);
						if (Integer.valueOf(result[j - 1]) != -1) {
							break;
						} else {

							result[j - 1] = String.valueOf(9);
						}
					}

				} else {
					sum = b - a;
				}
			} else {
				if (a < b) {
					sum = 10 - (b - a);
					for (int j = i; j >= 2; j--) {

						result[j - 1] = String.valueOf(Integer.valueOf(result[j - 1]) - 1);

						if (Integer.valueOf(result[j - 1]) != -1) {
							break;
						} else {

							result[j - 1] = String.valueOf(9);
						}
					}
				} else {
					sum = a - b;
				}
			}
			result[i] = String.valueOf(sum);
		}

		int count = 0;

		if (result[0].equals("-")) {
			System.out.print(result[0]);
		}

		for (int i = 0; i < result.length; i++) {

			if (!result[i].equals("0")) {
				count++;
			}

			if (count >= 2) {
				System.out.print(result[i]);
			}
		}
	}
}