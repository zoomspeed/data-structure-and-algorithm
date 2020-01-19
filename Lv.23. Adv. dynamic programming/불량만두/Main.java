import java.util.*;

public class Main {
	static int N = 0;
	static int NMG = 0;
	static final int MAX = 110;
	static int arr[] = new int[MAX];
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		for (int i = 4; i < MAX; i++) {

			if (i % 3 >= 2) {
				arr[i] = arr[i / 3 + ((i % 3) / 2)] + 1;
			} else {
				arr[i] = arr[i / 3 + i % 3] + 1;
			}
		}
		System.out.println(arr[N]);
	}
}
