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
//					System.out.println("LEFT: " + newNode.data + " Score: " + newNode.score );
					root.left = newNode;
					newNode.parent = root;
//					root.height = (1 + Math.max(getHeight(root.left), getHeight(root.right)));
//					System.out.println("this root's updated height = " + root.height);
					
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
//					System.out.println("RIGHT: " + newNode.data );
					root.right = newNode;
					newNode.parent = root;
//					root.height = (1 + Math.max(getHeight(root.left), getHeight(root.right)));
//					System.out.println("this root's updated height = " + root.height);
//					int balance = getBalance(root);
//					System.out.println("Right balancing value = " + balance);
//					newNode.height = root.height + 1;
//					System.out.println("newNode height = " + newNode.height);
				}
			}
			
//			int balance = checkBalance(newNode);
			checkBalance(newNode);
			
//			System.out.println("balancing value = " + balance);
			
			/*
			 * try catch to grab newNode's grandparent and parent?
			 */
//			if (balance < -1)
//			{
//				System.out.println("Got a left rotation to do!");
//				rotateLeft(root);
//			}
//			else if (balance > 1)
//			{
//				System.out.println("Got a right rotation to do!");
//				rotateRight(root);
//			}
//			
//			//Left Left Case
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
			
//			//Large on the left
//			if (newNode.score > root.score)
//			{
//				if (root.left != null)
//				{
//					insert(newNode, root.left);
//				}
//				else
//				{
//					root.left = newNode;
//					newNode.parent = root;
//					root.height = (1 + Math.max(getHeight(root.left), getHeight(root.right)));
//					System.out.println("this root's updated height = " + root.height);
//					
//				}
//			}
//			//Small on the right
//			else if (newNode.score < root.score)
//			{
//				if (root.right != null)
//				{
//					insert(newNode, root.right);
//				}
//				else
//				{
//					root.right = newNode;
//					newNode.parent = root;
//					root.height = (1 + Math.max(getHeight(root.left), getHeight(root.right)));
//					System.out.println("this root's updated height = " + root.height);
////					int balance = getBalance(root);
////					System.out.println("Right balancing value = " + balance);
////					newNode.height = root.height + 1;
////					System.out.println("newNode height = " + newNode.height);
//				}
//			}
			
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
				
				rebalance(node);
			}
			if (node.parent != null)
			{
				checkBalance(node.parent);
			}

		}
		
		
		/*
		 * NOTES FROM JULY 1 2018:
		 * I NEED TO FIGURE OUT HOW TO GET THE GREAT-GRANDPARENT NODE TO POINT TO TEMP.
		 * WITH THAT, I NEED TO FIGURE OUT HOW TO SET GREAT-GRANDPA LEFT OR RIGHT
		 * NODE TO THE NEW TEMP NODE.... MAYBE CHECK ROOT.PARENT AGAINST EACH
		 * OF GREAT GRANDPA'S LEFT/RIGHT NODES FOR EQUALITY? THEN I KNOW WHICH TO ASSIGN?
		 */
		private void rebalance(Node node)
		{
			if (getHeight(node.left) - getHeight(node.right) > 1)
			{
				if (getHeight(node.left.left) > getHeight(node.left.right))
				{
					System.out.println("************RIGHT ROTATE CALLED************");
					//Left left case.
					node = rotateRight(node);
				}
				else
				{
					System.out.println("************LEFT-RIGHT ROTATE CALLED************");
					//Left Right case.
//					leftRightRotate(node);
					node = rotateLeftRight(node);
				}
			}
			else
			{
				if (getHeight(node.right.left) > getHeight(node.right.right))
				{
					System.out.println("************LEFT ROTATE CALLED************");
					//Right Right case.
					node = rotateLeft(node);
				}
				else
				{
					System.out.println("************RIGHT-LEFT ROTATE CALLED************");
					//Right Left case.
//					RightLeftRotate(node);
					node = rotateRightLeft(node);
				}
			}
			if (node.parent == null)
			{
				root = node;
			}
		}
		
		/*
		 * Rotates the Grandparent counterclockwise around the
		 * parent.
		 * @param root Node (Grandparent)
		 */
		private Node rotateLeft(Node root)
		{
			
			try
			{
//				System.out.println("Grandparent: " + root.data);
//				System.out.println("Grandparent Left Child: " + root.left.data);
//				System.out.println("Grandparent Right Child: " + root.right.data);
//				System.out.println("Parent: " + root.parent.data);
//				System.out.println("Parent Left Child: " + root.parent.left.data);
//				System.out.println("Parent Right Child: " + root.parent.right.data);
//				
////				System.out.println("TEmp's parent: " + temp.);
//				
//				
////				//Grandparent's right child.
////				Node temp = root.parent.right;
////				root.parent.right = temp.left;
////				temp.left = root.parent;
//				
			System.out.println("LEFT Root sent: " + root.data);
			System.out.println("LEFT left child: " + root.left.data);
			System.out.println("LEFT right child: " + root.right.data);
				
			}
			catch (NullPointerException e)
			{
				System.out.println("Couldn't find an ancestor.");
			}

			Node temp = root.right;
			root.right = temp.left;
			temp.left = root;
			if (root.parent != null)
			{
				temp.parent = root.parent;
			}
			try
			{

			System.out.println("LEFT temp's parent:  " + temp.parent.data);
				
			}
			catch (NullPointerException e)
			{
				System.out.println("LEFT Couldn't find parent.");
			}
			
			return temp;
		}
		
		/*
		 * Rotates the Grandparent clockwise around the
		 * parent.
		 * @param root Node (Grandparent)
		 */
		private Node rotateRight(Node root)
		{
			try
			{
//				System.out.println("Grandparent: " + root.parent.parent.data);
//				System.out.println("Grandparent Left Child: " + root.parent.parent.left.data);
//				System.out.println("Grandparent Right Child: " + root.parent.parent.right.data);
//				System.out.println("Parent: " + root.parent.data);
//				System.out.println("Parent Left Child: " + root.parent.left.data);
//				System.out.println("Parent Right Child: " + root.parent.right.data);
//				
//				
//				//Grandparent's right child.
////				Node temp = root.parent.left;
////				root.parent.left = temp.right;
////				temp.right = root.parent;
//				
			System.out.println("RIGHT Root sent: " + root.data);
			System.out.println("RIGHT left child: " + root.left.data);
			System.out.println("RIGHT right child: " + root.right.data);
//				
//				
//				
			}
			catch (NullPointerException e)
			{
				System.out.println("Couldn't find an ancestor.");
			}

			Node temp = root.left;
			root.left = temp.right;
			temp.right = root;
			
			try
			{
				
				System.out.println("RIGHT temp's parent:  " + temp.parent.data);
				
			}
			catch (NullPointerException e)
			{
				System.out.println("RIGHT Couldn't find parent.");
			}
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
		
		public void inOrderTraversal()
		{
			inOrderTraversal(root);
			
		}
		private void inOrderTraversal(Node root)
		{
			if (root == null)
			{
				return;
			}
//			if (root.left != null)
//			{
				inOrderTraversal(root.left);
//			}
			System.out.println(root.data);
//			if (root.right != null)
//			{
				inOrderTraversal(root.right);
//			}
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
				height = 0;
				duplicate = 0;
			}
			
			void increment()
			{
				duplicate++;
			}
			
		}

}
