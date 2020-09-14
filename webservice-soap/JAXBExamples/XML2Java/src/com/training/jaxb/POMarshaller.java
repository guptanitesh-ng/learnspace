package com.training.jaxb;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.training.jaxb.objects.BillTo;
import com.training.jaxb.objects.Item;
import com.training.jaxb.objects.Items;
import com.training.jaxb.objects.PurchaseOrder;

public class POMarshaller {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		PurchaseOrder order = new PurchaseOrder();
		BillTo billTo = new BillTo();
		billTo.setCity("Kingston");
		billTo.setName("Shaun Pitt");
		billTo.setState("Wales");
		billTo.setZip("22xx");
		order.setBillTo(billTo);
		Items items = new Items();
		Item book = new Item();
		book.setPrice(new BigDecimal(579.54, MathContext.DECIMAL32));
		book.setProductName("Java Jaxb");
		book.setQuantity(new BigInteger("1"));
		items.getItem().add(book);
		order.setItems(items);
		JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrder.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(order, System.out);
		marshaller.marshal(order, new File("./PO_01.xml"));

	}

}
