package com.training.jaxb.bookstore;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookStore {

	private List<Book> bookList;

	private String name;
	private String location;

	@XmlAttribute(name = "title")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@XmlElementWrapper(name="booklist")
	@XmlElement(name="book")
	public List<Book> getBookList() {
		if (null == bookList) {
			bookList = new ArrayList<Book>();
		}
		return bookList;
	}

}
