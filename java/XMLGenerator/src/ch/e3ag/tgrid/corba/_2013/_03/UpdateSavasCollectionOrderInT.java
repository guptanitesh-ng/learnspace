//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.14 at 05:28:41 PM IST 
//


package ch.e3ag.tgrid.corba._2013._03;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for UpdateSavasCollectionOrderIn_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateSavasCollectionOrderIn_T">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderId">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.e3ag.ch/tgrid/corba/2013/03>TString25">
 *                 &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="string&lt;25>" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="setOrderToState">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.e3ag.ch/tgrid/corba/2013/03>TString1">
 *                 &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="string&lt;1>" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="lastModifiedTS">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.e3ag.ch/tgrid/corba/2013/03>TString26">
 *                 &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="string&lt;26>" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateSavasCollectionOrderIn_T", propOrder = {
    "orderId",
    "setOrderToState",
    "lastModifiedTS"
})
public class UpdateSavasCollectionOrderInT {

    @XmlElement(required = true)
    protected UpdateSavasCollectionOrderInT.OrderId orderId;
    @XmlElement(required = true)
    protected UpdateSavasCollectionOrderInT.SetOrderToState setOrderToState;
    @XmlElement(required = true)
    protected UpdateSavasCollectionOrderInT.LastModifiedTS lastModifiedTS;

    /**
     * Gets the value of the orderId property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSavasCollectionOrderInT.OrderId }
     *     
     */
    public UpdateSavasCollectionOrderInT.OrderId getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSavasCollectionOrderInT.OrderId }
     *     
     */
    public void setOrderId(UpdateSavasCollectionOrderInT.OrderId value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the setOrderToState property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSavasCollectionOrderInT.SetOrderToState }
     *     
     */
    public UpdateSavasCollectionOrderInT.SetOrderToState getSetOrderToState() {
        return setOrderToState;
    }

    /**
     * Sets the value of the setOrderToState property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSavasCollectionOrderInT.SetOrderToState }
     *     
     */
    public void setSetOrderToState(UpdateSavasCollectionOrderInT.SetOrderToState value) {
        this.setOrderToState = value;
    }

    /**
     * Gets the value of the lastModifiedTS property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSavasCollectionOrderInT.LastModifiedTS }
     *     
     */
    public UpdateSavasCollectionOrderInT.LastModifiedTS getLastModifiedTS() {
        return lastModifiedTS;
    }

    /**
     * Sets the value of the lastModifiedTS property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSavasCollectionOrderInT.LastModifiedTS }
     *     
     */
    public void setLastModifiedTS(UpdateSavasCollectionOrderInT.LastModifiedTS value) {
        this.lastModifiedTS = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.e3ag.ch/tgrid/corba/2013/03>TString26">
     *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="string&lt;26>" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class LastModifiedTS {

        @XmlValue
        protected String value;
        @XmlAttribute(required = true)
        protected String type;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            if (type == null) {
                return "string<26>";
            } else {
                return type;
            }
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.e3ag.ch/tgrid/corba/2013/03>TString25">
     *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="string&lt;25>" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class OrderId {

        @XmlValue
        protected String value;
        @XmlAttribute(required = true)
        protected String type;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            if (type == null) {
                return "string<25>";
            } else {
                return type;
            }
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.e3ag.ch/tgrid/corba/2013/03>TString1">
     *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="string&lt;1>" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class SetOrderToState {

        @XmlValue
        protected String value;
        @XmlAttribute(required = true)
        protected String type;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            if (type == null) {
                return "string<1>";
            } else {
                return type;
            }
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

    }

}
