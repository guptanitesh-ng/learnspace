package com.concepts.files;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

public class Node {

	private String name;

	private Collection<Node> childNodes;

	private long length;

	public Node(String name) {
		this.name = name;
		Comparator<Node> comparator = new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.name.compareTo(o2.name);
			}
		};
		childNodes = new TreeSet<Node>(comparator);
	}

	public void addChildNode(Node childNode) {
		childNodes.add(childNode);
	}

	public boolean isLeafNode() {
		return childNodes.isEmpty();
	}

	public int getChildCount() {
		return childNodes.size();
	}

	@Override
	public String toString() {
		if (isLeafNode())
			return "Node [name=" + name + ", length=" + length + "]";
		else
			return "Node [name=" + name + ", childNodes=" + childNodes + "]";
	}

	public void setLength(long length) {
		this.length = length;
	}

	public String getName() {
		return name;
	}
	
	public Collection<Node> getChildNodes() {
		return childNodes;
	}
}
