/*
 * Punnett Me is an app to use for Punnett Squares for Genetic Trait Calculations.
 * You can calculate up to 5 different traits at once.
 * You can quickly change from Homozygous parents and Heterozygous parents 
 * for comparisons.
 * 
 * Uses Model View Controller design pattern, with Design by Contract programming.
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
 */
package punnettme;

public class Parent 
{
	private Gene[] rawGenes;
	private String alleles;
	private String[] geneCombinations;
	
	
	public Parent()
	{
		rawGenes = new Gene[5];
	}
	
	public Gene[] getRawGenes()
	{
		return rawGenes;
	}
	
	public void setRawGenes(Gene[] newGenes)
	{
		rawGenes = newGenes;
	}
	
	public String[] getGeneCombinations()
	{
		return geneCombinations;
	}
	
	public void setGeneCombinations(String[] geneCombinations)
	{
		this.geneCombinations = geneCombinations;
	}
	
	public String getAlleles()
	{
		return alleles;
	}
	
	public void setAlleles(String alleles)
	{
		this.alleles = alleles;
	}
	
}
