//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.14 at 05:28:41 PM IST 
//


package ch.e3ag.tgrid.corba._2013._03;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for UpdateSavasCollectionOrderOut_T complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateSavasCollectionOrderOut_T">
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
 *         &lt;element name="orderStatus">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.e3ag.ch/tgrid/corba/2013/03>TString2">
 *                 &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="string&lt;2>" />
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
 *         &lt;element name="remarks" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.e3ag.ch/tgrid/corba/2013/03}CS_B__ExDescr_T">
 *                 &lt;attGroup ref="{http://www.e3ag.ch/tgrid/corba/2013/03}TAttributeSequence1D"/>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="busEx" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.e3ag.ch/tgrid/corba/2013/03}CS_B__ExDescr_T">
 *                 &lt;attGroup ref="{http://www.e3ag.ch/tgrid/corba/2013/03}TAttributeSequence1D"/>
 *               &lt;/extension>
 *             &lt;/complexContent>
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
@XmlType(name = "UpdateSavasCollectionOrderOut_T", propOrder = {
    "orderId",
    "orderStatus",
    "lastModifiedTS",
    "remarks",
    "busEx"
})
public class UpdateSavasCollectionOrderOutT {

    @XmlElement(required = true)
    protected UpdateSavasCollectionOrderOutT.OrderId orderId;
    @XmlElement(required = true)
    protected UpdateSavasCollectionOrderOutT.OrderStatus orderStatus;
    @XmlElement(required = true)
    protected UpdateSavasCollectionOrderOutT.LastModifiedTS lastModifiedTS;
    protected List<UpdateSavasCollectionOrderOutT.Remarks> remarks;
    protected List<UpdateSavasCollectionOrderOutT.BusEx> busEx;

    /**
     * Gets the value of the orderId property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSavasCollectionOrderOutT.OrderId }
     *     
     */
    public UpdateSavasCollectionOrderOutT.OrderId getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSavasCollectionOrderOutT.OrderId }
     *     
     */
    public void setOrderId(UpdateSavasCollectionOrderOutT.OrderId value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the orderStatus property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSavasCollectionOrderOutT.OrderStatus }
     *     
     */
    public UpdateSavasCollectionOrderOutT.OrderStatus getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets the value of the orderStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSavasCollectionOrderOutT.OrderStatus }
     *     
     */
    public void setOrderStatus(UpdateSavasCollectionOrderOutT.OrderStatus value) {
        this.orderStatus = value;
    }

    /**
     * Gets the value of the lastModifiedTS property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSavasCollectionOrderOutT.LastModifiedTS }
     *     
     */
    public UpdateSavasCollectionOrderOutT.LastModifiedTS getLastModifiedTS() {
        return lastModifiedTS;
    }

    /**
     * Sets the value of the lastModifiedTS property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSavasCollectionOrderOutT.LastModifiedTS }
     *     
     */
    public void setLastModifiedTS(UpdateSavasCollectionOrderOutT.LastModifiedTS value) {
        this.lastModifiedTS = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remarks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemarks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateSavasCollectionOrderOutT.Remarks }
     * 
     * 
     */
    public List<UpdateSavasCollectionOrderOutT.Remarks> getRemarks() {
        if (remarks == null) {
            remarks = new ArrayList<UpdateSavasCollectionOrderOutT.Remarks>();
        }
        return this.remarks;
    }

    /**
     * Gets the value of the busEx property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the busEx property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusEx().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateSavasCollectionOrderOutT.BusEx }
     * 
     * 
     */
    public List<UpdateSavasCollectionOrderOutT.BusEx> getBusEx() {
        if (busEx == null) {
            busEx = new ArrayList<UpdateSavasCollectionOrderOutT.BusEx>();
        }
        return this.busEx;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.e3ag.ch/tgrid/corba/2013/03}CS_B__ExDescr_T">
     *       &lt;attGroup ref="{http://www.e3ag.ch/tgrid/corba/2013/03}TAttributeSequence1D"/>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BusEx
        extends CSBExDescrT
    {

        @XmlAttribute(required = true)
        protected String index;
        @XmlAttribute(required = true)
        protected TEnumSequenceType sequenceType;

        /**
         * Gets the value of the index property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndex() {
            return index;
        }

        /**
         * Sets the value of the index property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndex(String value) {
            this.index = value;
        }

        /**
         * Gets the value of the sequenceType property.
         * 
         * @return
         *     possible object is
         *     {@link TEnumSequenceType }
         *     
         */
        public TEnumSequenceType getSequenceType() {
            return sequenceType;
        }

        /**
         * Sets the value of the sequenceType property.
         * 
         * @param value
         *     allowed object is
         *     {@link TEnumSequenceType }
         *     
         */
        public void setSequenceType(TEnumSequenceType value) {
            this.sequenceType = value;
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
     *     &lt;extension base="&lt;http://www.e3ag.ch/tgrid/corba/2013/03>TString2">
     *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="string&lt;2>" />
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
    public static class OrderStatus {

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
                return "string<2>";
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
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.e3ag.ch/tgrid/corba/2013/03}CS_B__ExDescr_T">
     *       &lt;attGroup ref="{http://www.e3ag.ch/tgrid/corba/2013/03}TAttributeSequence1D"/>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Remarks
        extends CSBExDescrT
    {

        @XmlAttribute(required = true)
        protected String index;
        @XmlAttribute(required = true)
        protected TEnumSequenceType sequenceType;

        /**
         * Gets the value of the index property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndex() {
            return index;
        }

        /**
         * Sets the value of the index property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndex(String value) {
            this.index = value;
        }

        /**
         * Gets the value of the sequenceType property.
         * 
         * @return
         *     possible object is
         *     {@link TEnumSequenceType }
         *     
         */
        public TEnumSequenceType getSequenceType() {
            return sequenceType;
        }

        /**
         * Sets the value of the sequenceType property.
         * 
         * @param value
         *     allowed object is
         *     {@link TEnumSequenceType }
         *     
         */
        public void setSequenceType(TEnumSequenceType value) {
            this.sequenceType = value;
        }

    }

}
