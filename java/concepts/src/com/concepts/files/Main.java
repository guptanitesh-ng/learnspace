package com.concepts.files;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		DirectoryReader directoryReader = new DirectoryReader(new File("C:\\Users\\nitesh.gupta\\Downloads"));
		Node directoryTree = directoryReader.getDirectoryTree();

		printEmptyDirectories(directoryTree);

		printDirectoriesOfSize(directoryTree);

	}

	private static void printDirectoriesOfSize(Node directoryTree) {
		System.out.println(directoryTree.getName());

	}

	private static void printEmptyDirectories(Node directoryTree) {
		// TODO Auto-generated method stub

	}
}
