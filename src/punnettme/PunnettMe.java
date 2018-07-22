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

public class PunnettMe 
{
	private Parent parentOne;
	private Parent parentTwo;
	private AVLTree tree;

//	public static void main (String [] args)
//	{
//		SwingUtilities.invokeLater(new PunnettMe());
//	}
	
	public void build(Parent one, Parent two) 
	{
		tree = new AVLTree();
//		parentOne = new Parent();
//		parentTwo = new Parent();
		
		parentOne = one;
		parentTwo = two;
		
		parentOne.setAlleles(buildAlleles(parentOne.getRawGenes()));
		parentTwo.setAlleles(buildAlleles(parentTwo.getRawGenes()));
		
		parentOne.setGeneCombinations(buildAlleleCombinations(parentOne.getAlleles()));
		parentTwo.setGeneCombinations(buildAlleleCombinations(parentTwo.getAlleles()));

		buildPunnettSquare(parentOne.getGeneCombinations(), parentTwo.getGeneCombinations());
		
//		System.out.println("PROGRAM COMPLETE, IN ORDER TRAVERSAL: ");
		tree.inOrderTraversal();
	}
	
//	public void setParents(Parent parentOne, Parent parentTwo)
//	{
//		this.parentOne = parentOne;
//		this.parentTwo = parentTwo;
//		
//	}
	
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
//				offspring.add(result);
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
					result = result + parentTwo.charAt(i);
					result = result + parentOne.charAt(i);
				}
				else
				{
					result = result + parentOne.charAt(i);
					result = result + parentTwo.charAt(i);
				}
			}
			buildPunnettSquare(result, parentOne.substring(1), parentTwo.substring(1));
		}
		return result;
	}
	
	public List<String> getResults()
	{
		return tree.getTestingOutput();
	}
}
