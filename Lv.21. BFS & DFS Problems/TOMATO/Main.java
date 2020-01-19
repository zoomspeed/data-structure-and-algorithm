import java.util.*;

public class Main {

	static int N = 0;
	static int M = 0;
	static int H = 0;
	static final int MAX = 150;
	static int map[][][] = new int[MAX][MAX][MAX];
	static int tempmap[][][] = new int[MAX][MAX][MAX];
	static boolean zero = true;
	static boolean visited[][][] = new boolean[MAX][MAX][MAX];
	static int dh[] = { 0, 0, 0, 0, -1, 1 };
	static int dx[] = { 0, 0, -1, 1, 0, 0 };
	static int dy[] = { -1, 1, 0, 0, 0, 0 };
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		for (int height = 0; height < H; height++) {

			for (int col = 0; col < N; col++) {

				for (int row = 0; row < M; row++) {

					int data = sc.nextInt();

					map[height][col][row] = data;
					tempmap[height][col][row] = data;
				}
			}
		}

		for (int height = 0; height < H; height++) {

			for (int col = 0; col < N; col++) {

				for (int row = 0; row < M; row++) {

					if (map[height][col][row] == 0) {

						zero = false;
					}
				}

			}
		}

		if (zero) {

			System.out.println(0);
			return;
		}

		for (int height = 0; height < H; height++) {

			for (int col = 0; col < N; col++) {

				for (int row = 0; row < M; row++) {

					if (map[height][col][row] == 1) {
						queue.add(new int[] { height, col, row, 0 });
					}
				}

			}
		}

		bfs();

		for (int height = 0; height < H; height++) {

			for (int col = 0; col < N; col++) {

				for (int row = 0; row < M; row++) {

					if (tempmap[height][col][row] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(answer);
	}

	public static void bfs() {

		while (queue.peek() != null) {

			int data[] = queue.poll();

			int height = data[0];
			int col = data[1];
			int row = data[2];
			int distance = data[3];

			tempmap[height][col][row] = 1;

			if (distance > answer) {
				answer = distance;
			}

			for (int i = 0; i < 6; i++) {

				int x = row + dx[i];
				int y = col + dy[i];
				int z = height + dh[i];

				if (z < 0 || z >= H || y < 0 || y >= N || x < 0 || x >= M) {
					continue;
				}
				if (map[z][y][x] == -1) {
					continue;
				}

				if (visited[z][y][x]) {
					continue;
				}

				visited[z][y][x] = true;

				queue.add(new int[] { z, y, x, distance + 1 });
			}
		}
	}
}
