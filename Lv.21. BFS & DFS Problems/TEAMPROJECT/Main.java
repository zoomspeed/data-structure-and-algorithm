import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N = 0;
	static final int MAX = 100500;
	static boolean visited[] = new boolean[MAX];
	static int count = 0;
	static Node list[] = new Node[MAX];
	static boolean cycle = false;
	static int answer = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 1; i <= N; i++) {

			int data = sc.nextInt();
			list[i] = new Node();
			list[i].nextNode = data;
		}

		for (int i = 1; i <= N; i++) {

			reset();
			list[i].cycleInfo = 1;
			if (!list[i].used)
				dfs(i, 1);

		}
		answer = N - count;

		System.out.println(answer);

	}

	public static void dfs(int nodeNum, int cnt) {

		list[nodeNum].used = true;
		visited[nodeNum] = true;
		int nextNode = list[nodeNum].nextNode;
		boolean used = list[nextNode].used;

		if (!used) {

			visited[nextNode] = true;

			if (list[nextNode].cycleInfo == 0) {
				list[nextNode].cycleInfo = cnt + 1;
			}

			dfs(nextNode, cnt + 1);

		}

		if (used && visited[nextNode]) {
			count = count + ((cnt + 1) - list[nextNode].cycleInfo);
			return;
		}
	}

	public static void reset() {

		for (int i = 0; i < MAX; i++) {

			visited[i] = false;
		}
	}
}

class Node {

	public int nextNode = -1;
	public int cycleInfo = 0;
	public boolean used = false;

	public Node() {

	}

	public Node(int data) {

		this.nextNode = data;
	}
}
