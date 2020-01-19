import java.util.*;

public class Main {
	static int N = 0;
	static final int MAX = 1050;
	static int nodecount = 0;
	static ArrayList<binaryNode> list = new ArrayList<binaryNode>();
	static Queue<binaryNode> Q = new LinkedList<binaryNode>();
	static int maxLevel[] = new int[MAX];
	static int minLevel[] = new int[MAX];
	static int levelLen = 0;
	static int answerVal = 0;
	static int answerLevel = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int count = 0;
		int findN = 0;

		for (int i = 0; i < MAX; i++) {

			minLevel[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < N; i++) {

			findN = 0;
			int current = sc.nextInt();
			int left = sc.nextInt();
			int right = sc.nextInt();
			binaryNode n = null;

			for (findN = 0; findN < count; findN++) {

				if (list.get(findN) == null) {
					continue;
				}
				if (current == list.get(findN).node) {
					n = list.get(findN);
					break;
				}
			}

			if (findN == count) {

				n = new binaryNode(current);
			}

			list.add(n);
			count++;
			if (left != -1) {
				n.setLeft(new binaryNode(left));
				list.add(n.left);
				count++;
			}

			if (right != -1) {
				n.setRight(new binaryNode(right));
				list.add(n.right);
				count++;
			}
		}
		search(list.get(0), 1);

		Q.add(list.get(0));
		bfs();

		for (int i = 1; i <= levelLen; i++) {

			if (answerVal < maxLevel[i] - minLevel[i] + 1) {

				answerVal = maxLevel[i] - minLevel[i] + 1;
				answerLevel = i;
			} else if (answerVal == maxLevel[i] - minLevel[i] + 1) {
				// 같을경우 그냥 넘기면 됨.
				continue;
			}
		}

		System.out.print(answerLevel + " ");
		System.out.print(answerVal);
	}

	public static void bfs() {

		while (Q.peek() != null) {

			binaryNode binaryN = Q.poll();

			int level = binaryN.level;
			int count = binaryN.count;

			if (minLevel[level] > count) {

				minLevel[level] = count;
			}

			if (maxLevel[level] < count) {

				maxLevel[level] = count;
			}

			if (binaryN.left != null) {

				Q.add(binaryN.left);
			}

			if (binaryN.right != null) {

				Q.add(binaryN.right);
			}
		}
	}

	public static void search(binaryNode node, int level) {

		if (levelLen < level) {
			levelLen = level;
		}

		if (node.left != null) {
			search(node.left, level + 1);
		}
		node.count = ++nodecount;
		node.level = level;

		if (node.right != null) {
			search(node.right, level + 1);
		}
	}
}

class binaryNode {

	public int node = -1;
	public int level = 0;
	public int count = 0;
	public binaryNode left = null;
	public binaryNode right = null;

	public binaryNode(int node) {

		this.node = node;
	}

	public void setLeft(binaryNode left) {

		this.left = left;
	}

	public void setRight(binaryNode right) {

		this.right = right;
	}
}