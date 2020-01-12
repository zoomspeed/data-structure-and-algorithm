import java.util.*;

public class Main {
	static int N;
	static int M;
	static final int MAX = 10500;
	static ArrayList<Integer> list[] = new ArrayList[MAX];
	static boolean visited[] = new boolean[MAX];
	static Queue<int[]> queue = new LinkedList<int[]>();
	static int start = 0;
	static int answer = Integer.MAX_VALUE;
	static int end = 0;

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		for (int i = 0; i < MAX; i++) {

			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {

			int x = sc.nextInt();
			int y = sc.nextInt();

			list[x].add(y);
			list[y].add(x);
		}

		start = sc.nextInt();
		end = sc.nextInt();

		queue.add(new int[] { start, 0 });
		getDistance();
	}

	public static void getDistance() {

		boolean goal = true;

		while (queue.peek() != null && goal) {

			int data[] = queue.poll();

			int node = data[0];
			int length = data[1];

			if (node == end) {
				System.out.println(length);
				goal = false;
				continue;
			}

			for (int i = 0; i < list[node].size(); i++) {

				int nextNode = list[node].get(i);

				if (!visited[nextNode]) {

					visited[nextNode] = true;

					queue.add(new int[] { nextNode, length + 1 });
				}
			}
		}
	}
}