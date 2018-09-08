/*
 * Punnett Me is an app to use for Punnett Squares for Genetic Trait Calculations.
 * You can calculate up to 5 different traits at once.
 * You can quickly change from Homozygous parents and Heterozygous parents 
 * for comparisons.
 * 
 * Uses Model View Controller design pattern, with Design by Contract programming.
 * 
 * Scott Smalley, BS Software Engineering student at Utah Valley University
 * Fall 2020 expected graduation
 * scottsmalley90@gmail.com
 * 
 */
package punnettme;

import java.util.ArrayList;
import java.util.List;

public class AVLTree 
{
	private Node root;
	private List<String> output = new ArrayList<>();
	
	public AVLTree()
	{
		root = null;
	}
	public void storeInTree(String data)
		{
			int score = scoreResult(data);
			
			if (root != null)
			{
				//In case root and score are the same value
				if (score == root.score)
				{
					root.increment();
				}
				else
				{
					/*
					 * If a duplicate is found, it will return true and 
					 * increment the counter for that Node in the traverseForDuplicates() method. 
					 */
//					if (!traverseForDuplicates(score, data, root, false))
					if (!traverseForDuplicates(score, root, false))
					{
						insert(new Node(score, data), root);
					}
				}
			}
			else 
			{
				root = new Node(score, data);
//				System.out.println("Data Stored in Root: " + data); 
			}
			
		}
		
		//give the string a value
		/*
		 * scores are 2x the position, so if 5 genes, Capital in the first
		 * position is 10, then 9, 8, 7....
		 * 
		 */
		private int scoreResult(String result)
		{
			int score = 0;
			
//			int binary = result.length();
			int binary = result.length()-1;

			//			System.out.println("binary " + binary);
			
			for (int i = 0; i < result.length() && binary > -1; i++)
			{
//				System.out.println("Looking at char: " + result.charAt(i));
//				System.out.println("PRE Score: " + score + " result: " + result);
//				System.out.println("Binary: " + binary);
				
				if (Character.isUpperCase(result.charAt(i)))
				{
//					System.out.println("PreScore: " + score);
//					score += result.length() - i;
//					score += 2 ^ binary;
					score += Math.pow(2, binary);
//					System.out.println("PostScore: " + score);
				}
				binary--;
			}
//			System.out.println("POST Score: " + score + " result: " + result);
//			scoretotal++;
			return score;
		}
		
//		private boolean traverseForDuplicates(int score, String data, Node root, boolean hasDuplicate)
		private boolean traverseForDuplicates(int score, Node root, boolean hasDuplicate)
		{
			if (root.left != null)
			{
				if (!(root.left.score == score))
				{
//					traverseForDuplicates(score, data, root.left, hasDuplicate);
					traverseForDuplicates(score, root.left, hasDuplicate);
				}
//				else if (root.left.data.equals(data))
				else
				{
//					System.out.println("DUPLICATE FOUND - ROOT: " + root.data + " - Score: " + score);
//					System.out.println("DUPLICATE FOUND - ROOT.LEFT: " + root.left.data +  " - newData: " + data + " - Score: " + score );
					root.left.increment();
					hasDuplicate = true;
					return true;
				}
//				else
//				{
//					System.out.println("****************NO SCORE OR DATA MATCH LEFT***************");
//				}
			}

			if (root.right != null)
			{
				if (!(root.right.score == score))
				{
//					traverseForDuplicates(score, data, root.right, hasDuplicate);
					traverseForDuplicates(score, root.right, hasDuplicate);
				}
//				else if (root.right.data.equals(data))
				else
				{
//					System.out.println("DUPLICATE FOUND - ROOT: " + root.data + " - Score: " + score);
//					System.out.println("DUPLICATE FOUND - ROOT.RIGHT: " + root.right.data + " - newData: " + data + " - Score: " + score);
					root.right.increment();
					hasDuplicate = true;
					return true;
				}
//				else
//				{
//					System.out.println("****************NO SCORE OR DATA MATCH RIGHT***************");
//				}
			}
			return hasDuplicate;
		}
		
		/*
		 * Is used iff root != null & no duplicates
		 * 
		 */
		private void insert(Node newNode, Node root)
		{
			
			//Small on the left
			if (newNode.score < root.score)
			{
				if (root.left != null)
				{
					insert(newNode, root.left);
				}
				else
				{
					root.left = newNode;
					newNode.parent = root;
//					System.out.println("Data Stored in Left: " + newNode.data); 
				}
			}
			//Large on the right
			else if (newNode.score > root.score)
			{
				if (root.right != null)
				{
					insert(newNode, root.right);
				}
				else
				{
					root.right = newNode;
					newNode.parent = root;
//					System.out.println("Data Stored in Right: " + newNode.data); 
				}
			}
//			else
//			{
//				System.out.println("*****************************************INSERTION ERROR***************************************");
//			}
			
			checkBalance(newNode);
		}
		
		private int getHeight(Node root)
		{
			if (root == null)
			{
				return -1;
			}
			
			return (Math.max(getHeight(root.left), getHeight(root.right)) + 1);
		}
		
		
		private void checkBalance(Node node)
		{
			if ((getHeight(node) > 1) || getHeight(node) < -1)
//				if ((getHeight(node.left) - getHeight(node.right) > 1) || (getHeight(node.left) - getHeight(node.right) < -1))
			{
				node = rebalance(node);
//				if (node.equals(node.parent))
//				{
//					System.out.println("POST REBALANCE I'M MY OWN PARENT WTF: " + node.data + " " + node.score);
//					if (node.left != null)
//					{
//						System.out.println("Left: " + node.left.data + " " + node.left.score);
//					}
//					if (node.right != null)
//					{
//						System.out.println("Right: " + node.right.data + " " + node.right.score);
//					}
//				}
			}
//			if (node.equals(node.parent))
//			{
//				System.out.println("OUTSIDE OF REBALANCE I'M MY OWN PARENT WTF: " + node.data + " " + node.score);
//			}
			if (node.parent != null)
			{
				checkBalance(node.parent);
			}

		}

