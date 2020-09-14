package com.concepts.sort;

import java.util.Random;

public class BankAccountSortingInputGenerator {

	public static void main(String[] args) throws Exception {
		Random random = new Random();
		int noOfInput = random.nextInt(10000) + 90000;
		String[] accounts = new String[noOfInput];
		for (int i = 0; i < noOfInput; i++) {
			int controlCode = random.nextInt(99);
			int bankCode = random.nextInt(99999999);
			int ownerBlock1 = random.nextInt(9999);
			int ownerBlock2 = random.nextInt(9999);
			int ownerBlock3 = random.nextInt(9999);
			int ownerBlock4 = random.nextInt(9999);
			accounts[i] = controlCode + " " + bankCode + " " + ownerBlock1
					+ " " + ownerBlock2 + " " + ownerBlock3 + " " + ownerBlock4;
		}
		SortingBankAccounts sort = new SortingBankAccounts();
		long l = System.currentTimeMillis();
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		long initialUsedMemory = runtime.totalMemory() - runtime.freeMemory();
		sort.sort(accounts);
		long finalUsedMemory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Time taken : " + (System.currentTimeMillis() - l)
				+ " to sort " + accounts.length + " records" + " Memory used:"
				+ ((finalUsedMemory - initialUsedMemory) / (1024 * 1024)));
	}
}
