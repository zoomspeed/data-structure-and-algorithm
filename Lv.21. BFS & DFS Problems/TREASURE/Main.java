import java.util.*;

public class Main {

	static int N = 0;
	static int M = 0;
	static final int MAX = 70;
	static int map[][] = new int[MAX][MAX];
	static boolean visited[][] = new boolean[MAX][MAX];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int col = 0; col < N; col++) {
			String st = sc.next();
			for (int row = 0; row < M; row++) {

				int data = 0;
				if (st.charAt(row) == 'W') {
					data = 1;
				} else if (st.charAt(row) == 'L') {
					data = 0;
				}

				map[col][row] = data;

			}
		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < M; j++) {

				vreset();

				for (int col = i; col < N; col++) {
					for (int row = j; row < M; row++) {

						if (map[col][row] == 0 && !visited[col][row]) {
							visited[col][row] = true;
							queue.add(new int[] { col, row, 0 });
							bfs();
						}
					}
				}
			}
		}

		System.out.println(answer);
	}

	public static void vreset() {

		for (int col = 0; col < MAX; col++) {

			for (int row = 0; row < MAX; row++) {

				visited[col][row] = false;
			}
		}
	}

	public static void bfs() {

		while (queue.peek() != null) {

			int data[] = queue.poll();

			int col = data[0];
			int row = data[1];
			int distance = data[2];

			if (distance > answer) {
				answer = distance;
			}

			for (int i = 0; i < 4; i++) {

				int x = row + dx[i];
				int y = col + dy[i];

				if (y < 0 || y >= N || x < 0 || x >= M) {
					continue;
				}
				if (visited[y][x]) {
					continue;
				}

				if (map[y][x] == 1) {
					continue;
				}

				visited[y][x] = true;

				queue.add(new int[] { y, x, distance + 1 });
			}
		}
	}
}
