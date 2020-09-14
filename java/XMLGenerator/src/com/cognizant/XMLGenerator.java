/**
 * 
 */
package com.cognizant;

import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;

import ch.e3ag.tgrid.corba._2013._03.Corbaparam;

/**
 * @author 150088
 *
 */
public class XMLGenerator {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext
				.newInstance("ch.e3ag.tgrid.corba._2013._03");
		Writer writer = new StringWriter();
		context.createMarshaller().marshal(new Corbaparam(), writer);
		System.out.println(writer.toString());
	}

}
