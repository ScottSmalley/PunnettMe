/**
 * Punnett Me is an app to use for Punnett Squares for Genetic Trait Calculations.
 * You can calculate up to 5 different traits at once.
 * You can quickly change from Homozygous parents and Heterozygous parents 
 * for comparisons.
 * 
 * Uses Design by Contract programming.
 *
 * Test Data from www.iansvivarium.com/punnett/
 * 
 * Note: These tests are preliminary, as I am aware there are a multitude more
 * test to build. However, with the amount of time left in this project, I
 * have decided to focus more on the rest of the project.
 * 
 * Scott Smalley, BS Software Engineering student at Utah Valley University
 * Fall 2020 expected graduation
 * scottsmalley90@gmail.com
 * 
 * @author Scott Smalley
 */
package punnettme;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

class PunnettMeTest {
	
	@Test
	void resultsCheckForGeneOneHeteroBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", true, false, false)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", true, false, false)});
		
		pm.build(parentOne, parentTwo);

		List<String> sample = pm.getResults();

		Map<String, Integer> test = new TreeMap<>();
		test.put("aa", 0);
		test.put("Aa", 1);
		test.put("AA", 0);
		
		int totalResultsSize = 4;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneOneHomoDBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", false, true, false)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", false, true, false)});
		
		pm.build(parentOne, parentTwo);

		List<String> sample = pm.getResults();

		Map<String, Integer> test = new TreeMap<>();
		test.put("AA", 3);
		
		int totalResultsSize = 4;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneOneHomoRBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", false, false, true)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", false, false, true)});
		
		pm.build(parentOne, parentTwo);

		List<String> sample = pm.getResults();

		Map<String, Integer> test = new TreeMap<>();
		test.put("aa", 3);
		
		int totalResultsSize = 4;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneTwoHeteroBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", true, false, false),
				new Gene("B", true, false, false)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", true, false, false),
				new Gene("B", true, false, false)});
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		test.put("AABB", 0);
		test.put("AABb", 1);
		test.put("AaBB", 1);
		test.put("AaBb", 3);
		test.put("AAbb", 0);
		test.put("Aabb", 1);
		test.put("aaBB", 0);
		test.put("aaBb", 1);
		test.put("aabb", 0);
		
		int totalResultsSize = 16;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneTwoHomoDBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", false, true, false),
				new Gene("B", false, true, false)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", false, true, false),
				new Gene("B", false, true, false)});
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		test.put("AABB", 15);
		
		int totalResultsSize = 16;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneTwoHomoRBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", false, false, true),
				new Gene("B", false, false, true)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", false, false, true),
				new Gene("B", false, false, true)});
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		test.put("aabb", 15);
		
		int totalResultsSize = 16;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneThreeHeteroBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
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
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		test.put("AABBCC", 0);
		test.put("AABBCc", 1);
		test.put("AABbCC", 1);
		test.put("AABbCc", 3);
		test.put("AaBBCC", 1);
		test.put("AaBBCc", 3);
		test.put("AaBbCC", 3);
		test.put("AaBbCc", 7);
		test.put("AABBcc", 0);
		test.put("AABbcc", 1);
		test.put("AaBBcc", 1);
		test.put("AaBbcc", 3);
		test.put("AAbbCC", 0);
		test.put("AAbbCc", 1);
		test.put("AabbCC", 1);
		test.put("AabbCc", 3);
		test.put("AAbbcc", 0);
		test.put("Aabbcc", 1);
		test.put("aaBBCC", 0);
		test.put("aaBBCc", 1);
		test.put("aaBbCC", 1);
		test.put("aaBbCc", 3);
		test.put("aaBBcc", 0);
		test.put("aaBbcc", 1);
		test.put("aabbCC", 0);
		test.put("aabbCc", 1);
		test.put("aabbcc", 0);

		int totalResultsSize = 64;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneThreeHomoDBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", false, true, false),
				new Gene("B", false, true, false),
				new Gene("C", false, true, false)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", false, true, false),
				new Gene("B", false, true, false),
				new Gene("C", false, true, false)});
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		test.put("AABBCC", 63);
		
		int totalResultsSize = 64;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneThreeHomoRBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", false, false, true),
				new Gene("B", false, false, true),
				new Gene("C", false, false, true)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", false, false, true),
				new Gene("B", false, false, true),
				new Gene("C", false, false, true)});
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		test.put("aabbcc", 63);
		
		int totalResultsSize = 64;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneFourHeteroBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
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
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		test.put("AABBCCDD", 0);
		test.put("AABBCCDd", 1);
		test.put("AABBCcDD", 1);
		test.put("AABBCcDd", 3);
		test.put("AABbCCDD", 1);
		test.put("AABbCCDd", 3);
		test.put("AABbCcDD", 3);
		test.put("AABbCcDd", 7);
		test.put("AaBBCCDD", 1);
		test.put("AaBBCCDd", 3);
		test.put("AaBBCcDD", 3);
		test.put("AaBBCcDd", 7);
		test.put("AaBbCCDD", 3);
		test.put("AaBbCCDd", 7);
		test.put("AaBbCcDD", 7);
		test.put("AaBbCcDd", 15);
		test.put("AABBCCdd", 0);
		test.put("AABBCcdd", 1);
		test.put("AABbCCdd", 1);
		test.put("AABbCcdd", 3);
		test.put("AaBBCCdd", 1);
		test.put("AaBBCcdd", 3);
		test.put("AaBbCCdd", 3);
		test.put("AaBbCcdd", 7);
		test.put("AABBccDD", 0);
		test.put("AABBccDd", 1);
		test.put("AABbccDD", 1);
		test.put("AABbccDd", 3);
		test.put("AaBBccDD", 1);
		test.put("AaBBccDd", 3);
		test.put("AaBbccDD", 3);
		test.put("AaBbccDd", 7);
		test.put("AABBccdd", 0);
		test.put("AABbccdd", 1);
		test.put("AaBBccdd", 1);
		test.put("AaBbccdd", 3);
		test.put("AAbbCCDD", 0);
		test.put("AAbbCCDd", 1);
		test.put("AAbbCcDD", 1);
		test.put("AAbbCcDd", 3);
		test.put("AabbCCDD", 1);
		test.put("AabbCCDd", 3);
		test.put("AabbCcDD", 3);
		test.put("AabbCcDd", 7);
		test.put("AAbbCCdd", 0);
		test.put("AAbbCcdd", 1);
		test.put("AabbCCdd", 1);
		test.put("AabbCcdd", 3);
		test.put("AAbbccDD", 0);
		test.put("AAbbccDd", 1);
		test.put("AabbccDD", 1);
		test.put("AabbccDd", 3);
		test.put("AAbbccdd", 0);
		test.put("Aabbccdd", 1);
		test.put("aaBBCCDD", 0);
		test.put("aaBBCCDd", 1);
		test.put("aaBBCcDD", 1);
		test.put("aaBBCcDd", 3);
		test.put("aaBbCCDD", 1);
		test.put("aaBbCCDd", 3);
		test.put("aaBbCcDD", 3);
		test.put("aaBbCcDd", 7);
		test.put("aaBBCCdd", 0);
		test.put("aaBBCcdd", 1);
		test.put("aaBbCCdd", 1);
		test.put("aaBbCcdd", 3);
		test.put("aaBBccDD", 0);
		test.put("aaBBccDd", 1);
		test.put("aaBbccDD", 1);
		test.put("aaBbccDd", 3);
		test.put("aaBBccdd", 0);
		test.put("aaBbccdd", 1);
		test.put("aabbCCDD", 0);
		test.put("aabbCCDd", 1);
		test.put("aabbCcDD", 1);
		test.put("aabbCcDd", 3);
		test.put("aabbCCdd", 0);
		test.put("aabbCcdd", 1);
		test.put("aabbccDD", 0);
		test.put("aabbccDd", 1);
		test.put("aabbccdd", 0);

		int totalResultsSize = 256;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneFourHomoDBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", false, true, false),
				new Gene("B", false, true, false),
				new Gene("C", false, true, false),
				new Gene("D", false, true, false)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", false, true, false),
				new Gene("B", false, true, false),
				new Gene("C", false, true, false),
				new Gene("D", false, true, false)});
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		test.put("AABBCCDD", 255);
		
		int totalResultsSize = 256;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneFourHomoRBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", false, false, true),
				new Gene("B", false, false, true),
				new Gene("C", false, false, true),
				new Gene("D", false, false, true)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", false, false, true),
				new Gene("B", false, false, true),
				new Gene("C", false, false, true),
				new Gene("D", false, false, true)});
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		test.put("aabbccdd", 255);
		
		int totalResultsSize = 256;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneFiveHeteroBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
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
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		
		test.put("AABBCCDDEE", 0);
		test.put("AABBCCDDEe", 1);
		test.put("AABBCCDdEE", 1);
		test.put("AABBCCDdEe", 3);
		test.put("AABBCcDDEE", 1);
		test.put("AABBCcDDEe", 3);
		test.put("AABBCcDdEE", 3);
		test.put("AABBCcDdEe", 7);
		test.put("AABbCCDDEE", 1);
		test.put("AABbCCDDEe", 3);
		test.put("AABbCCDdEE", 3);
		test.put("AABbCCDdEe", 7);
		test.put("AABbCcDDEE", 3);
		test.put("AABbCcDDEe", 7);
		test.put("AABbCcDdEE", 7);
		test.put("AABbCcDdEe", 15);
		test.put("AaBBCCDDEE", 1);
		test.put("AaBBCCDDEe", 3);
		test.put("AaBBCCDdEE", 3);
		test.put("AaBBCCDdEe", 7);
		test.put("AaBBCcDDEE", 3);
		test.put("AaBBCcDDEe", 7);
		test.put("AaBBCcDdEE", 7);
		test.put("AaBBCcDdEe", 15);
		test.put("AaBbCCDDEE", 3);
		test.put("AaBbCCDDEe", 7);
		test.put("AaBbCCDdEE", 7);
		test.put("AaBbCCDdEe", 15);
		test.put("AaBbCcDDEE", 7);
		test.put("AaBbCcDDEe", 15);
		test.put("AaBbCcDdEE", 15);
		test.put("AaBbCcDdEe", 31);
		test.put("AABBCCDDee", 0);
		test.put("AABBCCDdee", 1);
		test.put("AABBCcDDee", 1);
		test.put("AABBCcDdee", 3);
		test.put("AABbCCDDee", 1);
		test.put("AABbCCDdee", 3);
		test.put("AABbCcDDee", 3);
		test.put("AABbCcDdee", 7);
		test.put("AaBBCCDDee", 1);
		test.put("AaBBCCDdee", 3);
		test.put("AaBBCcDDee", 3);
		test.put("AaBBCcDdee", 7);
		test.put("AaBbCCDDee", 3);
		test.put("AaBbCCDdee", 7);
		test.put("AaBbCcDDee", 7);
		test.put("AaBbCcDdee", 15);
		test.put("AABBCCddEE", 0);
		test.put("AABBCCddEe", 1);
		test.put("AABBCcddEE", 1);
		test.put("AABBCcddEe", 3);
		test.put("AABbCCddEE", 1);
		test.put("AABbCCddEe", 3);
		test.put("AABbCcddEE", 3);
		test.put("AABbCcddEe", 7);
		test.put("AaBBCCddEE", 1);
		test.put("AaBBCCddEe", 3);
		test.put("AaBBCcddEE", 3);
		test.put("AaBBCcddEe", 7);
		test.put("AaBbCCddEE", 3);
		test.put("AaBbCCddEe", 7);
		test.put("AaBbCcddEE", 7);
		test.put("AaBbCcddEe", 15);
		test.put("AABBCCddee", 0);
		test.put("AABBCcddee", 1);
		test.put("AABbCCddee", 1);
		test.put("AABbCcddee", 3);
		test.put("AaBBCCddee", 1);
		test.put("AaBBCcddee", 3);
		test.put("AaBbCCddee", 3);
		test.put("AaBbCcddee", 7);
		test.put("AABBccDDEE", 0);
		test.put("AABBccDDEe", 1);
		test.put("AABBccDdEE", 1);
		test.put("AABBccDdEe", 3);
		test.put("AABbccDDEE", 1);
		test.put("AABbccDDEe", 3);
		test.put("AABbccDdEE", 3);
		test.put("AABbccDdEe", 7);
		test.put("AaBBccDDEE", 1);
		test.put("AaBBccDDEe", 3);
		test.put("AaBBccDdEE", 3);
		test.put("AaBBccDdEe", 7);
		test.put("AaBbccDDEE", 3);
		test.put("AaBbccDDEe", 7);
		test.put("AaBbccDdEE", 7);
		test.put("AaBbccDdEe", 15);
		test.put("AABBccDDee", 0);
		test.put("AABBccDdee", 1);
		test.put("AABbccDDee", 1);
		test.put("AABbccDdee", 3);
		test.put("AaBBccDDee", 1);
		test.put("AaBBccDdee", 3);
		test.put("AaBbccDDee", 3);
		test.put("AaBbccDdee", 7);
		test.put("AABBccddEE", 0);
		test.put("AABBccddEe", 1);
		test.put("AABbccddEE", 1);
		test.put("AABbccddEe", 3);
		test.put("AaBBccddEE", 1);
		test.put("AaBBccddEe", 3);
		test.put("AaBbccddEE", 3);
		test.put("AaBbccddEe", 7);
		test.put("AABBccddee", 0);
		test.put("AABbccddee", 1);
		test.put("AaBBccddee", 1);
		test.put("AaBbccddee", 3);
		test.put("AAbbCCDDEE", 0);
		test.put("AAbbCCDDEe", 1);
		test.put("AAbbCCDdEE", 1);
		test.put("AAbbCCDdEe", 3);
		test.put("AAbbCcDDEE", 1);
		test.put("AAbbCcDDEe", 3);
		test.put("AAbbCcDdEE", 3);
		test.put("AAbbCcDdEe", 7);
		test.put("AabbCCDDEE", 1);
		test.put("AabbCCDDEe", 3);
		test.put("AabbCCDdEE", 3);
		test.put("AabbCCDdEe", 7);
		test.put("AabbCcDDEE", 3);
		test.put("AabbCcDDEe", 7);
		test.put("AabbCcDdEE", 7);
		test.put("AabbCcDdEe", 15);
		test.put("AAbbCCDDee", 0);
		test.put("AAbbCCDdee", 1);
		test.put("AAbbCcDDee", 1);
		test.put("AAbbCcDdee", 3);
		test.put("AabbCCDDee", 1);
		test.put("AabbCCDdee", 3);
		test.put("AabbCcDDee", 3);
		test.put("AabbCcDdee", 7);
		test.put("AAbbCCddEE", 0);
		test.put("AAbbCCddEe", 1);
		test.put("AAbbCcddEE", 1);
		test.put("AAbbCcddEe", 3);
		test.put("AabbCCddEE", 1);
		test.put("AabbCCddEe", 3);
		test.put("AabbCcddEE", 3);
		test.put("AabbCcddEe", 7);
		test.put("AAbbCCddee", 0);
		test.put("AAbbCcddee", 1);
		test.put("AabbCCddee", 1);
		test.put("AabbCcddee", 3);
		test.put("AAbbccDDEE", 0);
		test.put("AAbbccDDEe", 1);
		test.put("AAbbccDdEE", 1);
		test.put("AAbbccDdEe", 3);
		test.put("AabbccDDEE", 1);
		test.put("AabbccDDEe", 3);
		test.put("AabbccDdEE", 3);
		test.put("AabbccDdEe", 7);
		test.put("AAbbccDDee", 0);
		test.put("AAbbccDdee", 1);
		test.put("AabbccDDee", 1);
		test.put("AabbccDdee", 3);
		test.put("AAbbccddEE", 0);
		test.put("AAbbccddEe", 1);
		test.put("AabbccddEE", 1);
		test.put("AabbccddEe", 3);
		test.put("AAbbccddee", 0);
		test.put("Aabbccddee", 1);
		test.put("aaBBCCDDEE", 0);
		test.put("aaBBCCDDEe", 1);
		test.put("aaBBCCDdEE", 1);
		test.put("aaBBCCDdEe", 3);
		test.put("aaBBCcDDEE", 1);
		test.put("aaBBCcDDEe", 3);
		test.put("aaBBCcDdEE", 3);
		test.put("aaBBCcDdEe", 7);
		test.put("aaBbCCDDEE", 1);
		test.put("aaBbCCDDEe", 3);
		test.put("aaBbCCDdEE", 3);
		test.put("aaBbCCDdEe", 7);
		test.put("aaBbCcDDEE", 3);
		test.put("aaBbCcDDEe", 7);
		test.put("aaBbCcDdEE", 7);
		test.put("aaBbCcDdEe", 15);
		test.put("aaBBCCDDee", 0);
		test.put("aaBBCCDdee", 1);
		test.put("aaBBCcDDee", 1);
		test.put("aaBBCcDdee", 3);
		test.put("aaBbCCDDee", 1);
		test.put("aaBbCCDdee", 3);
		test.put("aaBbCcDDee", 3);
		test.put("aaBbCcDdee", 7);
		test.put("aaBBCCddEE", 0);
		test.put("aaBBCCddEe", 1);
		test.put("aaBBCcddEE", 1);
		test.put("aaBBCcddEe", 3);
		test.put("aaBbCCddEE", 1);
		test.put("aaBbCCddEe", 3);
		test.put("aaBbCcddEE", 3);
		test.put("aaBbCcddEe", 7);
		test.put("aaBBCCddee", 0);
		test.put("aaBBCcddee", 1);
		test.put("aaBbCCddee", 1);
		test.put("aaBbCcddee", 3);
		test.put("aaBBccDDEE", 0);
		test.put("aaBBccDDEe", 1);
		test.put("aaBBccDdEE", 1);
		test.put("aaBBccDdEe", 3);
		test.put("aaBbccDDEE", 1);
		test.put("aaBbccDDEe", 3);
		test.put("aaBbccDdEE", 3);
		test.put("aaBbccDdEe", 7);
		test.put("aaBBccDDee", 0);
		test.put("aaBBccDdee", 1);
		test.put("aaBbccDDee", 1);
		test.put("aaBbccDdee", 3);
		test.put("aaBBccddEE", 0);
		test.put("aaBBccddEe", 1);
		test.put("aaBbccddEE", 1);
		test.put("aaBbccddEe", 3);
		test.put("aaBBccddee", 0);
		test.put("aaBbccddee", 1);
		test.put("aabbCCDDEE", 0);
		test.put("aabbCCDDEe", 1);
		test.put("aabbCCDdEE", 1);
		test.put("aabbCCDdEe", 3);
		test.put("aabbCcDDEE", 1);
		test.put("aabbCcDDEe", 3);
		test.put("aabbCcDdEE", 3);
		test.put("aabbCcDdEe", 7);
		test.put("aabbCCDDee", 0);
		test.put("aabbCCDdee", 1);
		test.put("aabbCcDDee", 1);
		test.put("aabbCcDdee", 3);
		test.put("aabbCCddEE", 0);
		test.put("aabbCCddEe", 1);
		test.put("aabbCcddEE", 1);
		test.put("aabbCcddEe", 3);
		test.put("aabbCCddee", 0);
		test.put("aabbCcddee", 1);
		test.put("aabbccDDEE", 0);
		test.put("aabbccDDEe", 1);
		test.put("aabbccDdEE", 1);
		test.put("aabbccDdEe", 3);
		test.put("aabbccDDee", 0);
		test.put("aabbccDdee", 1);
		test.put("aabbccddEE", 0);
		test.put("aabbccddEe", 1);
		test.put("aabbccddee", 0);
		
		int totalResultsSize = 1024;
		boolean didTestFail = false;
		
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneFiveHomoDBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", false, true, false),
				new Gene("B", false, true, false),
				new Gene("C", false, true, false),
				new Gene("D", false, true, false),
				new Gene("E", false, true, false)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", false, true, false),
				new Gene("B", false, true, false),
				new Gene("C", false, true, false),
				new Gene("D", false, true, false),
				new Gene("E", false, true, false)});
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		test.put("AABBCCDDEE", 1023);
		
		int totalResultsSize = 1024;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
	@Test
	void resultsCheckForGeneFiveHomoRBothParents()
	{
		PunnettMeCalculations pm = new PunnettMeCalculations();
		Parent parentOne = new Parent();
		Parent parentTwo = new Parent();
		
		parentOne.setRawGenes(new Gene[] {
				new Gene("A", false, false, true),
				new Gene("B", false, false, true),
				new Gene("C", false, false, true),
				new Gene("D", false, false, true),
				new Gene("E", false, false, true)});
		
		parentTwo.setRawGenes(new Gene[] {
				new Gene("A", false, false, true),
				new Gene("B", false, false, true),
				new Gene("C", false, false, true),
				new Gene("D", false, false, true),
				new Gene("E", false, false, true)});
		
		pm.build(parentOne, parentTwo);
		
		List<String> sample = pm.getResults();
		
		Map<String, Integer> test = new TreeMap<>();
		test.put("aabbccddee", 1023);
		
		int totalResultsSize = 1024;
		boolean didTestFail = false;
		for (int index = 0; index < totalResultsSize; index++)
		{
			boolean foundMatch = false;
			for (Map.Entry<String, Integer> testValue: test.entrySet())
			{
				if (sample.get(index).equals(testValue.getKey()))
				{
					foundMatch = true;
					if (testValue.getValue() > -1)
					{
						testValue.setValue(testValue.getValue() - 1);
					}
					else
					{
						didTestFail = true;
						fail();
					}
				}
			}
			if (!foundMatch)
			{
				didTestFail = true;
				fail();
			}
		}
		
		assertFalse("TestFailure", didTestFail);
	}
	
}

