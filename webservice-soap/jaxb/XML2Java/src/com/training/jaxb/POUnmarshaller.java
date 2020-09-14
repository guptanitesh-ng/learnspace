package com.training.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.training.jaxb.objects.Item;
import com.training.jaxb.objects.PurchaseOrder;

public class POUnmarshaller {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrder.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		PurchaseOrder purchaseOrder = (PurchaseOrder)unmarshaller.unmarshal(new File("./Purchase_Order.xml"));
		System.out.println(purchaseOrder.getBillTo().getName());
		for (Item item : purchaseOrder.getItems().getItem()) {
			System.out.println(item.getProductName());
			System.out.println(item.getPrice());
			System.out.println(item.getQuantity());
		}		
	}

}
