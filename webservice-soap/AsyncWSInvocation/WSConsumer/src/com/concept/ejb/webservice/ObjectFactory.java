
package com.concept.ejb.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.concept.ejb.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CalculateSimpleInterest_QNAME = new QName("http://webservice.ejb.concept.com/", "calculateSimpleInterest");
    private final static QName _CalculateSimpleInterestResponse_QNAME = new QName("http://webservice.ejb.concept.com/", "calculateSimpleInterestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.concept.ejb.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculateSimpleInterest }
     * 
     */
    public CalculateSimpleInterest createCalculateSimpleInterest() {
        return new CalculateSimpleInterest();
    }

    /**
     * Create an instance of {@link CalculateSimpleInterestResponse }
     * 
     */
    public CalculateSimpleInterestResponse createCalculateSimpleInterestResponse() {
        return new CalculateSimpleInterestResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateSimpleInterest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.ejb.concept.com/", name = "calculateSimpleInterest")
    public JAXBElement<CalculateSimpleInterest> createCalculateSimpleInterest(CalculateSimpleInterest value) {
        return new JAXBElement<CalculateSimpleInterest>(_CalculateSimpleInterest_QNAME, CalculateSimpleInterest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateSimpleInterestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.ejb.concept.com/", name = "calculateSimpleInterestResponse")
    public JAXBElement<CalculateSimpleInterestResponse> createCalculateSimpleInterestResponse(CalculateSimpleInterestResponse value) {
        return new JAXBElement<CalculateSimpleInterestResponse>(_CalculateSimpleInterestResponse_QNAME, CalculateSimpleInterestResponse.class, null, value);
    }

}
