package punnettme;

import java.util.ArrayList;
import java.util.List;

public class AVLTree 
{
	private Node root;
	//For Testing purposes only.
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
					if (!traverseForDuplicates(score, root, false))
					{
						insert(new Node(score, data), root);
					}
				}
			}
			else 
			{
				root = new Node(score, data);
				System.out.println("Data Stored in Root: " + data); 
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
			
			for (int i = 0; i < result.length(); i++)
			{
				if (Character.isUpperCase(result.charAt(i)))
				{
					score += result.length() - i;
				}
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
					System.out.println("Data Stored in Left: " + newNode.data); 
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
					System.out.println("Data Stored in Right: " + newNode.data); 
				}
			}
			
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
			if ((getHeight(node.left) - getHeight(node.right) > 1) || (getHeight(node.left) - getHeight(node.right) < -1))
			{
				node = rebalance(node);
			}
			
			if (node.parent != null)
			{
				checkBalance(node.parent);
			}

		}
		
		
		/*
		 * NOTES FROM JULY 21
		 * 
		 * HOLY SHIT WE GOT IT
		 * 
		 * OLD NODE NEEDED IT'S PARENT VARIABLE UPDATED BOOM.
		 * 
		 * RIGHTROTATE IS PULLING NULL POINTERS ON LINE 268.
		 * 
		 * FIGURE OUT HOW TO JUNIT TEST STRING ARRAYS, OR
		 * USE THE OLD AN INNEFICIENT WAY OF A FOR LOOP OR SOMETHING.....ANNOYING
		 * 
		 * DOUBLE CHECK OLD JUNIT TESTS ARE STILL VIABLE & WORKING
		 * 
		 * 
		 */
		private Node rebalance(Node node)
		{
			if (getHeight(node.left) - getHeight(node.right) > 1)
			{
				//Left left case.
				if (getHeight(node.left.left) > getHeight(node.left.right))
				{
					node = rotateRight(node);
				}
				//Left Right case.
				else
				{
					node = rotateLeftRight(node);
				}
			}
			else
			{
				//Right Left case.
				if (getHeight(node.right.left) > getHeight(node.right.right))
				{
					node = rotateRightLeft(node);
				}
				//Right Right case.
				else
				{
					node = rotateLeft(node);
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
			temp.left = node;
			node.parent = temp;

			if (greatGrandParent != null)
			{
				temp.parent = greatGrandParent;
				
				if (greatGrandParent.left.score == oldChildScore)
				{
					greatGrandParent.left = temp;
				}
				else if (greatGrandParent.right.score == oldChildScore) 
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
				
				if (greatGrandParent.left.score == oldChildScore)
				{
					greatGrandParent.left = temp;
				}
				else if (greatGrandParent.right.score == oldChildScore) 
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
				System.out.println(root.data);
				output.add(root.data);
			}
				getInOrderTraversal(root.right);
		}
		
		public class Node
		{
			private int score, duplicate;
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
