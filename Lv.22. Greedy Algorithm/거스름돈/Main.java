import java.util.Scanner;

public class Main {

	static int N = 0;
	static int[] money = { 500, 100, 50, 5, 1 };
	static int answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < 5; i++) {

			answer = answer + N / money[i];
			N = N % money[i];
		}

		System.out.println(answer);
	}

}
