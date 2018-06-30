package punnettme;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PunnettMeTest {

	@Test
	void heteroBuildPunnettSquareResultsAccuracyWithOneGene() 
	{
		PunnettMe pm = new PunnettMe();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
		new Gene("A", true, false, false)});

		parentTwo.setRawGenes(new Gene[] {
		new Gene("A", true, false, false)});
		
		pm.setParents(parentOne, parentTwo);
		pm.run();
		
		String[] sample = new String[] {
				("AA"),("Aa"),("Aa"),("aa")};
		
		String[] test = new String[pm.getOffspring().size()];
		for (int i = 0; i < test.length; i++)
		{
			test[i] = pm.getOffspring().get(i);
		}
		assertArrayEquals(sample, test);
	}
	
	@Test
	void heteroBuildPunnettSquareResultsAccuracyWithTwoGenes() 
	{
		PunnettMe pm = new PunnettMe();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", true, false, false),
				new Gene("B", true, false, false)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", true, false, false),
				new Gene("B", true, false, false)});
		
		pm.setParents(parentOne, parentTwo);
		pm.run();
		
		String[] sample = new String[] {
				("AABB"),("AABb"),("AaBB"),("AaBb"),
				("AABb"),("AAbb"),("AaBb"),("Aabb"),
				("AaBB"),("AaBb"),("aaBB"),("aaBb"),
				("AaBb"),("Aabb"),("aaBb"),("aabb")};
		
		String[] test = new String[pm.getOffspring().size()];
		for (int i = 0; i < test.length; i++)
		{
			test[i] = pm.getOffspring().get(i);
		}
		assertArrayEquals(sample, test);
	}
	
	@Test
	void heteroBuildPunnettSquareResultsAccuracyWithThreeGenes()  
	{
		PunnettMe pm = new PunnettMe();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", true, false, false),
				new Gene("B", true, false, false),
				new Gene("C", true, false, false)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", true, false, false),
				new Gene("B", true, false, false),
				new Gene("C", true, false, false)});
		
		pm.setParents(parentOne, parentTwo);
		pm.run();
		
		String[] sample = new String[] {
				("AABBCC"),("AABBCc"),("AABbCC"),("AABbCc"),("AaBBCC"),("AaBBCc"),("AaBbCC"),("AaBbCc"),
				("AABBCc"),("AABBcc"),("AABbCc"),("AABbcc"),("AaBBCc"),("AaBBcc"),("AaBbCc"),("AaBbcc"),
				("AABbCC"),("AABbCc"),("AAbbCC"),("AAbbCc"),("AaBbCC"),("AaBbCc"),("AabbCC"),("AabbCc"),
				("AABbCc"),("AABbcc"),("AAbbCc"),("AAbbcc"),("AaBbCc"),("AaBbcc"),("AabbCc"),("Aabbcc"),
				("AaBBCC"),("AaBBCc"),("AaBbCC"),("AaBbCc"),("aaBBCC"),("aaBBCc"),("aaBbCC"),("aaBbCc"),
				("AaBBCc"),("AaBBcc"),("AaBbCc"),("AaBbcc"),("aaBBCc"),("aaBBcc"),("aaBbCc"),("aaBbcc"),
				("AaBbCC"),("AaBbCc"),("AabbCC"),("AabbCc"),("aaBbCC"),("aaBbCc"),("aabbCC"),("aabbCc"),
				("AaBbCc"),("AaBbcc"),("AabbCc"),("Aabbcc"),("aaBbCc"),("aaBbcc"),("aabbCc"),("aabbcc")};
				
		String[] test = new String[pm.getOffspring().size()];
		for (int i = 0; i < test.length; i++)
		{
			test[i] = pm.getOffspring().get(i);
		}
		assertArrayEquals(sample, test);
	}
	
	@Test
	void heteroBuildPunnettSquareResultsAccuracyWithFourGenes() 
	{
		PunnettMe pm = new PunnettMe();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", true, false, false),
				new Gene("B", true, false, false),
				new Gene("C", true, false, false),
				new Gene("D", true, false, false)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", true, false, false),
				new Gene("B", true, false, false),
				new Gene("C", true, false, false),
				new Gene("D", true, false, false)});
		
		pm.setParents(parentOne, parentTwo);
		pm.run();
		
		String[] sample = new String[] 	{
				("AABBCCDD"),("AABBCCDd"),("AABBCcDD"),("AABbCCDD"),("AABBCcDd"),("AABbCcDD"),("AABbCCDd"),("AABbCcDd"),
					("AaBBCCDD"),("AaBBCCDd"),("AaBBCcDD"),("AaBbCCDD"),("AaBBCcDd"),("AaBbCcDD"),("AaBbCCDd"),("AaBbCcDd"),
				("AABBCCDd"),("AABBCCdd"),("AABBCcDd"),("AABbCCDd"),("AABBCcdd"),("AABbCcDd"),("AABbCCdd"),("AABbCcdd"),
					("AaBBCCDd"),("AaBBCCdd"),("AaBBCcDd"),("AaBbCCDd"),("AaBBCcdd"),("AaBbCcDd"),("AaBbCCdd"),("AaBbCcdd"),
				("AABBCcDD"),("AABBCcDd"),("AABBccDD"),("AABbCcDD"),("AABBccDd"),("AABbccDD"),("AABbCcDd"),("AABbccDd"),
					("AaBBCcDD"),("AaBBCcDd"),("AaBBccDD"),("AaBbCcDD"),("AaBBccDd"),("AaBbccDD"),("AaBbCcDd"),("AaBbccDd"),
				("AABbCCDD"),("AABbCCDd"),("AABbCcDD"),("AAbbCCDD"),("AABbCcDd"),("AAbbCcDD"),("AAbbCCDd"),("AAbbCcDd"),
					("AaBbCCDD"),("AaBbCCDd"),("AaBbCcDD"),("AabbCCDD"),("AaBbCcDd"),("AabbCcDD"),("AabbCCDd"),("AabbCcDd"),
				("AABBCcDd"),("AABBCcdd"),("AABBccDd"),("AABbCcDd"),("AABBccdd"),("AABbccDd"),("AABbCcdd"),("AABbccdd"),
					("AaBBCcDd"),("AaBBCcdd"),("AaBBccDd"),("AaBbCcDd"),("AaBBccdd"),("AaBbccDd"),("AaBbCcdd"),("AaBbccdd"),
				("AABbCcDD"),("AABbCcDd"),("AABbccDD"),("AAbbCcDD"),("AABbccDd"),("AAbbccDD"),("AAbbCcDd"),("AAbbccDd"),
					("AaBbCcDD"),("AaBbCcDd"),("AaBbccDD"),("AabbCcDD"),("AaBbccDd"),("AabbccDD"),("AabbCcDd"),("AabbccDd"),
				("AABbCCDd"),("AABbCCdd"),("AABbCcDd"),("AAbbCCDd"),("AABbCcdd"),("AAbbCcDd"),("AAbbCCdd"),("AAbbCcdd"),
					("AaBbCCDd"),("AaBbCCdd"),("AaBbCcDd"),("AabbCCDd"),("AaBbCcdd"),("AabbCcDd"),("AabbCCdd"),("AabbCcdd"),
				("AABbCcDd"),("AABbCcdd"),("AABbccDd"),("AAbbCcDd"),("AABbccdd"),("AAbbccDd"),("AAbbCcdd"),("AAbbccdd"),
					("AaBbCcDd"),("AaBbCcdd"),("AaBbccDd"),("AabbCcDd"),("AaBbccdd"),("AabbccDd"),("AabbCcdd"),("Aabbccdd"),
				("AaBBCCDD"),("AaBBCCDd"),("AaBBCcDD"),("AaBbCCDD"),("AaBBCcDd"),("AaBbCcDD"),("AaBbCCDd"),("AaBbCcDd"),
					("aaBBCCDD"),("aaBBCCDd"),("aaBBCcDD"),("aaBbCCDD"),("aaBBCcDd"),("aaBbCcDD"),("aaBbCCDd"),("aaBbCcDd"),
				("AaBBCCDd"),("AaBBCCdd"),("AaBBCcDd"),("AaBbCCDd"),("AaBBCcdd"),("AaBbCcDd"),("AaBbCCdd"),("AaBbCcdd"),
					("aaBBCCDd"),("aaBBCCdd"),("aaBBCcDd"),("aaBbCCDd"),("aaBBCcdd"),("aaBbCcDd"),("aaBbCCdd"),("aaBbCcdd"),
				("AaBBCcDD"),("AaBBCcDd"),("AaBBccDD"),("AaBbCcDD"),("AaBBccDd"),("AaBbccDD"),("AaBbCcDd"),("AaBbccDd"),
					("aaBBCcDD"),("aaBBCcDd"),("aaBBccDD"),("aaBbCcDD"),("aaBBccDd"),("aaBbccDD"),("aaBbCcDd"),("aaBbccDd"),
				("AaBbCCDD"),("AaBbCCDd"),("AaBbCcDD"),("AabbCCDD"),("AaBbCcDd"),("AabbCcDD"),("AabbCCDd"),("AabbCcDd"),
					("aaBbCCDD"),("aaBbCCDd"),("aaBbCcDD"),("aabbCCDD"),("aaBbCcDd"),("aabbCcDD"),("aabbCCDd"),("aabbCcDd"),
				("AaBBCcDd"),("AaBBCcdd"),("AaBBccDd"),("AaBbCcDd"),("AaBBccdd"),("AaBbccDd"),("AaBbCcdd"),("AaBbccdd"),
					("aaBBCcDd"),("aaBBCcdd"),("aaBBccDd"),("aaBbCcDd"),("aaBBccdd"),("aaBbccDd"),("aaBbCcdd"),("aaBbccdd"),
				("AaBbCcDD"),("AaBbCcDd"),("AaBbccDD"),("AabbCcDD"),("AaBbccDd"),("AabbccDD"),("AabbCcDd"),("AabbccDd"),
					("aaBbCcDD"),("aaBbCcDd"),("aaBbccDD"),("aabbCcDD"),("aaBbccDd"),("aabbccDD"),("aabbCcDd"),("aabbccDd"),
				("AaBbCCDd"),("AaBbCCdd"),("AaBbCcDd"),("AabbCCDd"),("AaBbCcdd"),("AabbCcDd"),("AabbCCdd"),("AabbCcdd"),
					("aaBbCCDd"),("aaBbCCdd"),("aaBbCcDd"),("aabbCCDd"),("aaBbCcdd"),("aabbCcDd"),("aabbCCdd"),("aabbCcdd"),
				("AaBbCcDd"),("AaBbCcdd"),("AaBbccDd"),("AabbCcDd"),("AaBbccdd"),("AabbccDd"),("AabbCcdd"),("Aabbccdd"),
					("aaBbCcDd"),("aaBbCcdd"),("aaBbccDd"),("aabbCcDd"),("aaBbccdd"),("aabbccDd"),("aabbCcdd"),("aabbccdd")};
		
		String[] test = new String[pm.getOffspring().size()];
		for (int i = 0; i < test.length; i++)
		{
			test[i] = pm.getOffspring().get(i);
		}
		
		boolean allEntriesIncluded = true;
		for (int k = 0; k < test.length; k++)
		{
			boolean isResultInArray = false;
			for (String a: test)
			{
				if (a.equals(sample[k]))
				{
					isResultInArray = true;
				}
			}
			if (!isResultInArray)
			{
				allEntriesIncluded = false;
			}
		}
		assertTrue(allEntriesIncluded);
	}
	
	@Test
	void heteroBuildPunnettSquareResultsAccuracyWithFiveGenes() 
	{
		PunnettMe pm = new PunnettMe();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", true, false, false),
				new Gene("B", true, false, false),
				new Gene("C", true, false, false),
				new Gene("D", true, false, false),
				new Gene("E", true, false, false)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", true, false, false),
				new Gene("B", true, false, false),
				new Gene("C", true, false, false),
				new Gene("D", true, false, false),
				new Gene("E", true, false, false)});
		
		pm.setParents(parentOne, parentTwo);
		pm.run();
		
		String[] sample = new String[] 	{
				("AABBCCDDEE"),("AABBCCDDEe"),("AABBCCDdEE"),("AABBCcDDEE"),("AABbCCDDEE"),("AABBCCDdEe"),("AABBCcDdEE"),("AABBCcDDEe"),("AABbCCDDEe"),("AABbCCDdEE"),("AABbCcDDEE"),("AABBCcDdEe"),("AABbCCDdEe"),("AABbCcDDEe"),("AABbCcDdEE"),("AABbCcDdEe"),
					("AaBBCCDDEE"),("AaBBCCDDEe"),("AaBBCCDdEE"),("AaBBCcDDEE"),("AaBbCCDDEE"),("AaBBCCDdEe"),("AaBBCcDdEE"),("AaBBCcDDEe"),("AaBbCCDDEe"),("AaBbCCDdEE"),("AaBbCcDDEE"),("AaBBCcDdEe"),("AaBbCCDdEe"),("AaBbCcDDEe"),("AaBbCcDdEE"),("AaBbCcDdEe"),
				("AABBCCDDEe"),("AABBCCDDee"),("AABBCCDdEe"),("AABBCcDDEe"),("AABbCCDDEe"),("AABBCCDdee"),("AABBCcDdEe"),("AABBCcDDee"),("AABbCCDDee"),("AABbCCDdEe"),("AABbCcDDEe"),("AABBCcDdee"),("AABbCCDdee"),("AABbCcDDee"),("AABbCcDdEe"),("AABbCcDdee"),
					("AaBBCCDDEe"),("AaBBCCDDee"),("AaBBCCDdEe"),("AaBBCcDDEe"),("AaBbCCDDEe"),("AaBBCCDdee"),("AaBBCcDdEe"),("AaBBCcDDee"),("AaBbCCDDee"),("AaBbCCDdEe"),("AaBbCcDDEe"),("AaBBCcDdee"),("AaBbCCDdee"),("AaBbCcDDee"),("AaBbCcDdEe"),("AaBbCcDdee"),
				("AABBCCDdEE"),("AABBCCDdEe"),("AABBCCddEE"),("AABBCcDdEE"),("AABbCCDdEE"),("AABBCCddEe"),("AABBCcddEE"),("AABBCcDdEe"),("AABbCCDdEe"),("AABbCCddEE"),("AABbCcDdEE"),("AABBCcddEe"),("AABbCCddEe"),("AABbCcDdEe"),("AABbCcddEE"),("AABbCcddEe"),
					("AaBBCCDdEE"),("AaBBCCDdEe"),("AaBBCCddEE"),("AaBBCcDdEE"),("AaBbCCDdEE"),("AaBBCCddEe"),("AaBBCcddEE"),("AaBBCcDdEe"),("AaBbCCDdEe"),("AaBbCCddEE"),("AaBbCcDdEE"),("AaBBCcddEe"),("AaBbCCddEe"),("AaBbCcDdEe"),("AaBbCcddEE"),("AaBbCcddEe"),
				("AABBCcDDEE"),("AABBCcDDEe"),("AABBCcDdEE"),("AABBccDDEE"),("AABbCcDDEE"),("AABBCcDdEe"),("AABBccDdEE"),("AABBccDDEe"),("AABbCcDDEe"),("AABbCcDdEE"),("AABbccDDEE"),("AABBccDdEe"),("AABbCcDdEe"),("AABbccDDEe"),("AABbccDdEE"),("AABbccDdEe"),
					("AaBBCcDDEE"),("AaBBCcDDEe"),("AaBBCcDdEE"),("AaBBccDDEE"),("AaBbCcDDEE"),("AaBBCcDdEe"),("AaBBccDdEE"),("AaBBccDDEe"),("AaBbCcDDEe"),("AaBbCcDdEE"),("AaBbccDDEE"),("AaBBccDdEe"),("AaBbCcDdEe"),("AaBbccDDEe"),("AaBbccDdEE"),("AaBbccDdEe"),
				("AABbCCDDEE"),("AABbCCDDEe"),("AABbCCDdEE"),("AABbCcDDEE"),("AAbbCCDDEE"),("AABbCCDdEe"),("AABbCcDdEE"),("AABbCcDDEe"),("AAbbCCDDEe"),("AAbbCCDdEE"),("AAbbCcDDEE"),("AABbCcDdEe"),("AAbbCCDdEe"),("AAbbCcDDEe"),("AAbbCcDdEE"),("AAbbCcDdEe"),
					("AaBbCCDDEE"),("AaBbCCDDEe"),("AaBbCCDdEE"),("AaBbCcDDEE"),("AabbCCDDEE"),("AaBbCCDdEe"),("AaBbCcDdEE"),("AaBbCcDDEe"),("AabbCCDDEe"),("AabbCCDdEE"),("AabbCcDDEE"),("AaBbCcDdEe"),("AabbCCDdEe"),("AabbCcDDEe"),("AabbCcDdEE"),("AabbCcDdEe"),
				("AABBCCDdEe"),("AABBCCDdee"),("AABBCCddEe"),("AABBCcDdEe"),("AABbCCDdEe"),("AABBCCddee"),("AABBCcddEe"),("AABBCcDdee"),("AABbCCDdee"),("AABbCCddEe"),("AABbCcDdEe"),("AABBCcddee"),("AABbCCddee"),("AABbCcDdee"),("AABbCcddEe"),("AABbCcddee"),
					("AaBBCCDdEe"),("AaBBCCDdee"),("AaBBCCddEe"),("AaBBCcDdEe"),("AaBbCCDdEe"),("AaBBCCddee"),("AaBBCcddEe"),("AaBBCcDdee"),("AaBbCCDdee"),("AaBbCCddEe"),("AaBbCcDdEe"),("AaBBCcddee"),("AaBbCCddee"),("AaBbCcDdee"),("AaBbCcddEe"),("AaBbCcddee"),
				("AABBCcDdEE"),("AABBCcDdEe"),("AABBCcddEE"),("AABBccDdEE"),("AABbCcDdEE"),("AABBCcddEe"),("AABBccddEE"),("AABBccDdEe"),("AABbCcDdEe"),("AABbCcddEE"),("AABbccDdEE"),("AABBccddEe"),("AABbCcddEe"),("AABbccDdEe"),("AABbccddEE"),("AABbccddEe"),
					("AaBBCcDdEE"),("AaBBCcDdEe"),("AaBBCcddEE"),("AaBBccDdEE"),("AaBbCcDdEE"),("AaBBCcddEe"),("AaBBccddEE"),("AaBBccDdEe"),("AaBbCcDdEe"),("AaBbCcddEE"),("AaBbccDdEE"),("AaBBccddEe"),("AaBbCcddEe"),("AaBbccDdEe"),("AaBbccddEE"),("AaBbccddEe"),
				("AABBCcDDEe"),("AABBCcDDee"),("AABBCcDdEe"),("AABBccDDEe"),("AABbCcDDEe"),("AABBCcDdee"),("AABBccDdEe"),("AABBccDDee"),("AABbCcDDee"),("AABbCcDdEe"),("AABbccDDEe"),("AABBccDdee"),("AABbCcDdee"),("AABbccDDee"),("AABbccDdEe"),("AABbccDdee"),
					("AaBBCcDDEe"),("AaBBCcDDee"),("AaBBCcDdEe"),("AaBBccDDEe"),("AaBbCcDDEe"),("AaBBCcDdee"),("AaBBccDdEe"),("AaBBccDDee"),("AaBbCcDDee"),("AaBbCcDdEe"),("AaBbccDDEe"),("AaBBccDdee"),("AaBbCcDdee"),("AaBbccDDee"),("AaBbccDdEe"),("AaBbccDdee"),
				("AABbCCDDEe"),("AABbCCDDee"),("AABbCCDdEe"),("AABbCcDDEe"),("AAbbCCDDEe"),("AABbCCDdee"),("AABbCcDdEe"),("AABbCcDDee"),("AAbbCCDDee"),("AAbbCCDdEe"),("AAbbCcDDEe"),("AABbCcDdee"),("AAbbCCDdee"),("AAbbCcDDee"),("AAbbCcDdEe"),("AAbbCcDdee"),
					("AaBbCCDDEe"),("AaBbCCDDee"),("AaBbCCDdEe"),("AaBbCcDDEe"),("AabbCCDDEe"),("AaBbCCDdee"),("AaBbCcDdEe"),("AaBbCcDDee"),("AabbCCDDee"),("AabbCCDdEe"),("AabbCcDDEe"),("AaBbCcDdee"),("AabbCCDdee"),("AabbCcDDee"),("AabbCcDdEe"),("AabbCcDdee"),
				("AABbCCDdEE"),("AABbCCDdEe"),("AABbCCddEE"),("AABbCcDdEE"),("AAbbCCDdEE"),("AABbCCddEe"),("AABbCcddEE"),("AABbCcDdEe"),("AAbbCCDdEe"),("AAbbCCddEE"),("AAbbCcDdEE"),("AABbCcddEe"),("AAbbCCddEe"),("AAbbCcDdEe"),("AAbbCcddEE"),("AAbbCcddEe"),
					("AaBbCCDdEE"),("AaBbCCDdEe"),("AaBbCCddEE"),("AaBbCcDdEE"),("AabbCCDdEE"),("AaBbCCddEe"),("AaBbCcddEE"),("AaBbCcDdEe"),("AabbCCDdEe"),("AabbCCddEE"),("AabbCcDdEE"),("AaBbCcddEe"),("AabbCCddEe"),("AabbCcDdEe"),("AabbCcddEE"),("AabbCcddEe"),
				("AABbCcDDEE"),("AABbCcDDEe"),("AABbCcDdEE"),("AABbccDDEE"),("AAbbCcDDEE"),("AABbCcDdEe"),("AABbccDdEE"),("AABbccDDEe"),("AAbbCcDDEe"),("AAbbCcDdEE"),("AAbbccDDEE"),("AABbccDdEe"),("AAbbCcDdEe"),("AAbbccDDEe"),("AAbbccDdEE"),("AAbbccDdEe"),
					("AaBbCcDDEE"),("AaBbCcDDEe"),("AaBbCcDdEE"),("AaBbccDDEE"),("AabbCcDDEE"),("AaBbCcDdEe"),("AaBbccDdEE"),("AaBbccDDEe"),("AabbCcDDEe"),("AabbCcDdEE"),("AabbccDDEE"),("AaBbccDdEe"),("AabbCcDdEe"),("AabbccDDEe"),("AabbccDdEE"),("AabbccDdEe"),
				("AABBCcDdEe"),("AABBCcDdee"),("AABBCcddEe"),("AABBccDdEe"),("AABbCcDdEe"),("AABBCcddee"),("AABBccddEe"),("AABBccDdee"),("AABbCcDdee"),("AABbCcddEe"),("AABbccDdEe"),("AABBccddee"),("AABbCcddee"),("AABbccDdee"),("AABbccddEe"),("AABbccddee"),
					("AaBBCcDdEe"),("AaBBCcDdee"),("AaBBCcddEe"),("AaBBccDdEe"),("AaBbCcDdEe"),("AaBBCcddee"),("AaBBccddEe"),("AaBBccDdee"),("AaBbCcDdee"),("AaBbCcddEe"),("AaBbccDdEe"),("AaBBccddee"),("AaBbCcddee"),("AaBbccDdee"),("AaBbccddEe"),("AaBbccddee"),
				("AABbCCDdEe"),("AABbCCDdee"),("AABbCCddEe"),("AABbCcDdEe"),("AAbbCCDdEe"),("AABbCCddee"),("AABbCcddEe"),("AABbCcDdee"),("AAbbCCDdee"),("AAbbCCddEe"),("AAbbCcDdEe"),("AABbCcddee"),("AAbbCCddee"),("AAbbCcDdee"),("AAbbCcddEe"),("AAbbCcddee"),
					("AaBbCCDdEe"),("AaBbCCDdee"),("AaBbCCddEe"),("AaBbCcDdEe"),("AabbCCDdEe"),("AaBbCCddee"),("AaBbCcddEe"),("AaBbCcDdee"),("AabbCCDdee"),("AabbCCddEe"),("AabbCcDdEe"),("AaBbCcddee"),("AabbCCddee"),("AabbCcDdee"),("AabbCcddEe"),("AabbCcddee"),
				("AABbCcDDEe"),("AABbCcDDee"),("AABbCcDdEe"),("AABbccDDEe"),("AAbbCcDDEe"),("AABbCcDdee"),("AABbccDdEe"),("AABbccDDee"),("AAbbCcDDee"),("AAbbCcDdEe"),("AAbbccDDEe"),("AABbccDdee"),("AAbbCcDdee"),("AAbbccDDee"),("AAbbccDdEe"),("AAbbccDdee"),
					("AaBbCcDDEe"),("AaBbCcDDee"),("AaBbCcDdEe"),("AaBbccDDEe"),("AabbCcDDEe"),("AaBbCcDdee"),("AaBbccDdEe"),("AaBbccDDee"),("AabbCcDDee"),("AabbCcDdEe"),("AabbccDDEe"),("AaBbccDdee"),("AabbCcDdee"),("AabbccDDee"),("AabbccDdEe"),("AabbccDdee"),
				("AABbCcDdEE"),("AABbCcDdEe"),("AABbCcddEE"),("AABbccDdEE"),("AAbbCcDdEE"),("AABbCcddEe"),("AABbccddEE"),("AABbccDdEe"),("AAbbCcDdEe"),("AAbbCcddEE"),("AAbbccDdEE"),("AABbccddEe"),("AAbbCcddEe"),("AAbbccDdEe"),("AAbbccddEE"),("AAbbccddEe"),
					("AaBbCcDdEE"),("AaBbCcDdEe"),("AaBbCcddEE"),("AaBbccDdEE"),("AabbCcDdEE"),("AaBbCcddEe"),("AaBbccddEE"),("AaBbccDdEe"),("AabbCcDdEe"),("AabbCcddEE"),("AabbccDdEE"),("AaBbccddEe"),("AabbCcddEe"),("AabbccDdEe"),("AabbccddEE"),("AabbccddEe"),
				("AABbCcDdEe"),("AABbCcDdee"),("AABbCcddEe"),("AABbccDdEe"),("AAbbCcDdEe"),("AABbCcddee"),("AABbccddEe"),("AABbccDdee"),("AAbbCcDdee"),("AAbbCcddEe"),("AAbbccDdEe"),("AABbccddee"),("AAbbCcddee"),("AAbbccDdee"),("AAbbccddEe"),("AAbbccddee"),
					("AaBbCcDdEe"),("AaBbCcDdee"),("AaBbCcddEe"),("AaBbccDdEe"),("AabbCcDdEe"),("AaBbCcddee"),("AaBbccddEe"),("AaBbccDdee"),("AabbCcDdee"),("AabbCcddEe"),("AabbccDdEe"),("AaBbccddee"),("AabbCcddee"),("AabbccDdee"),("AabbccddEe"),("Aabbccddee"),
				("AaBBCCDDEE"),("AaBBCCDDEe"),("AaBBCCDdEE"),("AaBBCcDDEE"),("AaBbCCDDEE"),("AaBBCCDdEe"),("AaBBCcDdEE"),("AaBBCcDDEe"),("AaBbCCDDEe"),("AaBbCCDdEE"),("AaBbCcDDEE"),("AaBBCcDdEe"),("AaBbCCDdEe"),("AaBbCcDDEe"),("AaBbCcDdEE"),("AaBbCcDdEe"),
					("aaBBCCDDEE"),("aaBBCCDDEe"),("aaBBCCDdEE"),("aaBBCcDDEE"),("aaBbCCDDEE"),("aaBBCCDdEe"),("aaBBCcDdEE"),("aaBBCcDDEe"),("aaBbCCDDEe"),("aaBbCCDdEE"),("aaBbCcDDEE"),("aaBBCcDdEe"),("aaBbCCDdEe"),("aaBbCcDDEe"),("aaBbCcDdEE"),("aaBbCcDdEe"),
				("AaBBCCDDEe"),("AaBBCCDDee"),("AaBBCCDdEe"),("AaBBCcDDEe"),("AaBbCCDDEe"),("AaBBCCDdee"),("AaBBCcDdEe"),("AaBBCcDDee"),("AaBbCCDDee"),("AaBbCCDdEe"),("AaBbCcDDEe"),("AaBBCcDdee"),("AaBbCCDdee"),("AaBbCcDDee"),("AaBbCcDdEe"),("AaBbCcDdee"),
					("aaBBCCDDEe"),("aaBBCCDDee"),("aaBBCCDdEe"),("aaBBCcDDEe"),("aaBbCCDDEe"),("aaBBCCDdee"),("aaBBCcDdEe"),("aaBBCcDDee"),("aaBbCCDDee"),("aaBbCCDdEe"),("aaBbCcDDEe"),("aaBBCcDdee"),("aaBbCCDdee"),("aaBbCcDDee"),("aaBbCcDdEe"),("aaBbCcDdee"),
				("AaBBCCDdEE"),("AaBBCCDdEe"),("AaBBCCddEE"),("AaBBCcDdEE"),("AaBbCCDdEE"),("AaBBCCddEe"),("AaBBCcddEE"),("AaBBCcDdEe"),("AaBbCCDdEe"),("AaBbCCddEE"),("AaBbCcDdEE"),("AaBBCcddEe"),("AaBbCCddEe"),("AaBbCcDdEe"),("AaBbCcddEE"),("AaBbCcddEe"),
					("aaBBCCDdEE"),("aaBBCCDdEe"),("aaBBCCddEE"),("aaBBCcDdEE"),("aaBbCCDdEE"),("aaBBCCddEe"),("aaBBCcddEE"),("aaBBCcDdEe"),("aaBbCCDdEe"),("aaBbCCddEE"),("aaBbCcDdEE"),("aaBBCcddEe"),("aaBbCCddEe"),("aaBbCcDdEe"),("aaBbCcddEE"),("aaBbCcddEe"),
				("AaBBCcDDEE"),("AaBBCcDDEe"),("AaBBCcDdEE"),("AaBBccDDEE"),("AaBbCcDDEE"),("AaBBCcDdEe"),("AaBBccDdEE"),("AaBBccDDEe"),("AaBbCcDDEe"),("AaBbCcDdEE"),("AaBbccDDEE"),("AaBBccDdEe"),("AaBbCcDdEe"),("AaBbccDDEe"),("AaBbccDdEE"),("AaBbccDdEe"),
					("aaBBCcDDEE"),("aaBBCcDDEe"),("aaBBCcDdEE"),("aaBBccDDEE"),("aaBbCcDDEE"),("aaBBCcDdEe"),("aaBBccDdEE"),("aaBBccDDEe"),("aaBbCcDDEe"),("aaBbCcDdEE"),("aaBbccDDEE"),("aaBBccDdEe"),("aaBbCcDdEe"),("aaBbccDDEe"),("aaBbccDdEE"),("aaBbccDdEe"),
				("AaBbCCDDEE"),("AaBbCCDDEe"),("AaBbCCDdEE"),("AaBbCcDDEE"),("AabbCCDDEE"),("AaBbCCDdEe"),("AaBbCcDdEE"),("AaBbCcDDEe"),("AabbCCDDEe"),("AabbCCDdEE"),("AabbCcDDEE"),("AaBbCcDdEe"),("AabbCCDdEe"),("AabbCcDDEe"),("AabbCcDdEE"),("AabbCcDdEe"),
					("aaBbCCDDEE"),("aaBbCCDDEe"),("aaBbCCDdEE"),("aaBbCcDDEE"),("aabbCCDDEE"),("aaBbCCDdEe"),("aaBbCcDdEE"),("aaBbCcDDEe"),("aabbCCDDEe"),("aabbCCDdEE"),("aabbCcDDEE"),("aaBbCcDdEe"),("aabbCCDdEe"),("aabbCcDDEe"),("aabbCcDdEE"),("aabbCcDdEe"),
				("AaBBCCDdEe"),("AaBBCCDdee"),("AaBBCCddEe"),("AaBBCcDdEe"),("AaBbCCDdEe"),("AaBBCCddee"),("AaBBCcddEe"),("AaBBCcDdee"),("AaBbCCDdee"),("AaBbCCddEe"),("AaBbCcDdEe"),("AaBBCcddee"),("AaBbCCddee"),("AaBbCcDdee"),("AaBbCcddEe"),("AaBbCcddee"),
					("aaBBCCDdEe"),("aaBBCCDdee"),("aaBBCCddEe"),("aaBBCcDdEe"),("aaBbCCDdEe"),("aaBBCCddee"),("aaBBCcddEe"),("aaBBCcDdee"),("aaBbCCDdee"),("aaBbCCddEe"),("aaBbCcDdEe"),("aaBBCcddee"),("aaBbCCddee"),("aaBbCcDdee"),("aaBbCcddEe"),("aaBbCcddee"),
				("AaBBCcDdEE"),("AaBBCcDdEe"),("AaBBCcddEE"),("AaBBccDdEE"),("AaBbCcDdEE"),("AaBBCcddEe"),("AaBBccddEE"),("AaBBccDdEe"),("AaBbCcDdEe"),("AaBbCcddEE"),("AaBbccDdEE"),("AaBBccddEe"),("AaBbCcddEe"),("AaBbccDdEe"),("AaBbccddEE"),("AaBbccddEe"),
					("aaBBCcDdEE"),("aaBBCcDdEe"),("aaBBCcddEE"),("aaBBccDdEE"),("aaBbCcDdEE"),("aaBBCcddEe"),("aaBBccddEE"),("aaBBccDdEe"),("aaBbCcDdEe"),("aaBbCcddEE"),("aaBbccDdEE"),("aaBBccddEe"),("aaBbCcddEe"),("aaBbccDdEe"),("aaBbccddEE"),("aaBbccddEe"),
				("AaBBCcDDEe"),("AaBBCcDDee"),("AaBBCcDdEe"),("AaBBccDDEe"),("AaBbCcDDEe"),("AaBBCcDdee"),("AaBBccDdEe"),("AaBBccDDee"),("AaBbCcDDee"),("AaBbCcDdEe"),("AaBbccDDEe"),("AaBBccDdee"),("AaBbCcDdee"),("AaBbccDDee"),("AaBbccDdEe"),("AaBbccDdee"),
					("aaBBCcDDEe"),("aaBBCcDDee"),("aaBBCcDdEe"),("aaBBccDDEe"),("aaBbCcDDEe"),("aaBBCcDdee"),("aaBBccDdEe"),("aaBBccDDee"),("aaBbCcDDee"),("aaBbCcDdEe"),("aaBbccDDEe"),("aaBBccDdee"),("aaBbCcDdee"),("aaBbccDDee"),("aaBbccDdEe"),("aaBbccDdee"),
				("AaBbCCDDEe"),("AaBbCCDDee"),("AaBbCCDdEe"),("AaBbCcDDEe"),("AabbCCDDEe"),("AaBbCCDdee"),("AaBbCcDdEe"),("AaBbCcDDee"),("AabbCCDDee"),("AabbCCDdEe"),("AabbCcDDEe"),("AaBbCcDdee"),("AabbCCDdee"),("AabbCcDDee"),("AabbCcDdEe"),("AabbCcDdee"),
					("aaBbCCDDEe"),("aaBbCCDDee"),("aaBbCCDdEe"),("aaBbCcDDEe"),("aabbCCDDEe"),("aaBbCCDdee"),("aaBbCcDdEe"),("aaBbCcDDee"),("aabbCCDDee"),("aabbCCDdEe"),("aabbCcDDEe"),("aaBbCcDdee"),("aabbCCDdee"),("aabbCcDDee"),("aabbCcDdEe"),("aabbCcDdee"),
				("AaBbCCDdEE"),("AaBbCCDdEe"),("AaBbCCddEE"),("AaBbCcDdEE"),("AabbCCDdEE"),("AaBbCCddEe"),("AaBbCcddEE"),("AaBbCcDdEe"),("AabbCCDdEe"),("AabbCCddEE"),("AabbCcDdEE"),("AaBbCcddEe"),("AabbCCddEe"),("AabbCcDdEe"),("AabbCcddEE"),("AabbCcddEe"),
					("aaBbCCDdEE"),("aaBbCCDdEe"),("aaBbCCddEE"),("aaBbCcDdEE"),("aabbCCDdEE"),("aaBbCCddEe"),("aaBbCcddEE"),("aaBbCcDdEe"),("aabbCCDdEe"),("aabbCCddEE"),("aabbCcDdEE"),("aaBbCcddEe"),("aabbCCddEe"),("aabbCcDdEe"),("aabbCcddEE"),("aabbCcddEe"),
				("AaBbCcDDEE"),("AaBbCcDDEe"),("AaBbCcDdEE"),("AaBbccDDEE"),("AabbCcDDEE"),("AaBbCcDdEe"),("AaBbccDdEE"),("AaBbccDDEe"),("AabbCcDDEe"),("AabbCcDdEE"),("AabbccDDEE"),("AaBbccDdEe"),("AabbCcDdEe"),("AabbccDDEe"),("AabbccDdEE"),("AabbccDdEe"),
					("aaBbCcDDEE"),("aaBbCcDDEe"),("aaBbCcDdEE"),("aaBbccDDEE"),("aabbCcDDEE"),("aaBbCcDdEe"),("aaBbccDdEE"),("aaBbccDDEe"),("aabbCcDDEe"),("aabbCcDdEE"),("aabbccDDEE"),("aaBbccDdEe"),("aabbCcDdEe"),("aabbccDDEe"),("aabbccDdEE"),("aabbccDdEe"),
				("AaBBCcDdEe"),("AaBBCcDdee"),("AaBBCcddEe"),("AaBBccDdEe"),("AaBbCcDdEe"),("AaBBCcddee"),("AaBBccddEe"),("AaBBccDdee"),("AaBbCcDdee"),("AaBbCcddEe"),("AaBbccDdEe"),("AaBBccddee"),("AaBbCcddee"),("AaBbccDdee"),("AaBbccddEe"),("AaBbccddee"),
					("aaBBCcDdEe"),("aaBBCcDdee"),("aaBBCcddEe"),("aaBBccDdEe"),("aaBbCcDdEe"),("aaBBCcddee"),("aaBBccddEe"),("aaBBccDdee"),("aaBbCcDdee"),("aaBbCcddEe"),("aaBbccDdEe"),("aaBBccddee"),("aaBbCcddee"),("aaBbccDdee"),("aaBbccddEe"),("aaBbccddee"),
				("AaBbCCDdEe"),("AaBbCCDdee"),("AaBbCCddEe"),("AaBbCcDdEe"),("AabbCCDdEe"),("AaBbCCddee"),("AaBbCcddEe"),("AaBbCcDdee"),("AabbCCDdee"),("AabbCCddEe"),("AabbCcDdEe"),("AaBbCcddee"),("AabbCCddee"),("AabbCcDdee"),("AabbCcddEe"),("AabbCcddee"),
					("aaBbCCDdEe"),("aaBbCCDdee"),("aaBbCCddEe"),("aaBbCcDdEe"),("aabbCCDdEe"),("aaBbCCddee"),("aaBbCcddEe"),("aaBbCcDdee"),("aabbCCDdee"),("aabbCCddEe"),("aabbCcDdEe"),("aaBbCcddee"),("aabbCCddee"),("aabbCcDdee"),("aabbCcddEe"),("aabbCcddee"),
				("AaBbCcDDEe"),("AaBbCcDDee"),("AaBbCcDdEe"),("AaBbccDDEe"),("AabbCcDDEe"),("AaBbCcDdee"),("AaBbccDdEe"),("AaBbccDDee"),("AabbCcDDee"),("AabbCcDdEe"),("AabbccDDEe"),("AaBbccDdee"),("AabbCcDdee"),("AabbccDDee"),("AabbccDdEe"),("AabbccDdee"),
					("aaBbCcDDEe"),("aaBbCcDDee"),("aaBbCcDdEe"),("aaBbccDDEe"),("aabbCcDDEe"),("aaBbCcDdee"),("aaBbccDdEe"),("aaBbccDDee"),("aabbCcDDee"),("aabbCcDdEe"),("aabbccDDEe"),("aaBbccDdee"),("aabbCcDdee"),("aabbccDDee"),("aabbccDdEe"),("aabbccDdee"),
				("AaBbCcDdEE"),("AaBbCcDdEe"),("AaBbCcddEE"),("AaBbccDdEE"),("AabbCcDdEE"),("AaBbCcddEe"),("AaBbccddEE"),("AaBbccDdEe"),("AabbCcDdEe"),("AabbCcddEE"),("AabbccDdEE"),("AaBbccddEe"),("AabbCcddEe"),("AabbccDdEe"),("AabbccddEE"),("AabbccddEe"),
					("aaBbCcDdEE"),("aaBbCcDdEe"),("aaBbCcddEE"),("aaBbccDdEE"),("aabbCcDdEE"),("aaBbCcddEe"),("aaBbccddEE"),("aaBbccDdEe"),("aabbCcDdEe"),("aabbCcddEE"),("aabbccDdEE"),("aaBbccddEe"),("aabbCcddEe"),("aabbccDdEe"),("aabbccddEE"),("aabbccddEe"),
				("AaBbCcDdEe"),("AaBbCcDdee"),("AaBbCcddEe"),("AaBbccDdEe"),("AabbCcDdEe"),("AaBbCcddee"),("AaBbccddEe"),("AaBbccDdee"),("AabbCcDdee"),("AabbCcddEe"),("AabbccDdEe"),("AaBbccddee"),("AabbCcddee"),("AabbccDdee"),("AabbccddEe"),("Aabbccddee"),
					("aaBbCcDdEe"),("aaBbCcDdee"),("aaBbCcddEe"),("aaBbccDdEe"),("aabbCcDdEe"),("aaBbCcddee"),("aaBbccddEe"),("aaBbccDdee"),("aabbCcDdee"),("aabbCcddEe"),("aabbccDdEe"),("aaBbccddee"),("aabbCcddee"),("aabbccDdee"),("aabbccddEe"),("aabbccddee")};
		
		String[] test = new String[pm.getOffspring().size()];
		for (int i = 0; i < test.length; i++)
		{
			test[i] = pm.getOffspring().get(i);
		}
		
		boolean allEntriesIncluded = true;
		for (int k = 0; k < test.length; k++)
		{
			boolean isResultInArray = false;
			for (String a: test)
			{
				if (a.equals(sample[k]))
				{
					isResultInArray = true;
				}
			}
			if (!isResultInArray)
			{
				allEntriesIncluded = false;
			}
		}
		assertTrue(allEntriesIncluded);
	}

	@Test
	void heteroScoreResultsWithOneGene()
	{
		PunnettMe pm = new PunnettMe();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
		new Gene("A", true, false, false)});

		parentTwo.setRawGenes(new Gene[] {
		new Gene("A", true, false, false)});
		
		pm.setParents(parentOne, parentTwo);
		pm.run();
		
		
		
	}
	
	@Test
	void toRunCurrently()
	{
		PunnettMe pm = new PunnettMe();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false),
//				new Gene("B", true, false, false),
//				new Gene("C", true, false, false),
				new Gene("D", true, false, false),
				new Gene("E", true, false, false)});
		
		parentTwo.setRawGenes(new Gene[] {
//				new Gene("A", true, false, false),
//				new Gene("B", true, false, false),
//				new Gene("C", true, false, false),
				new Gene("D", true, false, false),
				new Gene("E", true, false, false)});
		
		pm.setParents(parentOne, parentTwo);
		pm.run();
		
	}

}
