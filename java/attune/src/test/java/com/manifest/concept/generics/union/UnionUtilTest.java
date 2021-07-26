package com.manifest.concept.generics.union;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UnionUtilTest {

	@Test
	public void unionOfChocolateCakes() throws Exception {
		ChocolateCake chocolateCake1 = new ChocolateCake(1);
		ChocolateCake chocolateCake3 = new ChocolateCake(3);
		List<ChocolateCake> firstList = Arrays.asList(chocolateCake1, chocolateCake3);
		ChocolateCake chocolateCake2 = new ChocolateCake(2);
		ChocolateCake chocolateCake20 = new ChocolateCake(20);
		List<ChocolateCake> secondList = Arrays.asList(chocolateCake2, chocolateCake20);

		assertThat(UnionUtil.union(firstList, secondList)).containsExactly(chocolateCake1, chocolateCake3,
				chocolateCake2, chocolateCake20);
	}

	@Test
	public void unionOfChocolateCakesAndStuffedChocolateCakes() throws Exception {
		List<ChocolateCake> firstList = Arrays.asList(new ChocolateCake(1), new ChocolateCake(3));
		List<StuffedChocolateCake> secondList = Arrays.asList(new StuffedChocolateCake(2),
				new StuffedChocolateCake(20));
		assertThat(UnionUtil.union(firstList, secondList)).containsExactly(new ChocolateCake(1), new ChocolateCake(3),
				new StuffedChocolateCake(2), new StuffedChocolateCake(20));
	}

	@Test
	public void unionOfStuffedChocolateCakesAndChocolateCakes() throws Exception {
		List<StuffedChocolateCake> firstList = Arrays.asList(new StuffedChocolateCake(1), new StuffedChocolateCake(3));
		List<ChocolateCake> secondList = Arrays.asList(new ChocolateCake(2), new ChocolateCake(20));
		assertThat(UnionUtil.union(firstList, secondList)).containsExactly(new StuffedChocolateCake(1),
				new StuffedChocolateCake(3), new ChocolateCake(2), new ChocolateCake(20));
	}

	@Test
	public void unionOfStuffedChocolateCakesAndChocolateCakes_andThenUnionWithVanillaCakes() throws Exception {
		List<StuffedChocolateCake> firstList = Arrays.asList(new StuffedChocolateCake(1), new StuffedChocolateCake(3));
		List<ChocolateCake> secondList = Arrays.asList(new ChocolateCake(2), new ChocolateCake(20));
		List<VanillaCake> thirdList = Arrays.asList(new VanillaCake(11), new VanillaCake(22));

		assertThat(UnionUtil.union(UnionUtil.union(firstList, secondList), thirdList)).containsExactly(
				new StuffedChocolateCake(1), new StuffedChocolateCake(3), new ChocolateCake(2), new ChocolateCake(20),
				new VanillaCake(11), new VanillaCake(22));
	}

	@Test
	public void unionOfStuffedChocolateCakesAndChocolateCakes_andThenUnionWithVanillaCakes_nowWithVariables()
			throws Exception {
		List<StuffedChocolateCake> firstList = Arrays.asList(new StuffedChocolateCake(1), new StuffedChocolateCake(3));
		List<ChocolateCake> secondList = Arrays.asList(new ChocolateCake(2), new ChocolateCake(20));
		List<VanillaCake> thirdList = Arrays.asList(new VanillaCake(11), new VanillaCake(22));

		List<ChocolateCake> chocolateUnion = UnionUtil.union(firstList, secondList);
		List<Cake> fullUnion = UnionUtil.union(chocolateUnion, thirdList);
		assertThat(fullUnion).containsExactly(new StuffedChocolateCake(1), new StuffedChocolateCake(3),
				new ChocolateCake(2), new ChocolateCake(20), new VanillaCake(11), new VanillaCake(22));
	}

}