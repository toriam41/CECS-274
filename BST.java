/*
 * Tori McDonald
 * Program 5 - Binary Search Tree
 * CECS 274-05
 * 5/9/19
 */


package binaryTree;


public class BST {

	private class Node{
		
		private int value;
		private Node left;
		private Node right;
		private Node parent;
		
		public Node(int x) {
			value = x;
			left = null;
			right = null;
			parent = null;
		}
	}
	
	private Node root;
	
	public BST() {
		root = null;
	}
	
	int getRoot() {
		
		if (root == null) {
			return 0;
		}
		else {
			return root.value;
		}	
	}
	
	public void add(int i) {
		Node temp = new Node(i);
		
		if (i < 0) {
			return;
		}
		
		if (root == null) {
			root = temp;
		}
		else {
			add(root, i);
		}
	}
	
	private void add(Node n, int p) {
		Node temp = new Node(p);
		
		if (p < n.value) {
			if (n.left == null) {
				n.left = temp;
				temp.parent = n;
			}
			else {
				add(n.left, p);
			}
		}
		else if (p > n.value) {
			if (n.right == null) {
				n.right = temp;
				temp.parent = n;
			}
			else {
				add(n.right, p);
			}
		}	
	}
	
	public int getCount() {
		return getCount(root);
	}
	
	private int getCount(Node o) {
		if (o == null) {
			return 0;
		}
		else {
			return (1 + getCount(o.left) + getCount(o.right));
		}
	}
	
	public int getHeight() {
		return getHeight(root);
	}
	
	private int getHeight(Node d) {
		if (d == null) {
			return 0;
		}
		else {
			int left = getHeight(d.left);
			int right = getHeight(d.right);
			
			return 1 + ((left > right)?left:right);
		}
	}
	
	public int findLevel(int j) {
		return findLevel(root, j, 1);
	}
	
	private int findLevel(Node e, int x, int l) {
		Node next = e;
		
		if (root != null && root.left == null && root.right == null) {
			return l;
		}
		else if (x > e.value && e.right != null) {
			next = e.right;
			l += 1;
			return findLevel(next, x, l);
		}
		else if (x < e.value && e.left != null) {
			next = e.left;
			l +=1;
			return findLevel(next, x, l);
		}
		else if (x == e.value) {
			return l;
		}
		return l;
	}
	
	public Node findNode(int x) {
		return findNode(root, x);
	}
	
	private Node findNode(Node n, int x) {
		if (n == null) {
			return null;
		}
		if (n.value == x) {
			return n;
		}
		else if (x < n.value) {
			return findNode(n.left, x);
		}
		else {
			return findNode(n.right, x);
		}
	}
	
	public int findParent(int x) {
		return findNode(x).parent.value;
	}
	
	public int findLeftChild(int x) {
		if (findNode(x).left == null){
			return 0;
		}
		return findNode(x).left.value;
	}
	
	public int findRightChild(int x) {
		if (findNode(x).right == null) {
			return 0;
		}
		return findNode(x).right.value;
	}
	
	public boolean isBalanced() {
		if(root == null) {
			System.out.println("Empty Tree :(");
			return true;
		}
		else {
			return isBalanced(root);
		}
	}
	
	private boolean isBalanced(Node n) {
		if (n == null) {
			return true;
		}
		else {
			int lheight;
			int rheight;
			
			lheight = getHeight(n.left);
			rheight = getHeight(n.right);
			
			if (lheight - rheight > 1 || rheight - lheight > 1) {
				return false;
			}
			else {
				return true;
			}
		}
	}
	
	public void display() // display tree contents in sorted order
	{
		if (root == null)
			System.out.println("Empty tree");
		else
		   display(root);
	}

	private void display(Node N) // recursive call to display subtree
	{
		if (N == null)
			return;
		else
		{
			display(N.left);
			System.out.print(N.value);
			System.out.print(", ");
			display(N.right);
		}
	}

	
	public void displayTree() // graphically display the tree
	{
		String [] A = new String[32];
		for(int i=0; i<32; i++)
			A[i] = " . ";
		String temp;
		if (root == null)
			temp = " . ";
		else
			temp = Integer.toString(root.value);
		A[1] = temp;
		
		buildArray(root, A, 1);
	
		//System.out.println("         1         2         3         4         5         6         7         8         9         0");
		//System.out.println("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
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

	// Build an array that represents the tree:
	// The parent index of any node it the node index / 2
	// The index of the left child is the parent index * 2
	// The index of the right child is the parent index * 2 + 1
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












