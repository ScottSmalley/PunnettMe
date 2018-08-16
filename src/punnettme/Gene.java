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
