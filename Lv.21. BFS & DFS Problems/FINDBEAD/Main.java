import java.util.*;
import java.util.Scanner;

public class Main {
	static int N = 0;
	static int M = 0;
	static final int MAX = 120;
	static ArrayList<node> list[] = new ArrayList[MAX];
	static ArrayList<node> reverselist[] = new ArrayList[MAX];
	static boolean visited1[] = new boolean[MAX];
	static boolean visited2[] = new boolean[MAX];
	static boolean reversevisited[] = new boolean[MAX];
	static int answer1[] = new int[MAX];
	static int answer2[] = new int[MAX];
	static int answer = 0;
	static int temp = 0;
	static Queue<int[]> Q = new LinkedList<int[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			list[i] = new ArrayList<node>();
			reverselist[i] = new ArrayList<node>();
		}

		for (int i = 1; i <= M; i++) {

			int y = sc.nextInt();
			int x = sc.nextInt();

			node A = new node(y);
			node B = new node(x);

			list[x].add(A);
			reverselist[y].add(B);
		}

		if (N == 1) {

			System.out.println(0);
			return;
		}

		for (int i = 1; i <= N; i++) {
			temp = i;
			getParent(answer1, reverselist, list, visited1, i);
		}

		for (int i = 1; i <= N; i++) {

			temp = i;
			getParent(answer2, list, reverselist, visited2, i);
		}

		for (int i = 1; i <= N; i++) {

			if (answer1[i] > N / 2) {
				answer++;
			}
			if (answer2[i] > N / 2) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	public static void bfs(boolean visited[], int answer[], ArrayList<node> list[]) {

		while (Q.peek() != null) {

			int data[] = Q.poll();
			int node1 = data[0];
			int cost = data[1];

			answer[node1] = answer[node1] + cost;

			if (!visited[node1]) {

				visited[node1] = true;
				cost++;
			}

			for (int i = 0; i < list[node1].size(); i++) {

				int node2 = list[node1].get(i).num;

				Q.add(new int[] { node2, cost });

			}
		}

	}

	public static void getParent(int[] answer, ArrayList<node> list[], ArrayList<node> list2[], boolean visited[],
			int Node) {

		if (list[Node].size() != 0) {

			for (int i = 0; i < list[Node].size(); i++) {

				int node2 = list[Node].get(i).num;
				getParent(answer, list, list2, visited, node2);
			}
		} else {

			if (!visited[Node]) {
				Q.add(new int[] { Node, 0 });
				bfs(visited, answer, list2);

			}
		}
	}

	public static void reset() {

		for (int i = 0; i < N; i++) {

			visited1[i] = false;
			visited2[i] = false;
		}
	}

	public static void dfs(int[] answer, int node, ArrayList<node> list[], boolean visited[], int cnt) {

		answer[node] = answer[node] + cnt;

		for (int i = 0; i < list[node].size(); i++) {

			int node2 = list[node].get(i).num;

			dfs(answer, node2, list, visited, cnt + 1);
		}
	}
}

class node {

	static final int MAX = 120;
	public int num = 0;
	public int cnt = 0;

	public node() {

	}

	public node(int num) {

		this.num = num;
	}
}
