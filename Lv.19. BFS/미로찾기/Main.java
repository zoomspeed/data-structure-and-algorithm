import java.util.*;

public class Main {

	static final int MAX = 1050;
	static int N;
	static int M;
	static int x;
	static int y;

	static boolean visited[][] = new boolean[MAX][MAX];
	static int answer = Integer.MAX_VALUE;
	static Queue<int[]> Q = new LinkedList<int[]>();
	static int arr[][] = new int[MAX][MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				arr[i][j] = sc.nextInt();
			}
		}

		Q.add(new int[] { N - 1, 0, 0 });
		visited[N - 1][0] = true;
		bfs();

		System.out.println(answer);

	}

	public static void bfs() {

		while (!Q.isEmpty()) {

			int position[] = Q.poll();

			int y = position[0];
			int x = position[1];
			int length = position[2];

			if (arr[y][x] == 1) {
				continue;
			}

			if (y < 0 || y >= N || x < 0 || x >= M) {

				continue;
			}

			if (x == M - 1 && y == 0) {

				if (length < answer) {
					answer = length;
				}

				continue;
			}

			if (y != 0) {

				if (!visited[y - 1][x]) {

					visited[y - 1][x] = true;
					Q.add(new int[] { y - 1, x, length + 1 });
				}

			}

			if (y != N - 1) {

				if (!visited[y + 1][x]) {

					visited[y + 1][x] = true;
					Q.add(new int[] { y + 1, x, length + 1 });
				}
			}

			if (x != 0) {

				if (!visited[y][x - 1]) {

					visited[y][x - 1] = true;
					Q.add(new int[] { y, x - 1, length + 1 });
				}

			}

			if (x != M - 1) {

				if (!visited[y][x + 1]) {

					visited[y][x + 1] = true;
					Q.add(new int[] { y, x + 1, length + 1 });
				}
			}
		}
	}
}