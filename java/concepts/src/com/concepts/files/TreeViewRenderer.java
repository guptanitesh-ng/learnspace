package com.concepts.files;

import java.io.File;

public class TreeViewRenderer {

	static com.concepts.files.Node node;

	public static void main(String[] args) {
		DirectoryReader directoryReader = new DirectoryReader(new File("C:\\Users\\nitesh.gupta\\Downloads"));
		node = directoryReader.getDirectoryTree();
	}

	
}
