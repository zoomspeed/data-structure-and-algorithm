import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		String N = sc.next();
		String M = sc.next();
		String arrN[];
		String arrM[];
		String result[];

		int MOK = 0;
		int NMG = 0;
		int SUM = 0;

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

		for (int i = arrM.length - 1; i >= 0; i--) {

			int a = Integer.valueOf(arrN[i]);
			int b = Integer.valueOf(arrM[i]);

			SUM = MOK + a + b;
			NMG = (MOK + a + b) % 10;
			MOK = (MOK + a + b) / 10;

			result[i] = String.valueOf(NMG);
		}

		if (0 != Integer.valueOf(result[0])) {
			System.out.print(result[0]);
		}

		for (int i = 1; i < arrM.length; i++) {

			System.out.print(result[i]);
		}

	}
}