package com.concepts.files;

import java.io.File;

public class DirectoryReader {

	private File rootDirectory;

	public DirectoryReader(File rootDirectory) {
		this.rootDirectory = rootDirectory;
	}

	public Node getDirectoryTree() {
		Node rootNode = new Node(rootDirectory.getName());
		if (rootDirectory.isDirectory())
			buildTree(rootNode, rootDirectory);

		return rootNode;
	}

	public void buildTree(Node rootNode, File directory) {
		for (File file : directory.listFiles()) {
			Node childNode = new Node(file.getName());
			rootNode.addChildNode(childNode);
			if (file.isDirectory()) {
				buildTree(childNode, file);
			} else {
				childNode.setLength(file.length());
			}
		}
	}
}
