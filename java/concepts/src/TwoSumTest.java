
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by tarun.rathor on 9/29/17.
 */
public class TwoSumTest extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public TwoSumTest(String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( TwoSumTest.class );
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testSinglePairResult()
	{
		Problem problem = new Problem();
		Integer[] A = {6,2,4,7,5,3};
		Integer sum = 6;

		List<List<Integer>> result = problem.twoSum(Arrays.asList(A), 6);

		assertEquals(result.size(), 1);
		List<Integer> first = result.get(0);
		Collections.sort(first);
		assertEquals((Integer)first.get(0),new Integer(2));
		assertEquals((Integer)first.get(1),new Integer(4));
	}
	/**
	 * Rigourous Test :-)
	 */
	public void testNoPairResults()
	{
		Problem problem = new Problem();
		Integer[] A = {6,2,4,7,5,3};
		Integer sum = 20;
		List<List<Integer>> result = problem.twoSum(Arrays.asList(A), sum);

		assertEquals(result.size(), 0);
	}
	public void testMultiplePairResults()
	{
		Problem problem = new Problem();
		Integer[] A = {6,2,4,7,5,3};
		Integer sum = 10;
		List<List<Integer>> result = problem.twoSum(Arrays.asList(A), sum);

		assertEquals(result.size(), 2);
		List<Integer> first = result.get(0);
		Collections.sort(first);
		List<Integer> second = result.get(1);
		Collections.sort(second);

		if(first.contains(4)) {
			assertEquals((Integer)first.get(0),new Integer(4));
			assertEquals((Integer)first.get(1),new Integer(6));
		} else if(second.contains(4)) {
			assertEquals((Integer)second.get(0),new Integer(4));
			assertEquals((Integer)second.get(1),new Integer(6));
		}else {
			assertEquals("Does not contain Pair(4,6)", true, false);
		}

		if(first.contains(3)) {
			assertEquals((Integer)first.get(0),new Integer(3));
			assertEquals((Integer)first.get(1),new Integer(7));
		} else if(second.contains(3)) {
		assertEquals((Integer)second.get(0),new Integer(3));
		assertEquals((Integer)second.get(1),new Integer(7));
		} else {
			assertEquals("Does not contain Pair(4,6)", true, false);
		}

	}
}

