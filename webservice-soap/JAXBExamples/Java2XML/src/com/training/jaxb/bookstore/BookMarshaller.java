package com.training.jaxb.bookstore;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class BookMarshaller {

	public static void main(String[] args) throws Exception {
		Book book = new Book();
		book.setAuthor("S S Timberlake");
		book.setIsbn("21334-1244-124");
		book.setName("My Life");
		book.setPublisher("B B Publishers");
		
		JAXBElement<Book> bookElement = new JAXBElement<Book>(new QName("book"), Book.class, book);
		JAXBContext jaxbContext = JAXBContext.newInstance(BookStore.class, Book.class);
		
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(bookElement, System.out);
		marshaller.marshal(bookElement, new File("./book.xml"));
		
		Book anotherBook = new Book();
		anotherBook.setAuthor("Jane Wright");
		anotherBook.setIsbn("21334-1244-66124");
		anotherBook.setName("The Proposal");
		anotherBook.setPublisher("X S Pubs.");
		
		BookStore store = new BookStore();
		store.setName("Round the Corner");
		store.setLocation("22 Max Square");
		store.getBookList().add(book);
		store.getBookList().add(anotherBook);
		marshaller.marshal(store, System.out);
	}
}
