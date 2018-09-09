/**
 * Punnett Me is an app to use for Punnett Squares for Genetic Trait Calculations.
 * You can calculate up to 5 different traits at once.
 * You can quickly change from Homozygous parents and Heterozygous parents 
 * for comparisons.
 * 
 * Uses Design by Contract programming.
 * 
 * Gene:  
 * Represents a gene, to keep the symbol, 
 * and what type of allele types. For example
 * a Gene has symbol 'A', and if isHeterozygous 
 * means the allele type shows Aa. Used by the
 * Parent objects for use in punnett squares.
 * 
 * Scott Smalley, BS Software Engineering student at Utah Valley University
 * Fall 2020 expected graduation
 * scottsmalley90@gmail.com
 * 
 * @author Scott Smalley
 */
package punnettme;

public class Gene 
{
	//The assigned character to represent the gene.
	private String symbol;
	
	//Ex Aa
	private boolean isHeterozygous;
	
	//Ex AA
	private boolean isHomozygousDominant;
	
	//Ex aa
	private boolean isHomozygousRecessive;
	
	/**
	 * Constructor
	 * 
	 * @param symbol String
	 * @param isHeterozygous boolean
	 * @param isHomozygousDominant boolean
	 * @param isHomozygousRecessive boolean
	 */
	public Gene(String symbol, boolean isHeterozygous, boolean isHomozygousDominant, boolean isHomozygousRecessive)
	{
		this.symbol = symbol.toUpperCase();
		this.isHeterozygous = isHeterozygous;
		this.isHomozygousDominant = isHomozygousDominant;
		this.isHomozygousRecessive = isHomozygousRecessive;
	}
	
	/**
	 * Get method for the Gene Symbol
	 * 
	 * @return symbol String
	 */
	public String getName()
	{
		return symbol;
	}
	
	/**
	 * Get boolean if Gene is Heterozygous
	 * 
	 * @return isHeterozygous boolean
	 */
	public boolean getHeterozygous()
	{
		return isHeterozygous;
	}
	
	/**
	 * Get boolean if Gene is Homozygous Dominant 
	 * 
	 * @return isHomozygousDominant boolean
	 */
	public boolean getHomozygousDominant()
	{
		return isHomozygousDominant;
	}
	
	/**
	 * Get boolean if Gene is Homozygous Recessive
	 * 
	 * @return isHomozygousRecessive boolean
	 */
	public boolean getHomozygousRecessive()
	{
		return isHomozygousRecessive;
	}
}
