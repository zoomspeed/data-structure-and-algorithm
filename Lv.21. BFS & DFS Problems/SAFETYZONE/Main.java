import java.util.*;

public class Main {

	static int N = 0;
	static int M = 0;
	static int K = 0;
	static final int MAX = 150;
	static int map[][] = new int[MAX][MAX];
	static boolean visited[][] = new boolean[MAX][MAX];
	static boolean visited2[][] = new boolean[MAX][MAX];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int tempmap[][] = new int[MAX][MAX];
	static Queue<int[]> queue = new LinkedList<int[]>();
	static Queue<int[]> queue2 = new LinkedList<int[]>();
	static int answer = 0;
	static int maxheight = 0;
	static int height = 0;
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int col = 0; col < N; col++) {

			for (int row = 0; row < N; row++) {

				map[col][row] = sc.nextInt();

				if (map[col][row] > maxheight) {

					maxheight = map[col][row];
				}
			}

		}

		for (height = 0; height <= maxheight; height++) {

			copymap();
			vreset();
			count = 0;

			for (int col = 0; col < N; col++) {

				for (int row = 0; row < N; row++) {

					if (!visited[col][row] && tempmap[col][row] <= height) {

						visited[col][row] = true;

						queue.add(new int[] { col, row });
						bfs();
					}
				}

			}

			for (int col = 0; col < N; col++) {

				for (int row = 0; row < N; row++) {

					if (!visited2[col][row] && tempmap[col][row] != -1) {
						// System.out.println("!!! ");
						visited2[col][row] = true;

						queue2.add(new int[] { col, row });
						bfs2();

						count++;
					}
				}

			}

			if (answer < count) {

				answer = count;
			}
		}

		System.out.println(answer);

	}

	public static void copymap() {

		for (int col = 0; col < MAX; col++) {

			for (int row = 0; row < MAX; row++) {

				tempmap[col][row] = map[col][row];
			}
		}
	}

	public static void vreset() {

		for (int col = 0; col < MAX; col++) {

			for (int row = 0; row < MAX; row++) {

				visited[col][row] = false;
			}
		}

		for (int col = 0; col < MAX; col++) {

			for (int row = 0; row < MAX; row++) {

				visited2[col][row] = false;
			}
		}
	}

	public static void bfs2() {

		while (queue2.peek() != null) {

			int data[] = queue2.poll();

			int col = data[0];
			int row = data[1];

			for (int i = 0; i < 4; i++) {

				int y = col + dy[i];
				int x = row + dx[i];

				if (y < 0 || y >= N || x < 0 || x >= N) {
					continue;
				}
				if (visited2[y][x]) {
					continue;
				}

				if (tempmap[y][x] == -1) {
					continue;
				}
				visited2[y][x] = true;
				queue2.add(new int[] { y, x });
			}

		}
	}

	public static void bfs() {

		while (queue.peek() != null) {

			int data[] = queue.poll();

			int col = data[0];
			int row = data[1];

			tempmap[col][row] = -1;

			for (int i = 0; i < 4; i++) {

				int x = row + dx[i];
				int y = col + dy[i];

				if (y < 0 || y >= N || x < 0 || x >= N) {
					continue;
				}
				if (visited[y][x]) {
					continue;
				}

				if (tempmap[y][x] == -1) {
					continue;
				}

				if (tempmap[y][x] > height) {
					continue;
				}

				visited[y][x] = true;

				queue.add(new int[] { y, x });
			}
		}
	}
}