/**
 * Punnett Me is an app to use for Punnett Squares for Genetic Trait Calculations.
 * You can calculate up to 5 different traits at once.
 * You can quickly change from Homozygous parents and Heterozygous parents 
 * for comparisons.
 * 
 * Uses Design by Contract programming.
 * 
 * Scott Smalley, BS Software Engineering student at Utah Valley University
 * Fall 2020 expected graduation
 * scottsmalley90@gmail.com
 * 
 * @author Scott Smalley
 */
package punnettme;

import java.util.List;

public class PunnettMeCalculations 
{
	private Parent parentOne;
	private Parent parentTwo;
	private OffspringTree tree;

	/**
	 * Initiates the Offspring AVL Tree,
	 * Initiates both parents, sets the Alleles by calling
	 * the RawGenes from the arguments given. Builds PunnettSquare
	 * after calculation.
	 * 
	 * @param one Parent
	 * @param two Parent
	 */
	public void build(Parent one, Parent two) 
	{
		tree = new OffspringTree();

		parentOne = one;
		parentTwo = two;
		
		parentOne.setAlleles(buildParentAlleles(parentOne.getRawGenes()));
		parentTwo.setAlleles(buildParentAlleles(parentTwo.getRawGenes()));
		
		//Takes the Alleles from the parent and builds the combinations between
		//those Alleles. 
		//Ex. AaBb = AB, Ab, aB, ab
		parentOne.setGeneCombinations(buildParentAlleleCombinations(parentOne.getAlleles()));
		parentTwo.setGeneCombinations(buildParentAlleleCombinations(parentTwo.getAlleles()));

		//Takes the Allele Combinations from above and builds the punnett square from them.
		buildOffspring(parentOne.getGeneCombinations(), parentTwo.getGeneCombinations());
	}
	
	/**
	 * Builds the Alleles for all the genes in the array.
	 * Checks the boolean values for each gene to indicate
	 * which type of Alleles should be expressed. Then
	 * it concatenates them into one string. 
	 * For example, if a Parent has two genes, represented by
	 * 'a' and 'b'. If both genes are Heterozygous, they would
	 * express as AaBb, Homozygous Dominant would be AABB, and
	 * Homozygous Recessive would be aabb. 
	 * 
	 * @param rawGenes Gene[]
	 * @return result String
	 */
	private String buildParentAlleles(Gene[] rawGenes)
	{
		String alleles = "";
		for (int rawGeneCycle = 0; rawGeneCycle < rawGenes.length; rawGeneCycle++)
		{
			if (rawGenes[rawGeneCycle] != null)
			{
				if (rawGenes[rawGeneCycle].getHeterozygous())
				{
					alleles += rawGenes[rawGeneCycle].getName().toUpperCase();
					alleles += rawGenes[rawGeneCycle].getName().toLowerCase();
				}
				else if (rawGenes[rawGeneCycle].getHomozygousDominant())
				{
					alleles += rawGenes[rawGeneCycle].getName().toUpperCase();
					alleles += rawGenes[rawGeneCycle].getName().toUpperCase();
				}
				else if (rawGenes[rawGeneCycle].getHomozygousRecessive())
				{
					alleles += rawGenes[rawGeneCycle].getName().toLowerCase();
					alleles += rawGenes[rawGeneCycle].getName().toLowerCase();
				}
			}
		}
		
		return alleles;
	}
	
	/**
	 * Takes in a String of characters representing Genes in 
	 * order of Dominant to recessive. Capital letters indicate
	 * dominant genes, lower case letters indicate recessive genes.
	 * 2 letters per gene, up to 5 genes.
	 * Must be same 2 letters for each gene (i.e. Aa, AA, or aa)
	 * 
	 * @param alleles String
	 * @return combinations String[]
	 */
	private String[] buildParentAlleleCombinations(String alleles)
	{
		//Default value
		String[] result = new String[1];

		//If only one Gene, two letters per Gene.
		if (alleles.length() == 2)
		{
			result = new String[]{alleles.substring(0, 1), alleles.substring(1, 2)};
		}
		
		//Between two to five Genes, two letters per Gene.
		else if (alleles.length() >= 4 && alleles.length() <= 10 && alleles.length() % 2 == 0)
		{
			String tempAlleles = alleles;
			result =  buildParentAlleleCombinations(result, tempAlleles);
		}

		return result;
	}
	
	/**
	 * Recursive overloaded method to crawl through the alleles String,
	 * process two letters--corresponding to a Gene, add them to the new
	 * String[] to make sure any aA gets changed to Aa. Then removes the
	 * two letters it just processed and recurse.
	 * 
	 * @param results String[]
	 * @param alleles String
	 * @return combinations String[]
	 */
	private String[] buildParentAlleleCombinations(String[] results, String alleles)
	{
		if (!(alleles.equals("")))
		{
			String[] newAlleleCombinations = new String[2 * results.length];
			int newAlleleCombinationsCtr = 0;
			
			for (int i = 0; i < results.length; i++)
			{
				if (results[i] != null)
				{
					newAlleleCombinations[newAlleleCombinationsCtr] = results[i] + alleles.substring(0, 1);
					newAlleleCombinations[newAlleleCombinationsCtr+1] = results[i] + alleles.substring(1, 2);
				}
				else
				{
					newAlleleCombinations[newAlleleCombinationsCtr] = alleles.substring(0, 1);
					newAlleleCombinations[newAlleleCombinationsCtr+1] = alleles.substring(1, 2);
				}
				newAlleleCombinationsCtr += 2;
			}
			String updatedParent = alleles.substring(2);
			
			return buildParentAlleleCombinations(newAlleleCombinations, updatedParent);
		}
		
		return results;
	}
	
	/**
	 * Builds a Punnett Square with the results String[] from buildAlleleCombinations.
	 * The Punnett Square is a square with each Combination of one parent on the X axis,
	 * and each combination of the other parent on the Y axis. Going row by row checking for
	 * any upper case characters, as they represent dominant alleles. 
	 * If there's one dominant allele, it needs to be the first letter. Otherwise, the letter case
	 * doesn't matter, so it adds to the current String. As it recurses, it goes deeper into the
	 * Punnett Square, adding the combinations to the end of the String result. For example, if you
	 * have combinations Ab and AB, the result comes out as AABb.  
	 * 
	 * @param parentOne String[]
	 * @param parentTwo String[]
	 */
	private void buildOffspring(String[] parentOne, String[] parentTwo)
	{
		//Cycle thru parentOne
		for (int i = 0; i < parentOne.length; i++)
		{
			//Cycle thru parentTwo
			for (int j = 0; j < parentTwo.length; j++)
			{
				//Build the offpsring, then send it to the AVL Tree to storage.
				String result =	buildOffspring("", parentOne[i], parentTwo[j]);
				tree.storeInTree(result);
			}
		}
	}
	
	/**
	 * Recursive overload to work through the PunnettSquare
	 * 
	 * @param result String
	 * @param parentOne String
	 * @param parentTwo String
	 * @return result String
	 */
	private String buildOffspring(String result, String parentOne, String parentTwo)
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
			buildOffspring(result, parentOne.substring(1), parentTwo.substring(1));
		}
		return result;
	}
	
	/**
	 * Calls getOffspring() to get an ArrayList
	 * of sorted offspring from the AVL Tree.
	 * 
	 * @return offspring List
	 */
	public List<String> getResults()
	{
		return tree.getOffspring();
	}
}
