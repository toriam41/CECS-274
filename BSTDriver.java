package binaryTree;

//Welcome to the tree Jungle
//Driver for BST assignment
//Author: Steve Gold
//Program #5 - CECS 274 - Spring 2019
//Due on Tuesday April 30, 2019

import java.util.Scanner;
import java.util.Random;

public class BSTDriver {
	
	public static void main(String[] args) {
		
		BST myBST = new BST();
		Random rand = new Random();
		Scanner in = new Scanner(System.in);
		
		char option = 'Z';
		int num = 0;
		
		treeStats(myBST);
		
		option = menu();
		while (option != 'Q')
		{
		switch (option)
			{
				case 'A':
					System.out.print("Enter a positive integer:");
					num = in.nextInt();
					myBST.add(num);
					break;
					
				case 'B':
					if (myBST.isBalanced())
						System.out.println("This tree is balanced");
					else
						System.out.println("This tree is not balanced");
					break;
						
				case 'C':
					System.out.print("Enter a number to find the children:");
					num = in.nextInt();
					int lc = myBST.findLeftChild(num);
					int rc = myBST.findRightChild(num);
					System.out.printf("Number:%d, LeftChild:%d, RightChild:%d\n", num, lc, rc);
					break;
					
				case 'T':
					myBST.displayTree();
					break;
					
				case 'P':
					System.out.print("Enter a number to find the parent:");
					num = in.nextInt();
					int parent = myBST.findParent(num);
					if (parent == -1)
						System.out.printf("Number %d does not exist in the tree\n",num);
					else if (parent == 0)
						System.out.printf("Number %d is the root of the tree\n",num);
					else
						System.out.printf("Parent of %d is %d\n",num,myBST.findParent(num));
					break;
					
				case 'L':
					System.out.print("Enter a number to find level: ");
					
					num = in.nextInt();
					int lev = myBST.findLevel(num);
					
					System.out.println("Level: " + lev);
				case 'N':
					System.out.println("Creating an empty tree:");
					myBST = new BST();
					break;
					
				case 'R':
					System.out.print("How many numbers do you want to add:");
					num = in.nextInt();
					System.out.print("Lower Range:");
					int min = in.nextInt();
					System.out.print("Upper Range:");
					int max = in.nextInt();
					for(int i = 0; i < num; i++)
					{
						myBST.add(rand.nextInt(max-min+1) + min);
					}
			}
			treeStats(myBST);
			option = menu();
		}

	}
	
	public static char menu()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("(A)dd  (B)alanced?  (P)arent  (C)hildren  (N)ew tree  (T)ree display  (R)andomize  (Q)uit");
		char option = in.next().charAt(0);
		option = Character.toUpperCase(option);
		return option;
	}
	
	public static void treeStats(BST tree)
	{
		System.out.println("\nWelcome to the Jungle");
		System.out.println("-Tree Stats- Root:"+tree.getRoot());
		System.out.println("             Height:"+tree.getHeight());
		System.out.println("             Count:"+tree.getCount());
		tree.display();
		System.out.println();
	}
}  // end of driver program
