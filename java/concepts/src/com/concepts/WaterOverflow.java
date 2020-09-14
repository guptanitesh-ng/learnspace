package com.concepts;

import java.util.Scanner;

public class WaterOverflow {

	public static void main(String[] args) {
		/*System.out.println(solution(10, 6, 1));
		System.out.println(solution(9, 4, 3));
		System.out.println(solution(12, 6, 3));
		System.out.println(solution(12, 5, 3));*/
		
		try (Scanner sc = new Scanner(System.in)) {
			int numberOfTestCases = sc.nextInt();
			for (int i = 1; i <= numberOfTestCases; i++) {
				System.out.println(solution(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
		}
	}

	private static double solution(int units, int row, int column) {
		int containerCount = row * (row + 1) / 2;
		double[] containers = new double[containerCount];
		fillUnits(containers, 0, units, 1);
		
		int index = ((row-1) * ((row-1) + 1) / 2) + column-1;
		return containers[index];
		
	}

	private static void fillUnits(double[] containers, int index, double units, int currentRow) {
		if (index >= containers.length)
			return;
		if (containers[index] + units > 1) {
			double remainingUnits = units - (1 - containers[index]);
			containers[index] = 1;
			
			// determine lower container
			int nextRow = currentRow + 1;
			
			// pass on the remaining units to lower containers
			fillUnits(containers, index + currentRow, remainingUnits / 2, nextRow);
			fillUnits(containers, index + currentRow + 1, remainingUnits / 2, nextRow);
		} else {
			containers[index] += units;
		}

	}
}
