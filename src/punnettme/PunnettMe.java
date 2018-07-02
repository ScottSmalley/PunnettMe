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

import javax.swing.SwingUtilities;

public class PunnettMe implements Runnable
{
	private Parent parentOne;
	private Parent parentTwo;
	private List<String> offspring = new ArrayList<>();
	private AVLTree tree;
	//private Node root;

	public static void main (String [] args)
	{
		SwingUtilities.invokeLater(new PunnettMe());
	}
	
	public void run() 
	{
		tree = new AVLTree();
//		parentOne = new Parent();
//		parentTwo = new Parent();
		
//		parentOne.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false), 
//				new Gene("B", true, false, false),
//				new Gene("C", true, false, false),
//				new Gene("D", true, false, false),
//				new Gene("E", true, false, false)});
//
//		parentTwo.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false), 
//				new Gene("B", true, false, false),
//				new Gene("C", true, false, false),
//				new Gene("D", true, false, false),
//				new Gene("E", true, false, false)});

//				parentOne.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false), 
//				new Gene("B", true, false, false),
//				new Gene("C", true, false, false),
//				new Gene("D", true, false, false)});
//
//		parentTwo.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false), 
//				new Gene("B", true, false, false),
//				new Gene("C", true, false, false),
//				new Gene("D", true, false, false)});
		
//		parentOne.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false), 
//				new Gene("B", true, false, false),
//				new Gene("C", true, false, false)});
//
//		parentTwo.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false), 
//				new Gene("B", true, false, false),
//				new Gene("C", true, false, false)});

//		parentOne.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false), 
//				new Gene("B", true, false, false)});
//
//		parentTwo.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false), 
//				new Gene("B", true, false, false)});

//		parentOne.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false)});
//
//		parentTwo.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false)});

		
		
//		Gene[] parentOneTest = parentOne.getRawGenes();
//		for (Gene g: parentOneTest)
//		{
//			System.out.println(g.getName());
//		}
//
//		System.out.println();
//
//		Gene[] parentTwoTest = parentTwo.getRawGenes();
//		for (Gene g: parentTwoTest)
//		{
//			System.out.println(g.getName());
//		}
		
		parentOne.setAlleles(buildAlleles(parentOne.getRawGenes()));
		parentTwo.setAlleles(buildAlleles(parentTwo.getRawGenes()));
		
//		System.out.println(parentOne.getAlleles());
//		System.out.println(parentTwo.getAlleles());
		
		parentOne.setGeneCombinations(buildAlleleCombinations(parentOne.getAlleles()));
		parentTwo.setGeneCombinations(buildAlleleCombinations(parentTwo.getAlleles()));
	
//		for (String g: (String[])parentOne.getGeneCombinations())
//		{
//			System.out.println(g);
//		
//		}
//		for (String g: (String[])parentTwo.getGeneCombinations())
//		{
//			System.out.println(g);
//			
//		}
		
//		System.out.println(scoreResult("AABBCCDDEE"));
//		System.out.println(scoreResult("AaBbCCDdEE"));
//		System.out.println(scoreResult("aabbccddee"));
		
		buildPunnettSquare(parentOne.getGeneCombinations(), parentTwo.getGeneCombinations());
		
		System.out.println("PROGRAM COMPLETE, IN ORDER TRAVERSAL: ");
		tree.inOrderTraversal();
		//System.out.println("Height of Root: " + getHeight(root));
		
	}
	
	public void setParents(Parent parentOne, Parent parentTwo)
	{
		this.parentOne = parentOne;
		this.parentTwo = parentTwo;
		
	}
	
	public List<String> getOffspring()
	{
		return offspring;
	}
	
	/*
	 * Builds the Alleles for all the genes in the array.
	 * Checks the boolean values for each gene to indicate
	 * which type of Alleles should be expressed. Then
	 * it concatenates them into one string. 
	 * 
	 */
	public String buildAlleles(Gene[] rawGenes)
	{
		String alleles = "";
		for (int index = 0; index < rawGenes.length; index++)
		{
			if (rawGenes[index] != null)
			{
				if (rawGenes[index].getHeterozygous())
				{
//					System.out.println("Hetero");
					alleles += rawGenes[index].getName().toUpperCase();
					alleles += rawGenes[index].getName().toLowerCase();
				}
				else if (rawGenes[index].getHomozygousDominant())
				{
//					System.out.println("HomoD");
					alleles += rawGenes[index].getName().toUpperCase();
					alleles += rawGenes[index].getName().toUpperCase();
				}
				else if (rawGenes[index].getHomozygousRecessive())
				{
//					System.out.println("HomoR");
					alleles += rawGenes[index].getName().toLowerCase();
					alleles += rawGenes[index].getName().toLowerCase();
				}
				else
				{
//					System.out.println("ERROR ALL BOOL TYPES ARE FALSE");
				}
			}
			
		}
		return alleles;
	}
	
