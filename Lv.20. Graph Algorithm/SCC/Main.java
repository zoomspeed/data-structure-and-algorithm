import java.util.*;

public class Main {
	static int N;
	static int M;
	static final int MAX = 10500;

	static ArrayList<Integer> list[] = new ArrayList[MAX];
	static ArrayList<Integer> reverselist[] = new ArrayList[MAX];
	static boolean visited[] = new boolean[MAX];
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int start = 1;
	static int answer = Integer.MAX_VALUE;
	static int result = 0;
	static int time[] = new int[MAX];
	static int order[] = new int[MAX];
	static int clock = 1;
	static int order_len = 0;
	static boolean check[] = new boolean[MAX];
	static boolean check2[] = new boolean[MAX];
	static int group[] = new int[MAX];
	static int group_cnt = 1;

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			list[i] = new ArrayList<Integer>();
			reverselist[i] = new ArrayList<Integer>();

		}

		for (int i = 0; i < M; i++) {

			int x = sc.nextInt();
			int y = sc.nextInt();

			list[x].add(y);
			reverselist[y].add(x);

		}

		// DFS를 하면서 빠져나오는 순서대로 시간을 기록

		for (int i = 1; i <= N; i++) {

			if (!check[i]) {
				getTime(i);
			}
		}

		// 빠져나오는 순서대로 시간이 기록됨.
		// 뒤집은 그래프에 대해서, 빠져나오는 시간이 큰 노드부터 순회.
		// 이 때 만나는 노드들이 모두 같은 그룹임.

		for (int i = order_len - 1; i >= 0; i--) {

			int node = order[i];

			if (!check2[node]) {
				get_my_group(node);
				group_cnt++;
			}
		}
		System.out.println(group_cnt - 1);

	}

	public static void getTime(int node) {

		check[node] = true;

		for (int i = 0; i < list[node].size(); i++) {
			int node2 = list[node].get(i);
			if (!check[node2]) {

				getTime(node2);
			}
		}

		time[node] = clock;
		order[order_len++] = node;
		clock++;
	}

	public static void get_my_group(int node) {

		check2[node] = true;
		group[node] = group_cnt;

		for (int i = 0; i < reverselist[node].size(); i++) {

			int node2 = reverselist[node].get(i);

			if (!check2[node2]) {

				get_my_group(node2);
			}
		}
	}
}