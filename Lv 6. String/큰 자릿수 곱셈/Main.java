import java.util.Scanner;

public class Main {
	static int val = 0;
	static int count = 0;
	static int index = 0;
	static int add = 0;
	static int sum = 0;
	static String N;
	static String M;
	static int i = 0;
	static int j = 0;
	static String arrN[];
	static String arrM[];
	static int calculate[][];
	static int result[];

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.next();
		M = sc.next();

		arrN = new String[N.length()];
		arrM = new String[M.length()];

		calculate = new int[M.length()][N.length() + M.length()];

		for (i = 0; i < arrN.length; i++) {

			arrN[arrN.length - 1 - i] = N.charAt(arrN.length - 1 - i) + "";
		}

		for (i = 0; i < arrM.length; i++) {

			arrM[arrM.length - 1 - i] = M.charAt(arrM.length - 1 - i) + "";
		}

		for (i = arrM.length - 1; i >= 0; i--) {

			add = 0;
			index = 0;

			for (j = arrN.length - 1; j >= 0; j--) {

				int a = Integer.valueOf(arrN[j]);
				int b = Integer.valueOf(arrM[i]);

				val = (add + (a * b)) % 10;
				add = (add + (a * b)) / 10;

				calculate[arrM.length - 1 - i][calculate[0].length - 1 - index - count] = val;
				index++;
			}
			calculate[arrM.length - 1 - i][calculate[0].length - 1 - index - count] = add;
			count++;
		}

		add = 0;
		result = new int[calculate[0].length + 1];

		for (i = 0; i < calculate[0].length; i++) {
			sum = 0;

			for (j = 0; j < calculate.length; j++) {
				sum = sum + calculate[j][calculate[0].length - 1 - i];
			}

			val = (add + sum) % 10;
			add = (add + sum) / 10;
			result[result.length - 1 - i] = val;
		}

		result[0] = add;

		count = 0;
		for (i = 0; i < result.length; i++) {

			if (result[i] != 0) {
				count++;
			}

			if (count == 0) {
				continue;
			}
			System.out.print(result[i]);
		}

	}
}