import java.util.*;

public class Main {

	static int N;
	static int x;
	static int y;
	static Node node;
	static List<Node> box = new ArrayList<>();
	static List<Node> list = new ArrayList<>();

	static List<Integer> xPosition = new ArrayList<>();
	static List<Integer> yPosition = new ArrayList<>();

	public static void main(String[] args) {

		// Please Enter Your Code Here

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();

		for (int i = 0; i < N - 1; i++) {

			int current = sc.nextInt();
			int newData = sc.nextInt();

			node = findNode(current);

			if (node == null) {
				node = new Node();
			}

			if (node.getData() == -1) {

				node.setData(current);
			}

			node.setChild(newData);

		}

		findFather(findNode(x), xPosition);
		findFather(findNode(y), yPosition);

		for (int i = 0; i < xPosition.size(); i++) {
			// 6 2 0
			// 2 0
			for (int j = 0; j < yPosition.size(); j++) {

				if (xPosition.get(i) == yPosition.get(j)) {

					System.out.println(xPosition.get(i));

					return;
				}
			}
		}

	}
	// 2 0
	// 6 2 0

	public static void findFather(Node node, List<Integer> answer) {

		int data = 0;

		while (node.getFather() != null) {

			data = node.getFather().getData();
			answer.add(data);
			node = node.getFather();
		}
		return;
	}

	public static void printAll(Node node) {

		List<Node> child;

		if (node == null) {

			return;
		}

		child = node.getChild();

		if (node.getFather() != null) {

			System.out.print(node.getFather().getData() + "   ");
		}

		System.out.println(node.getData());

		if (child == null) {
			return;

		}

		for (int i = 0; i < child.size(); i++) {

			printAll(child.get(i));
		}

	}

	public static Node findNode(int key) {

		for (int i = 0; i < box.size(); i++) {

			if (box.get(i).getData() == key) {

				return box.get(i);
			}
		}

		return null;

	}

}

class Node {

	private Node father = null;
	private final int MAX = 1050;
	private List<Node> child = new ArrayList<>();

	private int data = -1;

	public Node() {
		Main.box.add(this);

	}

	public Node getFather() {

		return father;
	}

	public void setFather(Node n) {

		this.father = n;
	}

	public void setChild(int newData) {

		Node temp = new Node();
		temp.setData(newData);
		temp.setFather(this);

		child.add(temp);

	}

	public List<Node> getChild() {

		return child;
	}

	public void setData(int newData) {

		this.data = newData;
	}

	public int getData() {

		return data;
	}

	public List<Node> getList() {

		return child;
	}

}