	/*
	 * Takes in a String of characters representing Genes in 
	 * order of Dominant to recessive. Capital letters indicate
	 * dominant genes, conversely lower case letters indicate 
	 * recessive genes.
	 * 2 letters per gene, up to 5 genes.
	 * Must be same 2 letters for each gene (i.e. Aa, AA, or aa)
	 * 
	 * 
	 * @param parent, String
	 * @return combinations, String[]
	 */
	public String[] buildAlleleCombinations(String alleles)
	{
		String[] result = new String[1];
		if (alleles.length() == 2)
		{
//			System.out.println("2");
			result = new String[]{alleles.substring(0, 1), alleles.substring(1, 2)};
		}
		//Greater/equal to 4 & less/equal to 10 & even.
		else if (alleles.length() >= 4 && alleles.length() <= 10 && alleles.length() % 2 == 0)
		{
//			System.out.println("longer");
			String tempAlleles = alleles;
			result =  buildAlleleCombinations(result, tempAlleles);
		}
//		System.out.println("NONE");
		return result;
		
	}
	/*
	 * Recursive method used by the public overload to build the resulting strings of
	 * combinations.
	 * 
	 * @param result, String[]
	 * @param parent, String
	 * 
	 * @return result, String[]
	 */
	private String[] buildAlleleCombinations(String[] result, String alleles)
	{
		if (!(alleles.equals("")))
		{
			String[] newCombinations = new String[2 * result.length];
			int newCombinationsCtr = 0;
			
			for (int i = 0; i < result.length; i++)
			{
				if (result[i] != null)
				{
					newCombinations[newCombinationsCtr] = result[i] + alleles.substring(0, 1);
					newCombinations[newCombinationsCtr+1] = result[i] + alleles.substring(1, 2);
				}
				else
				{
					newCombinations[newCombinationsCtr] = alleles.substring(0, 1);
					newCombinations[newCombinationsCtr+1] = alleles.substring(1, 2);
				}
				newCombinationsCtr += 2;
			}
			String updatedParent = alleles.substring(2);
			return buildAlleleCombinations(newCombinations, updatedParent);
		}
		return result;
	}
	
	
	public void buildPunnettSquare(String[] parentOne, String[] parentTwo)
	{
		//Cycle thru parentOne
		for (int i = 0; i < parentOne.length; i++)
		{
			//Cycle thru parentTwo
			for (int j = 0; j < parentTwo.length; j++)
			{
				String result =	buildPunnettSquare("", parentOne[i], parentTwo[j]);
				offspring.add(result);
				tree.storeInTree(result);
			}
		}
	}
	
