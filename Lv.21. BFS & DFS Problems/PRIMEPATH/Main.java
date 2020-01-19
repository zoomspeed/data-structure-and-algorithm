import java.util.*;
import java.util.Scanner;

public class Main {
	static int N = 0;
	static final int MAX = 150;
	static int ans[][] = new int[MAX][2];
	static int arr[] = new int[MAX];
	static boolean prime[] = new boolean[10050];
	static int current = 0;
	static int target = 0;
	static boolean direction[] = { false, false, false, false };
	static int answer = Integer.MAX_VALUE;
	static boolean check[] = new boolean[10050];
	static Queue<int[]> Q = new LinkedList<int[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			ans[i][0] = sc.nextInt();
			ans[i][1] = sc.nextInt();

		}

		for (int i = 2; i < prime.length; i++) {

			prime[i] = true;

		}
		for (int i = 2; i < Math.sqrt(10050); i++) {
			if (prime[i]) {

				for (int j = i; j < 10050; j = j + 1) {

					if (j * i >= 10050) {
						break;
					}
					prime[j * i] = false;

				}
			}

		}

		for (int i = 0; i < N; i++) {
			answer = Integer.MAX_VALUE;

			Q.add(new int[] { ans[i][0], 0 });
			target = ans[i][1];
			bfs();
			vreset();
			System.out.println(answer);
		}
	}

	public static void vreset() {

		for (int i = 0; i < check.length; i++) {

			check[i] = false;
		}
	}

	public static void bfs() {

		while (Q.peek() != null) {

			int data[] = Q.poll();

			int current = data[0];
			int depth = data[1];

			if (current < 1000 || current > 9999) {
				continue;
			}

			if (current == target) {

				if (depth < answer) {
					answer = depth;
				}
				continue;
			}

			for (int i = 0; i < 4; i++) {

				String s1 = String.valueOf(current);
				String start = "";
				String end = "";

				for (int j = 0; j < 10; j++) {

					start = s1.substring(0, i);
					end = s1.substring(i + 1, 4);
					String output = String.valueOf(start + j + end);
					int next = Integer.valueOf(output);

					if (next < 1000 || next > 9999) {
						continue;
					}

					if (!prime[next] || next == current || check[next]) {

						continue;
					}

					check[next] = true;
					Q.add(new int[] { next, depth + 1 });
				}
			}
		}
	}
}