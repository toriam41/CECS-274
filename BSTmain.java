package binarytree;

import java.util.Scanner;

public class BSTmain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char choice = 'T';
		BST myBST = new BST();
		int num;
		
		myBST.display();
		
		choice = menu();
		
		while (choice != 'Q') {
			switch (choice) {
			case 'A':
				System.out.print("Enter a positive integer between 100 - 999: ");
				
				num = in.nextInt();
				
				while (num < 100 || num > 999) {
					num = in.nextInt();
				}
				myBST.add(num);
				myBST.display();
				break;
			
			
			case 'R':
				System.out.println("Enter a number to delete from the tree: ");
				num = in.nextInt();
				boolean found = myBST.remove(num);
				
				if (found) {
					System.out.println(num + "was removed from the tree.");
				}
				else {
					System.out.println(num + "is not in the tree");
				}
				myBST.display();
				break;
			
				
			case 'E':
				myBST = new BST();
				myBST.display();
				break;
				
			
			case 'D':
				myBST = defaultTree();
				myBST.display();
		}
		
		myBST.print();
		System.out.println();
		choice = menu();
	}	

	}

	
	public static char menu() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("(A)dd item     (R)emove item    (E)mpty tree   (D)efault Tree  (Q)uit");
		
		char option = in.next().charAt(0);
		option = Character.toUpperCase(option);
		
		return option;
	}
	
	
	public static BST defaultTree() {
		BST tree = new BST();	
		tree.add(500);
		tree.add(205);
		tree.add(750);
		tree.add(150);
		tree.add(250);
		tree.add(604);
		tree.add(834);
		tree.add(120);
		tree.add(187);
		tree.add(230);
		tree.add(402);
		tree.add(570);
		tree.add(691);
		tree.add(794);
		tree.add(925);
		tree.add(102);
		tree.add(134);
		tree.add(169);
		tree.add(201);
		tree.add(210);
		tree.add(235);
		tree.add(263);
		tree.add(410);
		tree.add(562);
		tree.add(583);
		tree.add(621);
		tree.add(699);
		tree.add(775);
		tree.add(799);
		tree.add(852);
		tree.add(962);
		
		return tree;
	}
}
