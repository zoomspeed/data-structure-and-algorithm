import java.util.Scanner;

public class Main {
	static int length = 0;
	static int k = 0;
	static int j = 0;
	static boolean isChanged = false;
	static int q = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = 1;
		String arr[] = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}

		for (int i = 0; i < N; i++) {

			int index = i;
			isChanged = false;

			for (j = i; j < N; j++) {

				if (arr[index].compareTo(arr[j]) > 0) {
					index = j;
				}
			}

			String temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;

		}

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}