	private String buildPunnettSquare(String result, String parentOne, String parentTwo)
	{
		if (!(parentOne.length() == 0 && parentTwo.length() == 0))
		{
			for (int i = 0; i < parentOne.length() && i < parentTwo.length(); i++)
			{
				//order only matters if parentTwo's char is upper case.
				if (Character.isUpperCase(parentTwo.charAt(i)))
				{
					result += parentTwo.charAt(i);
					result += parentOne.charAt(i);
				}
				else
				{
					result += parentOne.charAt(i);
					result += parentTwo.charAt(i);
				}
			}
			buildPunnettSquare(result, parentOne.substring(1), parentTwo.substring(1));
		}
		return result;
	}
	
//	//give the string a value
//	/*
//	 * scores are 2x the position, so if 5 genes, Capital in the first
//	 * position is 10, then 9, 8, 7....
//	 * 
//	 */
//	public int scoreResult(String result)
//	{
////		System.out.println("result.length: " + result.length());
//		int score = 0;
//		
//		for (int i = 0; i < result.length(); i++)
//		{
//			if (Character.isUpperCase(result.charAt(i)))
//			{
////				System.out.println("IT'S UPPER CASE!!! score: " + (result.length() - i));
//				score += result.length() - i;
//			}
//		}
//		return score;
//	}
//	
//	
//	
//	//enter into AVL tree
//	/*
//	 * Node class
//	 * 
//	 * Need left/right/clockwise rotation methods
//	 * Need insert method
//	 * 
//	 * connections from root to leaves
//	 */
//	public void storeInTree(int score, String data)
//	{
//		if (root != null)
//		{
//			//In case root and score are dups
//			if (score == root.score)
//			{
//				System.out.println("DUPLICATE ROOT SCORE");
//				root.duplicate++;
//			}
//			else
//			{
//				if (!traverseForDuplicates(score, root, false))
//				{
////					System.out.println("No Duplicates");
//					insert(new Node(score, data), root);
//				}
//			}
//		}
//		else 
//		{
//			root = new Node(score, data);
//		}
//	}
//	
//	
//	private boolean traverseForDuplicates(int score, Node root, boolean hasDuplicate)
//	{
//		if (root.left != null)
//		{
//			if (!(root.left.score == score))
//			{
//				traverseForDuplicates(score, root.left, hasDuplicate);
//			}
//			else
//			{
//				root.left.duplicate++;
//				hasDuplicate = true;
////				System.out.println("Duplicate Score FOUND: " + score);
//			}
//		}
//		else if (root.right != null)
//		{
//			if (!(root.right.score == score))
//			{
//				traverseForDuplicates(score, root.right, hasDuplicate);
//			}
//			else
//			{
//				root.right.duplicate++;
//				hasDuplicate = true;
////				System.out.println("Duplicate Score FOUND: " + score);
//			}
//		}
//		return hasDuplicate;
//	}
//	
//	/*
//	 * Is used only if root != null && no duplicates
//	 * places in descending order
//	 */
//	private void insert(Node newNode, Node root)
//	{
//		//Small on the right
//		if (newNode.score > root.score)
//		{
//			if (root.left != null)
//			{
//				insert(newNode, root.left);
//			}
//			else
//			{
//				root.left = newNode;
//				newNode.parent = root;
//				newNode.height = root.height + 1;
//				
//			}
//		}
//		//Large on the left
//		else if (newNode.score < root.score)
//		{
//			if (root.right != null)
//			{
//				insert(newNode, root.right);
//			}
//			else
//			{
//				root.right = newNode;
//				newNode.parent = root;
//				newNode.height = root.height + 1;
//			}
//		}
//
//	}
//	
//	
//	/*
//	 * NEED TO:
//	 * FIND METHOD FOR CHECKING EACH SIDE FOR BALANCING
//	 * CREATE ROTATE LEFT & ROTATE RIGHT METHODS
//	 * 5/4/2018
//	 * 
//	 * 
//	 */
//	private int getHeight(Node root)
//	{
//		if (root == null)
//		{
//			return -1;
//		}
//		
//		int leftH = getHeight(root.left);
//		int rightH = getHeight(root.right);
//		
//		if (rightH > leftH)
//		{
//			return rightH + 1;
//		}
//		else
//		{
//			return leftH +1;
//		}
//	}
//	
//	private void rotateLeft()
//	{
//		
//	}
//	private void rotateRight()
//	{
//		
//	}
//	private class Node
//	{
//		private int score, height, duplicate;
//		private String data;
//		private Node parent, left, right;
//		
//		private Node(int score, String data)
//		{
//			this.score = score;
//			this.data = data;
//			height = 1;
//			duplicate = 0;
//		}
//	}
	
}











