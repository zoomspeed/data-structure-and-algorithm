import java.util.Scanner;

public class Main {
	static int N = 0;
	static String line[];
	static String arr[];
	static int answer = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		line = new String[3];
		arr = new String[N];

		line[0] = "+";
		line[1] = "-";
		line[2] = ".";

		arr[0] = "+";
		// System.out.println(line[0]);
		cow(1, "+", 0, 0);
		// cow(1,"-", 1);
		// cow(2,".", 1);

		System.out.println(answer);
	}

	public static void cow(int index, String c, int sum, int temp) {// 1,2,3,4,5,6,7

		int isMinus = 1;
		arr[index - 1] = c;

		if (c.equals("+")) {
			sum = sum + index;
			temp = index;
		} else if (c.equals("-")) {
			sum = sum - index;
			temp = index;
		} else if (c.equals(".")) {

			// .일때

			String s = characterCheck(index - 1);
			// System.out.println(s);
			// System.out.println(s);
			if (!s.equals("n")) {

				if (s.equals("+")) {
					isMinus = 1;
				} else if (s.equals("-")) {

					isMinus = -1;
				}

			}

			sum = sum + (temp) * isMinus * -1;

			// int length = String.valueOf(index-1).length();//숫자길이 구함.1 or 2
			int length = String.valueOf(index).length();// 숫자길이 구함.1 or 2

			for (int i = 0; i < length; i++) {
				temp = temp * 10;

			}
			temp = temp + index;
			sum = sum + temp * isMinus;
			// return;
		}

		// sum 로직은 위에
		if (index == N) {
			////////////////////////// 마지막이 .일때
			if (sum == 0) {
				printAll();
				answer++;
				return;
			} else {
				return;
			}
		}

		for (int i = 0; i < 3; i++) {
			cow(index + 1, line[i], sum, temp);
		}
		return;// 종료
	}

	public static void printAll() {

		if (!(answer >= 20)) {
			for (int i = 1; i < N; i++) {

				System.out.print(i + " " + arr[i] + " ");

			}
			System.out.println(N);
		}
	}

	public static String characterCheck(int index) {

		String c = "";
		// 2가 초기값이므로 1개 적은거 인덱스부터 비교하기

		for (int i = index; i >= 0; i--) {
			if (!arr[i].equals(".")) {
				c = arr[i];
				return c;

			}
		}

		return "n";
	}
}
