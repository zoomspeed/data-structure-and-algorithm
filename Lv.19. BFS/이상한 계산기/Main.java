import java.util.*;

public class Main {

	static final int MAX = 900050;
	static int N;
	static int MUL = 2;
	static int DIV = 3;

	static boolean visited[] = new boolean[MAX];
	static int answer = Integer.MAX_VALUE;
	static Queue<int[]> Q = new LinkedList<int[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		Q.add(new int[] { 1, 0 });
		visited[1] = true;
		bfs();

		System.out.println(answer);

	}

	public static void bfs() {

		while (!Q.isEmpty()) {
			int data[] = Q.poll();

			int val = data[0];
			int length = data[1];

			if (val > 99999) {

				continue;
			}

			if (val == N) {

				if (length < answer) {

					answer = length;
				}
			}

			if (!visited[val * MUL]) {

				visited[val * MUL] = true;
				Q.add(new int[] { val * MUL, length + 1 });
			}

			if (!visited[val / DIV]) {

				visited[val / DIV] = true;
				Q.add(new int[] { val / DIV, length + 1 });
			}
		}

	}

}