package ≤‚ ‘;

import java.util.Scanner;

public class BinaryTree {
	private String data;
	private BinaryTree lchild, rchild;

	public BinaryTree createTree(Scanner scanner) {
		//Scanner scanner = new Scanner(System.in);
		String ch;
		BinaryTree t = new BinaryTree();

		ch = scanner.nextLine();
				
		if (!ch.equals("#")) {
			t.data = ch;
			t.lchild = t.createTree(scanner);
			t.rchild = t.createTree(scanner);
			//scanner.close();
			return t;
		} else {
			//scanner.close();
			return null;
		}
	}

	public void traverseTree(BinaryTree t) {
		if (t != null) {
			traverseTree(t.lchild);
			System.out.println(t.data);
			traverseTree(t.rchild);
		}
	}

	public static void main(String arg[]) {
		BinaryTree t = new BinaryTree();
		Scanner sc = new Scanner(System.in);
		t = t.createTree(sc);
		sc.close();

		t.traverseTree(t);
	}
}
