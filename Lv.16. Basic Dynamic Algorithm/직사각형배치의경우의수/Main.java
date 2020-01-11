import java.util.Scanner;

public class Main {
	static int N;
	static final int MAX = 150;
	static int arr[] = new int[MAX];

	public static void main(String[] args) {

		// Please Enter Your Code Herew
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		arr[1] = 1;
		arr[2] = 2;

		for (int i = 3; i <= N; i++) {
			arr[i] = arr[i - 1] % 1000007 + arr[i - 2] % 1000007;
		}

		System.out.println(arr[N] % 1000007);

	}
}