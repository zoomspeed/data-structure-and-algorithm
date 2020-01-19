import java.util.Scanner;

public class Main {

	static int N = 0;
	static final int MAX = 1050;
	static boolean humanTurn = true;
	static int human = 0;
	static int computer = 0;
	static int arr[] = new int[MAX];

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {

			if (humanTurn) {
				humanTurn = false;
				human += arr[i];
			} else {
				humanTurn = true;
				computer += arr[i];
			}
		}

		System.out.println(computer + " " + human);
	}
}
