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

public class Gene 
{
	private String name;
	private boolean isHeterozygous;
	private boolean isHomozygousDominant;
	private boolean isHomozygousRecessive;
	
	public Gene(String name, boolean isHeterozygous, boolean isHomozygousDominant, boolean isHomozygousRecessive)
	{
		this.name = name.toUpperCase();
		this.isHeterozygous = isHeterozygous;
		this.isHomozygousDominant = isHomozygousDominant;
		this.isHomozygousRecessive = isHomozygousRecessive;
		
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public boolean getHeterozygous()
	{
		return isHeterozygous;
	}
	
	public boolean getHomozygousDominant()
	{
		return isHomozygousDominant;
	}
	
	public boolean getHomozygousRecessive()
	{
		return isHomozygousRecessive;
	}
}
