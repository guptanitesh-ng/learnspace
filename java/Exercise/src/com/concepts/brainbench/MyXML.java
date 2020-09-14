package com.concepts.brainbench;

import java.io.Serializable;
import java.util.Vector;

public class MyXML implements Serializable {

	String name;
	String value;
	Vector subtree = new Vector();
	public MyXML() {}
	public void insert(MyXML x) {subtree.addElement(x);}
	static final long serialVersionUID = 12345;

}