//public class PunnettMe implements Runnable
//{
//	//Given the gene types, the raw original gene expressions.
//	private String parentOne;
//	private String parentTwo;
//	
//	//Given the gene types, the combinations of all the traits together.
//	private String[] parentOneCombinations;
//	private String[] parentTwoCombinations;
//	
//	//Hetero, Homo Dominant, or Homo Recessive expression of the genes.
//	private boolean[][] parentOneGeneType;
//	private boolean[][] parentTwoGeneType;
//	
//	private String[] inputTraits = new String[5];
//	
//	public static void main(String[] args) 
//	{
//		SwingUtilities.invokeLater(new PunnettMe());
//	}
//	
//	/*
//	 * Initiates the application.
//	 * 
//	 * @param NONE
//	 * 
//	 * @return NONE
//	 */
//	public void run() 
//	{
//		/*
//		 * Build UI
//		 * Have JTFx5 for Parent One with matching Drop down for Hetero/HomoD/HomoR.
//		 * Have JTFx5 for Parent Two
//		 * 		Have the last 4 boxes of each grayed out, as I add info, open up more boxes.
//		 * 
//		 *  
//		 */
//		
//		Parent parentJuan = new Parent(parentOne);
//		System.out.println(parentJuan.getRawGenes());
//		
//		Parent parentToo = new Parent(parentTwo);
//		System.out.println(parentToo.getRawGenes());
//		
//		
//		
//		
////		parentOne = buildParent(parentOneGeneType,  inputTraits);
////		parentTwo = buildParent(parentTwoGeneType,  inputTraits);
//		
////		parentOneCombinations = buildAlleleCombinations(parentOne);
////		parentTwoCombinations = buildAlleleCombinations(parentOne);
//		
//		
//		
//	}
//	
//	
//	public String[] buildPunnettSquare(String[] parentOneCombinations, String[] parentTwoCombinations)
//	{
//		/*
//		 * For loop thru parent one
//		 * on each loop, for loop through parent two and combined them into new array.
//		 * For loop through the letters, check for a uppercase/lowercase combo--place 
//		 * 	the upper before the lower, else just place them both in there.
//		 * use the 2x system based on the length of the arrays. Square the length
//		 * for the resulting array.
//		 * 
//		 * Am i missing anything?
//		 * Optimization? only on 1024 items?
//		 * 
//		 */
//		
//		return null;
//	}
//	
//	
//	/*
//	 * Takes in a String of characters representing Genes in 
//	 * order of Dominant to recessive. Capital letters indicate
//	 * dominant genes, conversely lower case letters indicate 
//	 * recessive genes.
//	 * 2 letters per gene, up to 5 genes.
//	 * Must be same 2 letters for each gene (i.e. Aa, AA, or aa)
//	 * 
//	 * 
//	 * @param parent, String
//	 * @return combinations, String[]
//	 */
//	public String[] buildAlleleCombinations(String parent)
//	{
//		String[] result = new String[1];
//		if (parent.length() == 2)
//		{
//			System.out.println("2");
//			result = new String[] {parent.substring(0, 1), parent.substring(1, 2)};
//		}
//		else if (parent.length() >= 4 && parent.length() <= 10 && parent.length() % 2 == 0)
//		{
//			String parentTraits = parent;
//			result =  buildAlleleCombinations(result, parentTraits);
//		}
//		return result;
//		
//	}
//	/*
//	 * Recursive method used by the public overload to build the resulting strings of
//	 * combinations.
//	 * 
//	 * @param result, String[]
//	 * @param parent, String
//	 * 
//	 * @return result, String[]
//	 */
//	private String[] buildAlleleCombinations(String[] result, String parent)
//	{
//		if (!(parent.equals("")))
//		{
//			String[] newCombinations = new String[2 * result.length];
//			int newCombinationsCtr = 0;
//			
//			for (int i = 0; i < result.length; i++)
//			{
//				if (result[i] != null)
//				{
//					newCombinations[newCombinationsCtr] = result[i] + parent.substring(0, 1);
//					newCombinations[newCombinationsCtr+1] = result[i] + parent.substring(1, 2);
//				}
//				else
//				{
//					newCombinations[newCombinationsCtr] = parent.substring(0, 1);
//					newCombinations[newCombinationsCtr+1] = parent.substring(1, 2);
//				}
//				newCombinationsCtr += 2;
//			}
//			String updatedParent = parent.substring(2);
//			return buildAlleleCombinations(newCombinations, updatedParent);
//		}
//		return result;
//	}
//	
//	/*
//	 * Builds the Original Parent by taking the Gene Types and the 
//	 * Input Traits and builds out the parent String.
//	 * 
//	 * @param geneType, boolean[][]
//	 * @param inputTraits, String[]
//	 * 
//	 */
//	public String buildParent(boolean[][] geneType, String[] inputTraits)
//	{
//		String parentResult = "";
//		for (int i = 0; (i < geneType.length && inputTraits[i] != null); i++)
//		{
//			//Heterozygous, prints concatenates for "A" gene: Aa
//			if (geneType[i][0])
//			{
//				if (i < 1)
//				{
//					parentResult = inputTraits[i].toUpperCase() + inputTraits[i].toLowerCase();
//				}
//				else
//				{
//					parentResult += inputTraits[i].toUpperCase() + inputTraits[i].toLowerCase();
//				}
//			}
//			//Homozygous
//			else
//			{
//				//Homozygous Dominant, concatenates out for "A" gene: AA
//				if (geneType[i][1])
//				{
//					if (i < 1)
//					{
//						parentResult = inputTraits[i].toUpperCase() + inputTraits[i].toUpperCase();
//					}
//					else
//					{
//						parentResult += inputTraits[i].toUpperCase() + inputTraits[i].toUpperCase();
//					}
//				}
//				//Homozygous Recessive, concatenates out for "A" gene: aa
//				else
//				{
//					if (i < 1)
//					{
//						parentResult = inputTraits[i].toLowerCase() + inputTraits[i].toLowerCase();
//					}
//					else
//					{
//						parentResult += inputTraits[i].toLowerCase() + inputTraits[i].toLowerCase();
//					}
//				}
//			}
//		}
//		return parentResult;
//	}
//	
//	/*
//	 * Returns the Input Traits that were
//	 * entered by the user.
//	 * 
//	 * @param NONE
//	 * 
//	 * @return inputTraits, String[]
//	 */
//	public String[] getInputTraits()
//	{
//		return inputTraits;
//	}
//	
//	/*
//	 * Sets the inputTraits to a new array of traits.
//	 * 
//	 * @param traits, String[]
//	 * 
//	 * @return NONE
//	 */
//	public void setInputTraits(String[] traits)
//	{
//		for (int i = 0; i < traits.length; i++)
//		{
//			inputTraits[i] = traits[i];
//		}
//	}
//	
//	/*
//	 * Returns the boolean values indicating each
//	 * gene's type for Parent One.
//	 * 
//	 * @param NONE
//	 * 
//	 * @return parentOneGeneType, boolean[][]
//	 */
//	public boolean[][] getParentOneGeneType()
//	{
//		return parentOneGeneType;
//	}
//	
//	/*
//	 * Sets the boolean values indicating each
//	 * gene's type for Parent One.
//	 * 
//	 * @param parentOneGeneType, boolean[][]
//	 * 
//	 * @return NONE
//	 */
//	public void setParentOneGeneType(boolean[][] geneType)
//	{
//		parentOneGeneType = geneType;
//	}
//
//	/*
//	 * Returns the boolean values indicating each
//	 * gene's type for Parent Two.
//	 * 
//	 * @param NONE
//	 * 
//	 * @return parentTwoGeneType, boolean[][]
//	 */
//	public boolean[][] getParentTwoGeneType()
//	{
//		return parentTwoGeneType;
//	}
//	
//	/*
//	 * Sets the boolean values indicating each
//	 * gene's type for Parent Two
//	 * 
//	 * @param parentTwoGeneType, boolean[][]
//	 * 
//	 * @return NONE
//	 */
//	public void setParentTwoGeneType(boolean[][] geneType)
//	{
//		parentTwoGeneType = geneType;
//	}
//	
//	/*
//	 * Returns Parent One's original traits.
//	 * 
//	 * @param NONE
//	 * 
//	 * @return parentOne, String
//	 */
//	public String getParentOneTraits()
//	{
//		return parentOne;
//	}
//	
//	/*
//	 * Sets Parent One's original traits.
//	 * 
//	 * @param parentOne, String
//	 * 
//	 * @return NONE
//	 */
//	public void setParentOneTraits(String traits)
//	{
//		parentOne = traits;
//	}
//	
//	/*
//	 * Returns Parent One's Combinations of Gene expression.
//	 *  
//	 * @param NONE
//	 * 
//	 * @return parentOneCombinations, String[]
//	 */
//	public String[] getParentOneCombination()
//	{
//		return parentOneCombinations;
//	}
//	
//	/*
//	 * Sets Parent One's Combinations of Gene expression.
//	 *  
//	 * @param parentOneCombinations, String[]
//	 * 
//	 * @return NONE
//	 */
//	public void setParentOneCombination(String[] parentOneResults)
//	{
//		parentOneCombinations = parentOneResults;
//	}
//	
//	/*
//	 * Returns Parent Two's original traits.
//	 * 
//	 * @param NONE
//	 * 
//	 * @return parentTwo, String
//	 */
//	public String getParentTwoTraits()
//	{
//		return parentTwo;
//	}
//	
//	/*
//	 * Sets Parent Two's original traits.
//	 * 
//	 * @param parentTwo, String
//	 * 
//	 * @return NONE
//	 */
//	public void setParentTwoTraits(String traits)
//	{
//		parentTwo = traits;
//	}
//	
//	/*
//	 * Returns Parent Two's Combinations of Gene expression.
//	 *  
//	 * @param NONE
//	 * 
//	 * @return parentTwoCombinations, String[]
//	 */
//	public String[] getParentTwoCombination()
//	{
//		return parentTwoCombinations;
//	}
//	
//	/*
//	 * Sets Parent Two's Combinations of Gene expression.
//	 *  
//	 * @param parentTwoCombinations, String[]
//	 * 
//	 * @return NONE
//	 */
//	public void setParentTwoCombination(String[] parentTwoResults)
//	{
//		parentTwoCombinations = parentTwoResults;
//	}
//		
//	
//	
//}
