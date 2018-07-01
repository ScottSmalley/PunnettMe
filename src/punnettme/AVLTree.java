package punnettme;


public class AVLTree 
{
	Node root;
	
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
					 * increment the counter for that score. 
					 */
					if (!traverseForDuplicates(score, root, false))
					{
//						System.out.println("No Duplicates");
						insert(new Node(score, data), root);
						
//						System.out.println("root left height = " + getHeight(root.left));
//						System.out.println("root right height = " + getHeight(root.right));
//						System.out.println("root.left.height = " + root.left.height);
//						System.out.println("root.right.height = " + root.right.height);
//						int treeBalance = getHeight(root.left) - getHeight(root.right);
//						System.out.println("balance difference between left - right: " + treeBalance);
//						if (treeBalance > 0 )
//						{
//							System.out.println("Tree is out of balance: "  + treeBalance);
//						}
//						System.out.println("Height after insert = " + getHeight(root));
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
//			System.out.println("result.length: " + result.length());
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
//					System.out.println("Duplicate Score FOUND: " + score);
//					System.out.println("Duplicate Amt: " + root.left.duplicate);
//					System.out.println("Duplicate Data: " + root.left.data);
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
//					System.out.println("Duplicate Score FOUND: " + score);
//					System.out.println("Duplicate Amt: " + root.right.duplicate);
//					System.out.println("Duplicate Data: " + root.right.data);
					return true;
				}
			}
			return hasDuplicate;
		}
		
		/*
		 * Is used only if root != null && no duplicates
		 * places in descending order
		 */
		private void insert(Node newNode, Node root)
		{
			//Large on the left
			if (newNode.score > root.score)
			{
				if (root.left != null)
				{
					insert(newNode, root.left);
				}
				else
				{
					root.left = newNode;
					newNode.parent = root;
					root.height = (1 + Math.max(getHeight(root.left), getHeight(root.right)));
					System.out.println("this root's updated height = " + root.height);
					
				}
			}
			//Small on the right
			else if (newNode.score < root.score)
			{
				if (root.right != null)
				{
					insert(newNode, root.right);
				}
				else
				{
					root.right = newNode;
					newNode.parent = root;
					root.height = (1 + Math.max(getHeight(root.left), getHeight(root.right)));
					System.out.println("this root's updated height = " + root.height);
//					int balance = getBalance(root);
//					System.out.println("Right balancing value = " + balance);
//					newNode.height = root.height + 1;
//					System.out.println("newNode height = " + newNode.height);
				}
			}
			
			int balance = getBalance(root);
			System.out.println("balancing value = " + balance);
			
			//Remember! my values are switched, high on the left, low on the right!
			//Left Left Case
			if (balance > 1 && newNode.score > root.left.score)
			{
				rotateRight(root);
			}
			//Left Right Case
			else if (balance > 1 && newNode.score < root.left.score)
			{
//				root.left = leftRotate(node.left)
//				return rightRotate(node)
			}
			//Right Left Case
			else if (balance < -1 && newNode.score > root.right.score)
			{
//				node.right = rightRotate(node.right)
//				return leftRotate(node)
			}
			//Right Right Case
			else if (balance < -1 && newNode.score < root.right.score)
			{
				rotateLeft(root);
			}
			
			
			//Original
//			if (balance > 1 && newNode.score < root.left.score)
//			{
//				
//			}
//			//Left Right Case
//			else if (balance > 1 && newNode.score > root.left.score)
//			{
//				
//			}
//			//Right Left Case
//			else if (balance < -1 && newNode.score < root.right.score)
//			{
//				
//			}
//			//Right Right Case
//			else if (balance < -1 && newNode.score > root.right.score)
//			{
//				
//			}

		}
		
		
		
		private int getHeight(Node root)
		{
			if (root == null)
			{
				return 0;
			}
			return root.height;
			
//			int leftH = getHeight(root.left);
//			int rightH = getHeight(root.right);
//			
//			if (rightH > leftH)
//			{
//				return rightH + 1;
//			}
//			else
//			{
//				return leftH + 1;
//			}
		}
		
		
		private int getBalance(Node root)
		{
			if (root == null)
			{
				return 0;
			}
			return getHeight(root.left) - getHeight(root.right);
		}
		
		private void rotateLeft(Node root)
		{
			
		}
		
		private void rotateRight(Node root)
		{
			
		}
		
		private class Node
		{
			private int score, height, duplicate;
			private String data;
			private Node parent, left, right;
			
			private Node(int score, String data)
			{
				this.score = score;
				this.data = data;
				this.height = 0;
				this.duplicate = 0;
			}
			
			void increment()
			{
				this.duplicate++;
			}
			
		}

}
