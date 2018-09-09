/**
 * Punnett Me is an app to use for Punnett Squares for Genetic Trait Calculations.
 * You can calculate up to 5 different traits at once.
 * You can quickly change from Homozygous parents and Heterozygous parents 
 * for comparisons.
 * 
 * Uses Design by Contract programming.
 * 
 * Parent:  
 * Represents a parent, to keep
 * the raw genes input by the user, 
 * store calculated Alleles and 
 * their Combinations.
 * Finally, used to build the Punnett Square 
 * 
 * Scott Smalley, BS Software Engineering student at Utah Valley University
 * Fall 2020 expected graduation
 * scottsmalley90@gmail.com
 * 
 * @author Scott Smalley
 */
package punnettme;

public class Parent 
{
	//Raw genes haven't been turned into combinations for Punnett Square.
	private Gene[] rawGenes;
	
	//The different alleles from each gene we're looking at.
	private String alleles;
	
	//The combinations made from the rawGenes and the alleles.
	private String[] geneCombinations;
	
	/**
	 * Constructor
	 */
	public Parent()
	{
		//Initiates the rawGenes Array.
		rawGenes = new Gene[5];
	}
	
	/**
	 * Get method for the raw genes Gene[] 
	 * 
	 * @return rawGenes Gene[]
	 */
	public Gene[] getRawGenes()
	{
		return rawGenes;
	}
	
	/**
	 * Set method for the raw genes Gene[] 
	 * 
	 * @param newGenes Gene[]
	 */
	public void setRawGenes(Gene[] newGenes)
	{
		rawGenes = newGenes;
	}
	
	/**
	 * Get method to get the gene combinations String[] 
	 * 
	 * @return geneCombinations String[]
	 */
	public String[] getGeneCombinations()
	{
		return geneCombinations;
	}
	
	/**
	 * Set method for the gene combinations String[] 
	 * 
	 * @param geneCombinations String[]
	 */
	public void setGeneCombinations(String[] geneCombinations)
	{
		this.geneCombinations = geneCombinations;
	}
	
	/**
	 * Get method for the alleles 
	 * 
	 * @return alleles String
	 */
	public String getAlleles()
	{
		return alleles;
	}
	
	/**
	 * Set method for the alleles 
	 * 
	 * @param alleles String
	 */
	public void setAlleles(String alleles)
	{
		this.alleles = alleles;
	}
	
}
