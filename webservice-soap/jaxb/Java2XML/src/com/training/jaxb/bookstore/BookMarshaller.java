package com.training.jaxb.bookstore;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class BookMarshaller {

	public static void main(String[] args) throws Exception {
		Book book = new Book();
		book.setAuthor("S S Timberlake");
		book.setIsbn("21334-1244-124");
		book.setName("My Life");
		book.setPublisher("B B Publishers");
		JAXBContext jaxbContext = JAXBContext.newInstance(BookStore.class, Book.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(book, System.out);
		marshaller.marshal(book, new File("./book.xml"));
		
		BookStore store = new BookStore();
		store.setName("Round the Corner");
		store.setLocation("22 Max Square");
		store.getBookList().add(book);
		marshaller.marshal(store, System.out);
	}
}
