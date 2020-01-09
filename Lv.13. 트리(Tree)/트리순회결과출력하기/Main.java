import java.util.Scanner;

public class Main {
	static int N;
	static int max = 250;
	static Node n[] = new Node[max];

	public static void main(String[] args) {

		// Please Enter Your Code Here
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {

			int current = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();

			n[i] = new Node();

			n[current].left = l;
			n[current].right = r;

		}

		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);

	}

	static void preOrder(int index) {

		if (index == -1) {
			return;
		}
		System.out.print(index + " ");

		preOrder(n[index].left);
		preOrder(n[index].right);

	}

	static void inOrder(int index) {

		if (index == -1) {
			return;
		}

		inOrder(n[index].left);
		System.out.print(index + " ");
		inOrder(n[index].right);

	}

	static void postOrder(int index) {

		if (index == -1) {
			return;
		}

		postOrder(n[index].left);
		postOrder(n[index].right);
		System.out.print(index + " ");

	}
}

class Node {

	int left;
	int right;

}