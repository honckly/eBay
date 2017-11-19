package getCommonWords;

import java.util.ArrayList;

import org.junit.Test;

public class stepDefinition extends getCommonWords {
	@Test
	public void testBruteForceGetIntersection(){
		ArrayList<String> str1 = new ArrayList<String>();
		ArrayList<String> str2 = new ArrayList<String>();
		ArrayList<String> intersect = new ArrayList<String>();
		
		str1.add("Grab");
		str1.add("Singapore");
		str2.add("Welcome");
		str2.add("to");
		str2.add("Singapore");

		long startTime =  System.nanoTime();
		intersect = getCommonWords_BruteForce(str1,str2);
		long endTime = System.nanoTime();
		
		System.out.print("Brute Force Get Intersection result:"+intersect+ "\nExution time:"+(endTime-startTime)+"ns\r\n");
	}
	
	@Test
	public void testHashGetIntersection(){
		ArrayList<String> str1 = new ArrayList<String>();
		ArrayList<String> str2 = new ArrayList<String>();
		ArrayList<String> intersect = new ArrayList<String>();
		
		str1.add("Grab");
		str1.add("Singapore");
		str2.add("Welcome");
		str2.add("to");
		str2.add("Singapore");

		long startTime =  System.nanoTime();
		intersect = getCommonWords_Hash(str1,str2);
		long endTime = System.nanoTime();
		
		System.out.print("Hash Get Intersection result:"+intersect+ "\nExution time:"+(endTime-startTime)+"ns\r\n");
	}
}
