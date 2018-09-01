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
