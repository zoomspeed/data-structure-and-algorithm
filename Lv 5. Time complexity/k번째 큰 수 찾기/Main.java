import java.util.Scanner;

public class Main {
	public static int N = 0;
	public static int K = 0;
	public static int arr[];
	public static int temp = 0;
	public static int index = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) {
			index = i;
			if (i > K - 1) {
				break;
			}
			for (int j = i; j < arr.length; j++) {

				if (arr[index] < arr[j]) {
					index = j;
				}
			}
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}

		System.out.println(arr[K - 1]);

	}

}