import java.util.*;
import java.util.Scanner;

public class Main {
	static int N = 0;
	static int K = 0;
	static int t = 0;
	static final int MAX = 120;
	static int Wx = 0;
	static int Wy = 0;
	static Queue<int[]> Q = new LinkedList<int[]>();
	static Queue<int[]> Q2 = new LinkedList<int[]>();
	static boolean visited[][] = new boolean[MAX][MAX];
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static int map[][] = new int[MAX][MAX];
	static int tempmap[][] = new int[MAX][MAX];
	static int answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			for (int j = 0; j < MAX; j++) {

				map[i][j] = -1;
				tempmap[i][j] = -1;
			}
		}

		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= N; j++) {

				map[i][j] = sc.nextInt();
				tempmap[i][j] = map[i][j];
			}
		}

		Wx = sc.nextInt();
		Wy = sc.nextInt();

		K = sc.nextInt();

		if (N == 1 && Wx == 1 && Wy == 1 && tempmap[Wy][Wx] == 0) {

			System.out.println(-1);
			return;
		}

		if (tempmap[Wy + 1][Wx] != 0 && tempmap[Wy - 1][Wx] != 0 && tempmap[Wy][Wx - 1] != 0
				&& tempmap[Wy][Wx + 1] != 0) {
			System.out.println(-1);

			return;
		}

		tempmap[Wy][Wx] = 3;

		int pre = 0;
		int count = 0;

		while (t < K - 1) {

			t++;
			pre = 0;
			count = 0;
			int zcount = 0;
			for (int i = 1; i <= N; i++) {

				for (int j = 1; j <= N; j++) {

					if (tempmap[i][j] == 3) {

						pre++;
						Q.add(new int[] { i, j, 0 });
					}

					if (tempmap[i][j] == 0) {

						zcount++;
					}
				}
			}

			bfs();

			for (int i = 1; i <= N; i++) {

				for (int j = 1; j <= N; j++) {

					if (tempmap[i][j] == 3) {

						count++;
					}
				}
			}

			if (count == pre) {
				System.out.println(-1);

				return;
			}

			if (zcount == 0) {
				System.out.println(-1);
				return;
			}
		}

		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= N; j++) {

				if (tempmap[i][j] == 3) {

					if (!visited[i][j]) {
						visited[i][j] = true;
						Q2.add(new int[] { i, j });
						bfs2();
					}
				}
			}
		}

		if (answer == 0) {

			System.out.println(-1);
			return;
		}

		System.out.println(answer);

	}

	public static void bfs() {

		while (Q.peek() != null) {

			int data[] = Q.poll();
			int y = data[0];
			int x = data[1];
			int length = data[2];

			int nextY = 0;
			int nextX = 0;
			for (int i = 0; i < 4; i++) {

				nextY = y + dy[i];
				nextX = x + dx[i];

				if (tempmap[nextY][nextX] == -1) {

					continue;
				}

				if (tempmap[nextY][nextX] == 1) {

					continue;
				}

				if (tempmap[nextY][nextX] == 3) {

					continue;
				}

				if (length >= 1) {

					continue;
				}

				tempmap[nextY][nextX] = 3;

				Q.add(new int[] { nextY, nextX, length + 1 });

			}
		}
	}

	public static void bfs2() {

		while (Q2.peek() != null) {

			int data[] = Q2.poll();
			int y = data[0];
			int x = data[1];

			int nextY = 0;
			int nextX = 0;
			for (int i = 0; i < 4; i++) {

				nextY = y + dy[i];
				nextX = x + dx[i];

				if (tempmap[nextY][nextX] == -1) {

					continue;
				}

				if (tempmap[nextY][nextX] == 1) {

					continue;
				}

				if (visited[nextY][nextX]) {

					continue;
				}
				visited[nextY][nextX] = true;

				if (tempmap[nextY][nextX] == 0) {

					tempmap[nextY][nextX] = 7;
					answer++;
					continue;
				}

				Q2.add(new int[] { nextY, nextX });

			}
		}
	}
}