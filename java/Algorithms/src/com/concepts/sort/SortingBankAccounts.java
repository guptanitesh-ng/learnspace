package com.concepts.sort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class SortingBankAccounts {

	/*public static void main(String[] args) throws Exception {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));
		SortingBankAccounts bankAccountsSorting = new SortingBankAccounts();
		try {
			String inputTextLine = bufferRead.readLine();
			int numberOfTestCases = Integer.valueOf(inputTextLine);
			for (int i = 1; i <= numberOfTestCases; i++) {
				inputTextLine = bufferRead.readLine();
				int noOfAccounts = Integer.valueOf(inputTextLine);
				String[] accounts = new String[noOfAccounts];
				for (int j = 0; j < noOfAccounts; j++) {
					accounts[j] = bufferRead.readLine();
				}
				bankAccountsSorting.sort(accounts);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

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

	public void sort(String[] accounts) throws Exception {
		long l = System.currentTimeMillis();
		Arrays.sort(accounts);
		long m = System.currentTimeMillis();		
		int count = 1;
		String lastValue = null;
		
		BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out),
				1 * 1024 * 1024);
		/*BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out),
				70 * 1024 * 1024);*/
		for (String account : accounts) {
			if (account.equals(lastValue)) {
				count++;
			} else {
				lastValue = account;
				writer.write(account + " " + count + "\n");
			}
		}
		long n = System.currentTimeMillis();
		writer.flush();
		System.out.println("Break up : " + (m-l) + " "
				+ (System.currentTimeMillis() - n));
	}	
}
