import java.util.*;

public class Main {

	static final int MAX = 1000050;
	static int N;
	static int M;
	static int MUL = 2;
	static int DIV = 3;

	static boolean visited[] = new boolean[MAX];
	static int answer = 0;
	static Queue<Integer> Q = new LinkedList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		Q.add(M);
		visited[M] = true;
		bfs();

		for (int i = 1; i <= N; i++) {

			if (!visited[i]) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static void bfs() {

		while (!Q.isEmpty()) {

			int val = Q.poll();

			if (val > N) {

				continue;
			}

			if (!visited[val * MUL]) {

				visited[val * MUL] = true;
				Q.add(val * MUL);
			}

			if (!visited[val / DIV]) {

				visited[val / DIV] = true;
				Q.add(val / DIV);
			}
		}
	}
}