		private Node rebalance(Node node)
		{
			if (getHeight(node.left) - getHeight(node.right) > 1)
			{
				//Left left case.
				if (getHeight(node.left.left) > getHeight(node.left.right))
				{
//					if (node.parent != null)
//					{
//						System.out.println("PRE LEFTLEFT CASE Parent: " + node.parent.data + " Score: " + node.parent.score);
//					}
					node = rotateRight(node);
//					if (node.parent != null)
//					{
//						System.out.println("POST LEFTLEFT CASE Parent: " + node.parent.data + " Score: " + node.parent.score);
//					}
				}
				//Left Right case.
				else
				{
//					if (node.parent != null)
//					{
//						System.out.println("PRE LEFTRIGHT CASE Parent: " + node.parent.data + " Score: " + node.parent.score);
//					}
					node = rotateLeftRight(node);
//					if (node.parent != null)
//					{
//						System.out.println("POST LEFTRIGHT CASE Parent: " + node.parent.data + " Score: " + node.parent.score);
//					}
				}
			}
			else
			{
				//Right Left case.
				if (getHeight(node.right.left) > getHeight(node.right.right))
				{
//					if (node.parent != null)
//					{
//						System.out.println("PRE RIGHTLEFT CASE Parent: " + node.parent.data + " Score: " + node.parent.score);
//					}
					node = rotateRightLeft(node);
//					if (node.parent != null)
//					{
//						System.out.println("POST RIGHTLEFT CASE Parent: " + node.parent.data + " Score: " + node.parent.score);
//					}
				}
				//Right Right case.
				else
				{
//					if (node.parent != null)
//					{
//						System.out.println("PRE RIGHTRIGHT CASE Parent: " + node.parent.data + " Score: " + node.parent.score);
//					}
					node = rotateLeft(node);
//					if (node.parent != null)
//					{
//						System.out.println("POST RIGHTRIGHT CASE Parent: " + node.parent.data + " Score: " + node.parent.score);
//					}
				}
			}

			return node;
		}
		
		/*
		 * Rotates the Grandparent counterclockwise around the
		 * parent.
		 * @param root Node (Grandparent)
		 */
		private Node rotateLeft(Node node)
		{
			Node greatGrandParent = node.parent;
			int oldChildScore = node.score;
			
			Node temp = node.right;
			node.right = temp.left;

			//New
			if (node.right != null)
			{
				node.right.parent = node;
			}
			
			temp.left = node;
			node.parent = temp;

			if (greatGrandParent != null)
			{
				temp.parent = greatGrandParent;
				
				if (greatGrandParent.left != null && greatGrandParent.left.score == oldChildScore)
				{
					greatGrandParent.left = temp;
				}
				else if (greatGrandParent.right != null && greatGrandParent.right.score == oldChildScore) 
				{
					greatGrandParent.right = temp;
				}
			}
			else
			{
				root = temp;
				temp.parent = null;
			}	
			
			return temp;
		}
		
		/*
		 * Rotates the Grandparent clockwise around the
		 * parent.
		 * @param root Node (Grandparent)
		 */
		private Node rotateRight(Node node)
		{
			Node greatGrandParent = node.parent;
			int oldChildScore = node.score;
			
			Node temp = node.left;
			node.left = temp.right;
			
			//New
			if (node.left != null)
			{
				node.left.parent = node;
			}
			
			temp.right = node;
			node.parent = temp;
			
			if (greatGrandParent != null)
			{
				temp.parent = greatGrandParent;
				
				
				if (greatGrandParent.left != null && greatGrandParent.left.score == oldChildScore)
				{
					greatGrandParent.left = temp;
				}
				else if (greatGrandParent.right != null && greatGrandParent.right.score == oldChildScore) 
				{
					greatGrandParent.right = temp;
				}
			}
			else
			{
				root = temp;
				temp.parent = null;
			}
			
			return temp;
		}
		
		private Node rotateRightLeft(Node node)
		{
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		private Node rotateLeftRight(Node node)
		{
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		
		//Outward facing traversal call
		public void inOrderTraversal()
		{
			inOrderTraversal(root);
		}
		
		//inward facing recursive traversal
		private void inOrderTraversal(Node root)
		{
			if (root == null)
			{
				return;
			}
				inOrderTraversal(root.left);
			for (int duplicate = 0; duplicate <= root.duplicate; duplicate++)
			{
				System.out.println(root.data);
				
			}
				inOrderTraversal(root.right);
		}
		
		public List<String> getTestingOutput()
		{
			output = new ArrayList<>();
			getInOrderTraversal(root);
			
//			System.out.println("Scored results: " + scoretotal);
			
			return output;
		}
		
		private void getInOrderTraversal(Node root)
		{
			if (root == null)
			{
				return;
			}
				getInOrderTraversal(root.left);
//			System.out.println(root.data);
//			output.add(root.data);

			for (int add = 0; add <= root.duplicate; add++)
			{
//				System.out.println(root.data);
				output.add(root.data);
			}
				getInOrderTraversal(root.right);
		}
		
		public class Node
		{
			private int score;
			private int duplicate = 0;
			private String data;
			private Node parent, left, right;
			
			private Node(int score, String data)
			{
				this.score = score;
				this.data = data;
				duplicate = 0;
				left = null;
				right = null;
				parent = null;
			}
			
			void increment()
			{
				duplicate++;
			}
		}
}
