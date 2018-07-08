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
					System.out.println("DUPLICATE ROOT SCORE");
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
			}
			
		}
		
		//give the string a value
		/*
		 * scores are 2x the position, so if 5 genes, Capital in the first
		 * position is 10, then 9, 8, 7....
		 * 
		 */
		public int scoreResult(String result)
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
				System.out.println("************REBALANCE INITIATED************");
				System.out.println("************BALANCE VALUE: " + ((getHeight(node.left) - getHeight(node.right)) + "************"));
				
				//To point to the parent we're disconnecting & reconnecting to.
				Node greatGrandParent = node.parent;
				int oldChildScore = node.score;
				
				node = rebalance(node);
				//Reconnecting the new rebalanced node back into the tree.
				if (greatGrandParent != null)
				{
					System.out.println("GPP not null");
					node.parent = greatGrandParent;
					
					if (greatGrandParent.left.score == oldChildScore)
					{
						System.out.println("GPP's left child needs updating.");
						greatGrandParent.left = node;
					}
					else if (greatGrandParent.right.score == oldChildScore) 
					{
						System.out.println("GPP's right child needs updating.");
						greatGrandParent.right = node;
						
					}
					else
					{
						System.out.println("GPP's L and R scores don't match.");
					}
					
				}
				else
				{
					node.parent = null;
					root = node;
				}
			}
			
			if (node.parent != null)
			{
				checkBalance(node.parent);
			}

		}
		
		
		/*
		 * NOTES FROM JULY 7
		 * 
		 * LEFT ROTATE AND RIGHT ROTATE WORK!
		 * TO DO LIST:
		 * 
		 * LEFT RIGHT AND RIGHT LEFT ROTATIONS - VERIFY WITH INORDER TRAVERSALS 
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
					System.out.println("************LEFT LEFT CASE************");
					//Left left case.
					node = rotateRight(node);
//					rotateRight(node);
				}
				else
				{
					System.out.println("************LEFT-RIGHT CASE************");
					//Left Right case.
//					leftRightRotate(node);
//					node = rotateLeftRight(node);
				}
			}
			else
			{
				if (getHeight(node.right.left) > getHeight(node.right.right))
				{
					System.out.println("************RIGHT LEFT CASE************");
					//Right Left case.
//					node = rotateRightLeft(node);
				}
				else
				{
					System.out.println("************RIGHT RIGHT CASE************");
					//Right Right case.
//					RightLeftRotate(node);
					node = rotateLeft(node);
//					rotateLeft(node);
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
//			try
//			{
//				System.out.println("LEFT Root sent: " + root.data);
//				System.out.println("LEFT left child: " + root.left.data);
//				System.out.println("LEFT right child: " + root.right.data);
//				System.out.println("LEFT Root parent: " + root.parent);
//				
//			}
//			catch (NullPointerException e)
//			{
//				System.out.println("Couldn't find an ancestor.");
//			}

			//The actual rotation of Nodes
			Node temp = root.right;
			root.right = temp.left;
			temp.left = root;
			System.out.println("Switch complete.");
			
			//Updating parent variables
			temp.left.parent = root;
			System.out.println("Parent fixes complete.");
			
			return temp;
		}
		
		/*
		 * Rotates the Grandparent clockwise around the
		 * parent.
		 * @param root Node (Grandparent)
		 */
		private Node rotateRight(Node root)
		{
//			try
//			{
//				
//			System.out.println("RIGHT Root sent: " + root.data);
//			System.out.println("RIGHT left child: " + root.left.data);
//			System.out.println("RIGHT left left child: " + root.left.left.data);
//			System.out.println("RIGHT right child: " + root.right.data);
//			System.out.println("RIGHT Root parent: " + root.parent);
//
//			}
//			catch (NullPointerException e)
//			{
//				System.out.println("Couldn't find an ancestor.");
//			}
			
			Node temp = root.left;
			root.left = temp.right;
			temp.right = root;
			System.out.println("Switch complete.");
			
			//Updating parent variables
			temp.right.parent = root;
			System.out.println("Parent fixes complete.");
			return temp;
		}
		
//		private Node rotateRightLeft(Node root)
//		{
//			root.right = rotateRight(root.right);
//			
//			return rotateLeft(root);
//			
//		}
//		private Node rotateLeftRight(Node root)
//		{
//			root.left = rotateLeft(root.left);
//			
//			return rotateRight(root);
//			
//		}
		
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
//				System.out.println("inOrderTraversal Complete.");
				return;
			}
				inOrderTraversal(root.left);
			System.out.println(root.data);
				inOrderTraversal(root.right);
		}
		
		public List<String> getTestingOutput()
		{
			getInOrderTraversal(root);
			return output;
		}
		
		private void getInOrderTraversal(Node root)
		{
			if (root == null)
			{
				return;
			}
				inOrderTraversal(root.left);
			System.out.println(root.data);
			output.add(root.data);
				inOrderTraversal(root.right);
				
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
