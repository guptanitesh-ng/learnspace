//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.14 at 05:28:41 PM IST 
//


package ch.e3ag.tgrid.corba._2013._03;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="header" type="{http://www.e3ag.ch/tgrid/corba/2013/03}CS_B__Header_T"/>
 *         &lt;element name="inParam" type="{http://www.e3ag.ch/tgrid/corba/2013/03}UpdateSavasCollectionOrderIn_T"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "inParam"
})
@XmlRootElement(name = "corbaparam")
public class Corbaparam {

    @XmlElement(required = true)
    protected CSBHeaderT header;
    @XmlElement(required = true)
    protected UpdateSavasCollectionOrderInT inParam;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link CSBHeaderT }
     *     
     */
    public CSBHeaderT getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link CSBHeaderT }
     *     
     */
    public void setHeader(CSBHeaderT value) {
        this.header = value;
    }

    /**
     * Gets the value of the inParam property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSavasCollectionOrderInT }
     *     
     */
    public UpdateSavasCollectionOrderInT getInParam() {
        return inParam;
    }

    /**
     * Sets the value of the inParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSavasCollectionOrderInT }
     *     
     */
    public void setInParam(UpdateSavasCollectionOrderInT value) {
        this.inParam = value;
    }

}
