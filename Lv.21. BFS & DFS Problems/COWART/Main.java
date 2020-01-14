import java.util.*;

public class Main {

	static int N = 0;
	static final int MAX = 120;
	static int map[][] = new int[MAX][MAX];
	static Queue<int[]> q1 = new LinkedList<int[]>();
	static Queue<int[]> q2 = new LinkedList<int[]>();
	static boolean visited1[][] = new boolean[MAX][MAX];
	static boolean visited2[][] = new boolean[MAX][MAX];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int humanCnt = 0;
	static int cowCnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		for (int i = 0; i < N; i++) {

			String s = sc.next();

			for (int j = 0; j < s.length(); j++) {

				if (s.charAt(j) == 'R') {
					map[i][j] = 1;
				} else if (s.charAt(j) == 'G') {
					map[i][j] = 2;
				} else if (s.charAt(j) == 'B') {
					map[i][j] = 3;
				}

			}
		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				if (!visited1[i][j]) {
					// System.out.println(map[i][j]);
					q1.add(new int[] { i, j, map[i][j] });

					visited1[i][j] = true;
					humanbfs();
					humanCnt++;
				}

				if (!visited2[i][j]) {

					q2.add(new int[] { i, j, map[i][j] });

					visited2[i][j] = true;
					cowbfs();
					cowCnt++;
				}
			}
		}
		System.out.print(humanCnt + " ");
		System.out.println(cowCnt);
	}

	public static void humanbfs() {

		while (q1.peek() != null) {

			int data[] = q1.poll();

			int y = data[0];
			int x = data[1];
			int value = data[2];

			for (int i = 0; i < 4; i++) {

				int nextY = y + dy[i];
				int nextX = x + dx[i];

				if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {

					continue;
				}

				if (map[nextY][nextX] != value) {
					continue;

				}

				if (visited1[nextY][nextX]) {
					continue;
				}

				visited1[nextY][nextX] = true;

				q1.add(new int[] { nextY, nextX, map[nextY][nextX] });
			}
		}

	}

	public static void cowbfs() {

		while (q2.peek() != null) {

			int data[] = q2.poll();
			int y = data[0];
			int x = data[1];
			int value = data[2];

			for (int i = 0; i < 4; i++) {

				int nextY = y + dy[i];
				int nextX = x + dx[i];

				if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {

					continue;
				}

				if (map[nextY][nextX] != value && (map[nextY][nextX] == 3 || value == 3)) {
					continue;

				}

				if (visited2[nextY][nextX]) {
					continue;
				}

				visited2[nextY][nextX] = true;
				q2.add(new int[] { nextY, nextX, map[nextY][nextX] });
			}
		}
	}
}
