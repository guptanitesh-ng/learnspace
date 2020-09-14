package com.concepts.brainbench;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Previsor {

	public static void main(String[] args) throws Exception {
		/*ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(new StringBuffer("Hello\uD801\uDFFE"));
		byte bArray[] = baos.toByteArray();
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bArray));
		
		System.out.println(ois.readObject());
		System.out.println(new String(bArray));*/
		
		/*Bench bench = new Brain();
		bench.printIt();
		bench.printIt(false);*/
		
		/*ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("serialize.txt")));
		MyXML object = new MyXML();
		object.name = "name";
		object.value = "value";
		object.insert(new MyXML());
		oos.writeObject(object);
		oos.close();
		byte bArray[] = baos.toByteArray();*/
		/*ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("serialize.txt")));
		MyXML readObject = (MyXML)ois.readObject();
		System.out.println();*/
		
		/*int i1 = 2;
		int i2 = 5;
		double d;
		d = i1/i2;
		//d = 3+ i1/i2 + 2;
		System.out.println(d);*/
		
		Float f = new Float(3.1);
		Integer i = new Integer(1);
		long m = 2;
		System.out.println("r " + m+f+i);
	}
}
