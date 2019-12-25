import java.util.Scanner;

public class Main {
	public static int a1 = 0, a2 = 0, a3 = 0;
	public static int answer = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		while (true) {

			a1 = sc.nextInt();
			a2 = sc.nextInt();
			a3 = sc.nextInt();

			if (a1 == 0 && a2 == 0 && a3 == 0) {
				break;
			}

			if (arithmetic()) {

				System.out.println("AP " + answer);
			} else if (geometric()) {

				System.out.println("GP " + answer);
			}

		}

	}

	public static boolean arithmetic() {

		if (a3 - a2 == a2 - a1) {
			answer = a3 + (a2 - a1);
			return true;
		}

		return false;
	}

	public static boolean geometric() {

		if (a3 / a2 == a2 / a1) {
			answer = a3 * (a3 / a2);
			return true;
		}

		return false;
	}
}