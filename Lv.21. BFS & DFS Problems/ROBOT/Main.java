import java.util.*;
import java.util.Scanner;

public class Main {
	static int N = 0;
	static int M = 0;
	static final int MAX = 120;
	static int map[][] = new int[MAX][MAX];
	static int start[] = new int[3];
	static int end[] = new int[3];
	static final int EAST = 1;
	static final int WEST = 2;
	static final int SOUTH = 3;
	static final int NORTH = 4;
	static Queue<robots> Q = new LinkedList<robots>();
	static int di[][] = { { 0 }, { 2, 3, 4 }, { 1, 3, 4 }, { 1, 2, 4 }, { 1, 2, 3 } };
	static int dx[] = { 0, 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 0, 1, -1 };
	static int go[] = { 0, 1, 2, 3 };
	static int answer = Integer.MAX_VALUE;

	static boolean visited[][][] = new boolean[MAX][MAX][MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			for (int j = 0; j < MAX; j++) {

				map[i][j] = -1;
			}
		}

		for (int i = 1; i <= N; i++) {

			for (int j = 1; j <= M; j++) {

				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 3; i++) {

			start[i] = sc.nextInt();

		}

		for (int i = 0; i < 3; i++) {

			end[i] = sc.nextInt();
		}

		Q.add(new robots(start[0], start[1], start[2], 0));
		visited[start[0]][start[1]][start[2]] = true;

		bfs();

		System.out.println(answer);
	}

	public static void bfs() {

		while (Q.peek() != null) {

			robots r = Q.poll();

			int y = r.y;
			int x = r.x;
			int cnt = r.cnt;
			int direction = r.di;

			if (y == end[0] && x == end[1]) {
				if (direction != end[2]) {

					int resultdi = getTurn(direction, end[2]);
					cnt = cnt + resultdi;
				}
				if (answer > cnt) {

					answer = cnt;
				}
			}

			int nextY = y;
			int nextX = x;

			for (int j = 0; j < 3; j++) {

				nextY = nextY + dy[direction];
				nextX = nextX + dx[direction];

				if (map[nextY][nextX] == -1) {

					break;
				}

				if (map[nextY][nextX] == 1) {

					break;
				}

				if (!visited[nextY][nextX][direction]) {

					visited[nextY][nextX][direction] = true;
					Q.add(new robots(nextY, nextX, direction, (cnt + 1)));
				}

			}
			goTurn(y, x, direction, cnt);
		}
	}

	public static void goTurn(int y, int x, int direction, int cnt) {

		for (int i = 0; i < 3; i++) {

			int nextY = y;
			int nextX = x;

			int nextdi = di[direction][i];

			nextY = nextY + dy[nextdi];
			nextX = nextX + dx[nextdi];

			if (map[nextY][nextX] == -1) {

				continue;
			}

			if (map[nextY][nextX] == 1) {

				continue;
			}

			if (!visited[y][x][nextdi]) {

				visited[y][x][nextdi] = true;
				int cost = cnt + getTurn(direction, nextdi);
				Q.add(new robots(y, x, nextdi, (cost)));
			}
		}
	}

	public static int getTurn(int direction, int target) {

		int tempdi = direction;
		int left = 0;
		int right = 0;

		while (tempdi != target) {
			tempdi = turnLeft(tempdi);
			left++;
		}

		tempdi = direction;

		while (tempdi != target) {
			tempdi = turnRight(tempdi);
			right++;
		}

		if (left > right) {

			return right;
		} else {
			return left;
		}
	}

	public static int turnLeft(int direction) {

		if (direction == WEST) {

			return SOUTH;
		}
		if (direction == EAST) {

			return NORTH;
		}

		if (direction == NORTH) {

			return WEST;
		}

		if (direction == SOUTH) {

			return EAST;
		}

		return -1;
	}

	public static int turnRight(int direction) {

		if (direction == WEST) {

			return NORTH;
		}
		if (direction == EAST) {

			return SOUTH;
		}

		if (direction == NORTH) {

			return EAST;
		}

		if (direction == SOUTH) {

			return WEST;
		}

		return -1;
	}

}

class robots {

	int y;
	int x;
	int cnt;
	int di;

	public robots(int y, int x, int di, int cnt) {

		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.di = di;

	}
}