package com.manifest.concept.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PairDriver {

	/**
	 * Create several stadium pairs then print the name of the stadium with the
	 * largest capacity.
	 * 
	 * @param args Not used.
	 */
	public static void main(String[] args) {

		List<Pair<String, Integer>> stadiums = new ArrayList<>();
		stadiums.add(new Pair<>("Bridgeforth Stadium", 25000));
		stadiums.add(new Pair<>("Michigan Stadium", 109901));
		stadiums.add(new Pair<>("Lane Stadium", 66233));
		stadiums.add(new Pair<>("No Stadium", null));
		stadiums.add(new Pair<>(null, null));

		System.out.println(largestStadium(stadiums));
		
		Pair<String, Integer> p1;
	    Pair<String, ? extends Number> p2;
	    Pair<? extends Object, ? extends Object> p3;
	    Pair<?, ? extends Object> p4;
	    Pair<?, ? extends Number> p5;

	    p1 = new Pair<String, Integer>("A", 7);
	    int a = p1.getSecond();

	    // p1 = new Pair<Integer, Double>(23, 12.0);

	    p2 = new Pair<String, Integer>("B", 8);

	    p3 = new Pair<String, Integer>("C", 9);

	    p4 = new Pair<String, String>("House", "Car");
	    p4 = new Pair<String, Integer>("D", 10);

	    Object b = p4.getSecond();
	    Integer c = (Integer) p4.getSecond();

	    //p5 = new Pair<String, String>("E", "G");
	    p5 = new Pair<String, Double>("E", 11.0);
	    p5 = new Pair<String, Integer>("E", 11);

	    Number d = p5.getSecond();
	    Integer e = (Integer) p5.getSecond();
	}

	/**
	 * Returns the name of the stadium with the largest capacity.
	 * 
	 * @param stadiums An array of ObjectPairs where each pair contains a stadium
	 *                 name followed by an integer capacity
	 * @return The name of the stadium with the largest capacity
	 */
	public static Pair<String, Integer> largestStadium(List<Pair<String, Integer>> stadiums) {
		return stadiums.stream().max(new Comparator<Pair<String, Integer>>() {

			@Override
			public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {

				return (o1 == null && o2 == null) ? 0
						: (o1 == null || o1.getSecond() == null) ? -1
								: (o2 == null || o2.getSecond() == null) ? 1 : o1.getSecond().compareTo(o2.getSecond());
			}

		}).orElse(null);
	}

}
