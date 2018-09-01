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
//		System.out.println(data);
		
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
					if (!traverseForDuplicates(score, root, false))
					{
						insert(new Node(score, data), root);
					}
				}
			}
			else 
			{
				root = new Node(score, data);
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
			
			int binary = result.length()-1;

			for (int i = 0; i < result.length() && binary > -1; i++)
			{
				if (Character.isUpperCase(result.charAt(i)))
				{
					score += Math.pow(2, binary);
				}
				binary--;
			}
			return score;
		}
		
		private boolean traverseForDuplicates(int score, Node root, boolean hasDuplicate)
		{
			if (root.left != null)
			{
				if (!(root.left.score == score))
				{
					traverseForDuplicates(score, root.left, hasDuplicate);
				}
				else 
				{
					root.left.increment();
					hasDuplicate = true;
					return true;
				}
			}
			if (root.right != null)
			{
				if (!(root.right.score == score))
				{
					traverseForDuplicates(score, root.right, hasDuplicate);
				}
				else 
				{
					root.right.increment();
					hasDuplicate = true;
					return true;
				}
			}
			return hasDuplicate;
		}
		
		
		/*
		 * Is used iff root != null & no duplicates
		 * 
		 */
		private Node insert(Node newNode, Node currNode)
		{
			if (currNode == null)
			{
				currNode = newNode;
				return currNode;
			}
			
			//Small on the left
			if (newNode.score < currNode.score)
			{
				currNode.left = insert(newNode, currNode.left);
			}
			//Large on the right
			else if (newNode.score > currNode.score)
			{
				currNode.right = insert(newNode, currNode.right);
			}
			
			currNode.height = getHeight(currNode);
			currNode = checkBalance(newNode, currNode);
			
			return currNode;
		}
		
		private int getBalance(Node node)
		{
			if (node == null)
			{
				return 0;
			}
			else
			{
				return getHeight(node.left) - getHeight(node.right);
			}
		}
		
		private int getHeight(Node root)
		{
			if (root == null)
			{
				return -1;
			}
			
			return ((Math.max(getHeight(root.left), getHeight(root.right))) + 1);
		}
		
		
		private Node checkBalance(Node newNode, Node node)
		{
			int balance = getBalance(node);
			
			//LeftLeft Case
			if (balance > 1 && newNode.score < node.left.score)
			{
				return rotateRight(node);
			}
			//LeftRight Case
			else if (balance > 1 && newNode.score > node.left.score)
			{
				node.left = rotateLeft(node.left);
				return rotateRight(node);
			}
			//RightRight Case
			else if (balance < -1 && newNode.score > node.right.score)
			{
				return rotateLeft(node);
			}
			//RightLeft Case
			else if (balance < -1 && newNode.score < node.right.score)
			{
				node.right = rotateRight(node.right);
				return rotateLeft(node);
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
		
		public List<String> getOffspringOutput()
		{
			output = new ArrayList<>();
			getInOrderTraversal(root);
			return output;
		}
		
		private void getInOrderTraversal(Node root)
		{
			if (root == null)
			{
				return;
			}
				getInOrderTraversal(root.left);
//			System.out.println(root.score);
//			output.add(root.data);
			for (int add = 0; add <= root.duplicate; add++)
			{
//				System.out.println(root.score);
				output.add(root.data);
			}
				getInOrderTraversal(root.right);
		}
		
		public class Node
		{
			private int score, duplicate, height;
			private String data;
			private Node parent, left, right;
			
			private Node(int score, String data)
			{
				this.score = score;
				this.data = data;
				duplicate = 0;
				height = 0;
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
