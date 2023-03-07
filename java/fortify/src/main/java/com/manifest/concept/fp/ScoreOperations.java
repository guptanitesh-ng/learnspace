package com.manifest.concept.fp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreOperations {

	private static ScoreInfo[] scoreData = new ScoreInfo[] { new ScoreInfo("Smith", "John", 70),
			new ScoreInfo("Doe", "Mary", 85), new ScoreInfo("Page", "Alice", 82), new ScoreInfo("Cooper", "Jill", 97),
			new ScoreInfo("Flintstone", "Fred", 66), new ScoreInfo("Rubble", "Barney", 80),
			new ScoreInfo("Smith", "Judy", 48), new ScoreInfo("Dean", "James", 90), new ScoreInfo("Russ", "Joe", 55),
			new ScoreInfo("Wolfe", "Bill", 73), new ScoreInfo("Dart", "Mary", 54), new ScoreInfo("Rogers", "Chris", 78),
			new ScoreInfo("Toole", "Pat", 51), new ScoreInfo("Khan", "Omar", 93), new ScoreInfo("Smith", "Ann", 95) };

	public static void main(String[] args) {
		System.out.println("Count of students ==>" + Arrays.stream(scoreData).count());

		System.out.println("Average score of all students ==>"
				+ Arrays.stream(scoreData).collect(Collectors.averagingInt(ScoreInfo::getScore)));

		System.out.println("Count of students scoring an 'A' ==>"
				+ Arrays.stream(scoreData).filter(s -> s.getScore() >= 90).count());

		System.out.println("Students scoring below 70 ==>");
		List<String> studentsScoringBelow70 = Arrays.stream(scoreData).filter(s -> s.getScore() < 70)
				.map(s -> s.getFirstName() + " " + s.getLastName()).collect(Collectors.toList());
		studentsScoringBelow70.stream().forEach(name -> System.out.println(name));

		System.out.println("Students ordered by last name ==>");
		Arrays.stream(scoreData).sorted((s1, s2) -> s1.getLastName().compareTo(s2.getLastName()))
				.forEach(System.out::println);
		
		System.out.println("Students ordered by score ==>");
		Arrays.stream(scoreData).sorted((s1, s2) -> s1.getScore()-s2.getScore())
				.forEach((s) -> System.out.println(s));
	}

}
