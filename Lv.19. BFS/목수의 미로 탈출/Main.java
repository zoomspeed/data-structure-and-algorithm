import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int MAX = 1050;
	static int N = 0;
	static int M = 0;
	static int map[][] = new int[MAX][MAX];
	static int tempmap[][] = new int[MAX][MAX];
	static int arr[][] = new int[MAX][MAX];
	static boolean visitedA[][] = new boolean[MAX][MAX];
	static boolean visitedB[][] = new boolean[MAX][MAX];
	static Queue<int[]> Q1 = new LinkedList<int[]>();
	static Queue<int[]> Q2 = new LinkedList<int[]>();
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int AMIN = 0;
	static int BMIN = 0;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			for (int j = 0; j < MAX; j++) {

				arr[i][j] = -1;
			}
		}

		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= M; j++) {

				arr[i][j] = sc.nextInt();
			}
		}

		Q1.add(new int[] { N, 1, 0 });
		visitedA[N][1] = true;
		Abfs();

		Q2.add(new int[] { 1, M, 0 });

		visitedB[1][M] = true;
		Bbfs();

		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= M; j++) {

				AMIN = Integer.MAX_VALUE;
				BMIN = Integer.MAX_VALUE;

				AMIN = map[i][j];

				if (map[i][j] == 0) {
					continue;
				}

				for (int k = 0; k < 4; k++) {

					int nextY = 0;
					int nextX = 0;

					nextY = i;
					nextX = j;

					for (int t = 0; t < 2; t++) {

						nextY = nextY + dy[k];
						nextX = nextX + dx[k];

						if (nextY <= 0 || nextY > N || nextX <= 0 || nextX > M) {
							continue;
						}

						if (tempmap[nextY][nextX] != 0) {

							BMIN = tempmap[nextY][nextX];

							if (BMIN + map[i][j] < answer) {
								answer = BMIN + map[i][j];
							}
							break;
						}
					}
				}
			}
		}

		System.out.println(answer + 2);
	}

	public static void Abfs() {

		while (Q1.peek() != null) {

			int data[] = Q1.poll();
			int y = data[0];
			int x = data[1];
			int length = data[2];

			map[y][x] = length;

			for (int i = 0; i < 4; i++) {

				int nextY = y + dy[i];
				int nextX = x + dx[i];

				if (nextY <= 0 || nextY > N || nextX <= 0 || nextX > M) {
					continue;
				}

				if (arr[nextY][nextX] == -1) {
					continue;
				}

				if (visitedA[nextY][nextX]) {
					continue;
				} else {
					visitedA[nextY][nextX] = true;
				}

				if (arr[nextY][nextX] == 1) {
					continue;
				}

				Q1.add(new int[] { nextY, nextX, length + 1 });
			}
		}
	}

	public static void Bbfs() {

		while (Q2.peek() != null) {

			int data[] = Q2.poll();
			int y = data[0];
			int x = data[1];
			int length = data[2];

			tempmap[y][x] = length;

			for (int i = 0; i < 4; i++) {

				int nextY = y + dy[i];
				int nextX = x + dx[i];

				if (nextY <= 0 || nextY > N || nextX <= 0 || nextX > M) {
					continue;
				}

				if (arr[nextY][nextX] == -1) {
					continue;
				}

				if (visitedB[nextY][nextX]) {
					continue;
				} else {
					visitedB[nextY][nextX] = true;
				}

				if (arr[nextY][nextX] == 1) {
					continue;
				}

				Q2.add(new int[] { nextY, nextX, length + 1 });
			}
		}
	}
}
