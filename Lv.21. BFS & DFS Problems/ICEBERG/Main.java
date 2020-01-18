import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N = 0;
	static final int MAX = 330;
	static int M = 0;
	static int map[][] = new int[MAX][MAX];
	static Queue<int[]> Q = new LinkedList<int[]>();
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static int tempmap[][] = new int[MAX][MAX];
	static int objectCount = 0;
	static int time = 0;
	static boolean zero = true;
	static boolean visited[][] = new boolean[MAX][MAX];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int col = 0; col < N; col++) {

			st = new StringTokenizer(br.readLine());
			for (int row = 0; row < M; row++) {

				map[col][row] = Integer.parseInt(st.nextToken());
				tempmap[col][row] = map[col][row];
			}
		}
		// 0초일때도 검사하기

		for (int col = 0; col < N; col++) {

			for (int row = 0; row < M; row++) {

				if (tempmap[col][row] != 0 && !visited[col][row]) {

					visited[col][row] = true;
					Q.add(new int[] { col, row });
					bfs();
					objectCount++;
					zero = false;
				}
			}
		}

		if (zero) {

			System.out.println(0);
			return;
		}
		if (objectCount > 2) {

			System.out.println(0);
			return;
		}

		boolean allZero = false;
		// 1초부터 검사시작
		while (objectCount < 2) {
			objectCount = 0;
			time++;
			copymap();
			vreset();

			allZero = true;
			for (int col = 0; col < N; col++) {

				for (int row = 0; row < M; row++) {

					if (map[col][row] != 0) {
						checkIce(col, row);
						allZero = false;
					}

				}
			}

			if (allZero) {
				System.out.println(0);
				return;
			}

			for (int col = 0; col < N; col++) {

				for (int row = 0; row < M; row++) {

					if (tempmap[col][row] != 0 && !visited[col][row]) {

						visited[col][row] = true;
						Q.add(new int[] { col, row });
						bfs();
						objectCount++;
					}

				}
			}

			copytempmap();
			if (objectCount > 2) {
				break;
			}
		}
		System.out.println(time);
	}

	public static void print() {

		for (int col = 0; col < N; col++) {

			for (int row = 0; row < M; row++) {

				System.out.print(tempmap[col][row] + " ");
			}

			System.out.println();
		}
	}

	public static void checkIce(int y, int x) {

		int nextY = y;
		int nextX = x;

		for (int i = 0; i < 4; i++) {

			nextY = y + dy[i];
			nextX = x + dx[i];

			if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {

				continue;
			}

			if (map[nextY][nextX] == 0) {

				if (tempmap[y][x] > 0) {
					tempmap[y][x]--;
				}
			}
		}
	}

	public static void copytempmap() {

		for (int col = 0; col < N; col++) {

			for (int row = 0; row < M; row++) {

				map[col][row] = tempmap[col][row];
			}
		}
	}

	public static void copymap() {

		for (int col = 0; col < N; col++) {

			for (int row = 0; row < M; row++) {

				tempmap[col][row] = map[col][row];

			}
		}
	}

	public static void vreset() {

		for (int col = 0; col < N; col++) {

			for (int row = 0; row < M; row++) {

				visited[col][row] = false;
			}
		}
	}

	public static void bfs() {

		while (Q.peek() != null) {

			int data[] = Q.poll();
			int y = data[0];
			int x = data[1];

			for (int i = 0; i < 4; i++) {

				int nextY = y + dy[i];
				int nextX = x + dx[i];

				if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
					continue;
				}

				if (tempmap[nextY][nextX] == 0) {
					continue;
				}

				if (visited[nextY][nextX]) {

					continue;
				}

				visited[nextY][nextX] = true;

				Q.add(new int[] { nextY, nextX });
			}
		}
	}

}