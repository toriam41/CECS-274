/**
 * Tori McDonald
 * CECS 274-05
 * Program 6 - 	Binary Tree
 * 12/3/19
 */

package binarytree;

public class BST {

	private class Node {
		
		private int value;
		private Node left;
		private Node right;
		
		public Node(int x) {
			value = x;
			left = null;
			right = null;
		}
	}
	
	private Node root;	
	
	public BST() {
		root = null;
	}
	
	public int getRoot() {
		if (root == null) {
			return 0;
		}
		else {
			return root.value;
		}
	}
	
	public int getCount() {
		return getCount(root);
	}
	
	private int getCount(Node n) {
		if (n == null) {
			return 0;
		}
		else {
			return (1 + getCount(n.left) + getCount(n.right));
		}
	}
	
	public int findLevel(int x) {
		return findLevel(root, x, 1);
	}
	
	private int findLevel( Node n, int x, int level) {
		Node next = n;
		
		if (root != null && root.left == null && root.right == null) {
			return level;
		}
		else if (x > n.value && n.right != null) {
			next = n.right;
			level += 1;
			return findLevel(next, x, level);
		}
		else if (x < n.value && n.left != null) {
			next = n.left;
			level += 1;
			return findLevel(next, x, level);
		}
		else if (x == n.value) {
			return level;
		}
		return level;
	}
	
	public void add(int x) {		
		Node temp = new Node(x);
		
		if (x < 0) {
			return;
		}
		
		if (root == null) {
			root = temp;
		}
		else {
			add(root, x);
		}
	}
	
	private void add(Node n, int p) {
		Node temp = new Node(p);
		
		if (p < n.value) {
			if (n.left == null) {
				n.left = temp;
			}
			else {
				add(n.left, p);
			}
		}
		else if (p > n.value) {
			if (n.right == null) {
				n.right = temp;
			}
			else {
				add(n.right, p);
			}
		}	
	}
	
	public void print() {
		if (root == null)
			System.out.println("Empty tree");
		else
		   print(root);
	}
	
	private void print(Node n) {
		if (n == null)
			return;
		else
		{
			print(n.left);
			
			System.out.print(n.value);
			System.out.print(", ");
			
			print(n.right);
		}
	}
	
	public int getHeight() {
		return getHeight(root);
	}
	
	private int getHeight(Node n) {
		if (n == null) {
			return 0;
		}
		else {
			int left = getHeight(n.left);
			int right = getHeight(n.right);
			
			return 1 + ((left > right)?left:right);
		}
	}
	
	public boolean remove(int x) {
		return remove(root, x);
	}
	
	public Node minimumKey(Node curr) {
		while (curr.left != null) {
			curr = curr.left;
		}
		
		return curr;
	}
	
	private boolean remove(Node root, int key) {
		Node parent = null;
		Node curr = root;
		
		while (curr != null && curr.value != key) {
			parent = curr;
			
			if (key < curr.value) {
				curr = curr.left;
			}
			else {
				curr = curr.right;
			}
		}
		
		if (curr == null) {
			return false;
		}
		
		if (curr.left == null && curr.right == null) {
			if (curr != root) {
				if (parent.left == curr) {
					parent.left = null;
				}
				else {
					parent.right = null;
				}
			}
			else {
				root = null;
			}
		}
		else if (curr.left != null && curr.right != null) {
			Node successor = minimumKey(curr.right);
			int val = successor.value;
			
			remove(root, successor.value);
			
			curr.value = val;
		}
		else {
			Node child = (curr.left != null)? curr.left:curr.right;
			
			if (curr != root) {
				if (curr == parent.left) {
					parent.left = child;
				}
				else {
					parent.right = child;
				}
			}
			else {
				root = child;
			}
		}
		return true;
	}
	
	
	public void display() {
		String [] A = new String[32];
		
		for (int i = 0; i < 32; i++) {
			A[i] =  " . ";
		}
		
		String temp;
			
		if (root == null) {
			temp = " . ";
		}
		else {
			temp = Integer.toString(root.value);
		}
			
		A[1] = temp;
		
		buildArray(root, A, 1);
		
		System.out.println("                                                                                                    ");
		System.out.println("                                                "+A[1]+"                                            ");
		System.out.println("                                                 |                                                 ");
		System.out.println("                     "+A[2]+"-------------------------^-----------------------"+A[3]);
		System.out.println("                       |                                                  | ");
		System.out.println("         "+A[4]+"-----------^-----------"+A[5]+"                      "+A[6]+"-----------^-----------"+A[7]);
		System.out.println("          |                         |                         |                         |       ");
		System.out.println("   "+A[8]+"----^----"+A[9]+"           "+A[10]+"----^----"+A[11]+"           "+A[12]+"----^----"+A[13]+"           "+A[14]+"----^----"+A[15]);
		System.out.println("    |            |            |            |            |            |            |            |    ");
		System.out.println(A[16]+"-^-"+A[17]+"    "+A[18]+"-^-"+A[19]+"    "+A[20]+"-^-"+A[21]+"    "+A[22]+"-^-"+A[23]+"    "+A[24]+"-^-"+A[25]+"    "+A[26]+"-^-"+A[27]+"    "+A[28]+"-^-"+A[29]+"    "+A[30]+"-^-"+A[31]);
		System.out.println("                                                                                                    ");                                                                               	
	}
	
	private void buildArray(Node n, String [] strArray, int parentIndex)
	{
		if (parentIndex * 2 + 1 > strArray.length)
			return;
		
		if (n == null)
			return;
		else
		{
			String temp;
			if (n.left == null)
				temp = " . ";
			else
				temp = Integer.toString(n.left.value);
			
			strArray[parentIndex*2] = String.format("%3s",temp);
			buildArray(n.left, strArray, parentIndex*2);
			
			if (n.right == null)
				temp = " . ";
			else
				temp = Integer.toString(n.right.value);
			
			strArray[parentIndex*2+1] = String.format("%3s",temp);
			buildArray(n.right, strArray, parentIndex*2+1);		
		}
	}
}