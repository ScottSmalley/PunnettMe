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
	
	
		//enter into AVL tree
		/*
		 * Node class
		 * 
		 * Need left/right/clockwise rotation methods
		 * Need insert method
		 * 
		 * connections from root to leaves
		 */
		public void storeInTree(String data)
		{
			int score = scoreResult(data);
			
			if (root != null)
			{
				//In case root and score are the same value
				if (score == root.score)
				{
//					System.out.println("DUPLICATE ROOT SCORE");
//					System.out.println("Data Stored: " + data); 
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
//						System.out.println("No Duplicates");
						insert(new Node(score, data), root);

					}
				}
			}
			else 
			{
				root = new Node(score, data);
//				System.out.println("Data Stored: " + data); 
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
//					System.out.println("IT'S UPPER CASE!!! score: " + (result.length() - i));
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
//					System.out.println("Data Stored: " + root.left.data); 
					
					hasDuplicate = true;
					return true;
				}
			}
//			else if (root.right != null)
			if (root.right != null)
			{
				if (!(root.right.score == score))
				{
					traverseForDuplicates(score, root.right, hasDuplicate);
				}
				else
				{
					root.right.increment();
//					System.out.println("Data Stored: " + root.right.data); 
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
//					System.out.println("Data Stored: " + newNode.data); 
					
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
//					System.out.println("Data Stored: " + newNode.data); 
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
//				System.out.println("************REBALANCE INITIATED************");
//				System.out.println("************BALANCE VALUE: " + ((getHeight(node.left) - getHeight(node.right)) + "************"));
				
				//To point to the parent we're disconnecting & reconnecting to.
				Node greatGrandParent = node.parent;
				int oldChildScore = node.score;
				
				node = rebalance(node);
				//Reconnecting the new rebalanced node back into the tree.
				if (greatGrandParent != null)
				{
//					System.out.println("GPP not null");
					node.parent = greatGrandParent;
					
					if (greatGrandParent.left.score == oldChildScore)
					{
//						System.out.println("GPP's left child needs updating.");
						greatGrandParent.left = node;
					}
					else if (greatGrandParent.right.score == oldChildScore) 
					{
//						System.out.println("GPP's right child needs updating.");
						greatGrandParent.right = node;
						
					}
					else
					{
//						System.out.println("GPP's L and R scores don't match.");
					}
				}
				else
				{
					root = node;
					node.parent = null;
				}
			}
			
			if (node.parent != null)
			{
				checkBalance(node.parent);
			}

		}
		
		
		/*
		 * NOTES FROM JULY 15
		 * 
		 * 
		 * 
		 * LEFT ROTATE AND RIGHT ROTATE WORK!
		 * LEFT RIGHT ROTATE AND RIGHT LEFT ROTATE WORK! - I think. more testing needed.
		 * 
		 * TO DO:
		 * IN ORDER TRAVERSALS ARE ONLY SHOWING ~500 OUT OF 1024 OFFSPRING...?
		 * I TESTED WHEN THEY'RE INSERTED INTO THE TREE AND ALL 1024 ARE "INSERTED"
		 * HOWEVER, IN-ORDER TRAVERSAL DOESN'T PRINT THEM ALL OUT, I INSERTED A FORLOOP
		 * TO OUTPUT DUPLICATES.
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
				if (getHeight(node.left.left) > getHeight(node.left.right))
				{
//					System.out.println("************LEFT LEFT CASE************");
					//Left left case.
					
					node = rotateRight(node);
				}
				else
				{
//					System.out.println("************LEFT-RIGHT CASE************");
					//Left Right case.

					node = rotateLeftRight(node);
				}
			}
			else
			{
				if (getHeight(node.right.left) > getHeight(node.right.right))
				{
//					System.out.println("************RIGHT LEFT CASE************");
					//Right Left case.
					
					node = rotateRightLeft(node);
				}
				else
				{
//					System.out.println("************RIGHT RIGHT CASE************");
					//Right Right case.
					
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
		private Node rotateLeft(Node root)
		{
			Node temp = root.right;
			root.right = temp.left;
			temp.left = root;
			
			return temp;
		}
		
		/*
		 * Rotates the Grandparent clockwise around the
		 * parent.
		 * @param root Node (Grandparent)
		 */
		private Node rotateRight(Node root)
		{
			Node temp = root.left;
			root.left = temp.right;
			temp.right = root;

			return temp;
		}
		
		private Node rotateRightLeft(Node root)
		{
			root.right = rotateRight(root.right);
			
			return rotateLeft(root);
			
		}
		private Node rotateLeftRight(Node root)
		{
			root.left = rotateLeft(root.left);
			
			return rotateRight(root);
			
		}
		
		//Outward facing traversal call
		public void inOrderTraversal()
		{
			inOrderTraversal(root);
			System.out.println("In Order Traversal Complete.");
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
//			System.out.println(root.data);
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
			System.out.println(root.data);
//			output.add(root.data);
			for (int add = 0; add <= root.duplicate; add++)
			{
				output.add(root.data);
			}
				getInOrderTraversal(root.right);
				
		}
		
		
		
		public class Node
		{
			private int score, height, duplicate;
			private String data;
			private Node parent, left, right;
			
			private Node(int score, String data)
			{
				this.score = score;
				this.data = data;
				height = 0;
				duplicate = 0;
			}
			
			void increment()
			{
				duplicate++;
			}
			
		}

}
