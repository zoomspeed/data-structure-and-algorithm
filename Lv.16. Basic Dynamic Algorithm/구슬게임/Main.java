import java.util.Scanner;

public class Main {
	static int arr[] = new int[10];
	static int N;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		if (N % 4 == 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}
}