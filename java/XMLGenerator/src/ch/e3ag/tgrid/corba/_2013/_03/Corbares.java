//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.14 at 05:28:41 PM IST 
//


package ch.e3ag.tgrid.corba._2013._03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


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
 *         &lt;element name="returnValue">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="outParam">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="paramType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="OUT" />
 *                 &lt;anyAttribute processContents='skip'/>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="sysEx">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="paramType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="OUT" />
 *                 &lt;anyAttribute processContents='skip'/>
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
@XmlType(name = "", propOrder = {
    "returnValue",
    "outParam",
    "sysEx"
})
@XmlRootElement(name = "corbares")
public class Corbares {

    @XmlElement(required = true)
    protected Corbares.ReturnValue returnValue;
    @XmlElement(required = true)
    protected Corbares.OutParam outParam;
    @XmlElement(required = true)
    protected Corbares.SysEx sysEx;

    /**
     * Gets the value of the returnValue property.
     * 
     * @return
     *     possible object is
     *     {@link Corbares.ReturnValue }
     *     
     */
    public Corbares.ReturnValue getReturnValue() {
        return returnValue;
    }

    /**
     * Sets the value of the returnValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Corbares.ReturnValue }
     *     
     */
    public void setReturnValue(Corbares.ReturnValue value) {
        this.returnValue = value;
    }

    /**
     * Gets the value of the outParam property.
     * 
     * @return
     *     possible object is
     *     {@link Corbares.OutParam }
     *     
     */
    public Corbares.OutParam getOutParam() {
        return outParam;
    }

    /**
     * Sets the value of the outParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link Corbares.OutParam }
     *     
     */
    public void setOutParam(Corbares.OutParam value) {
        this.outParam = value;
    }

    /**
     * Gets the value of the sysEx property.
     * 
     * @return
     *     possible object is
     *     {@link Corbares.SysEx }
     *     
     */
    public Corbares.SysEx getSysEx() {
        return sysEx;
    }

    /**
     * Sets the value of the sysEx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Corbares.SysEx }
     *     
     */
    public void setSysEx(Corbares.SysEx value) {
        this.sysEx = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="paramType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="OUT" />
     *       &lt;anyAttribute processContents='skip'/>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class OutParam {

        @XmlAnyElement
        protected List<Element> any;
        @XmlAttribute(required = true)
        protected String paramType;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Element }
         * 
         * 
         */
        public List<Element> getAny() {
            if (any == null) {
                any = new ArrayList<Element>();
            }
            return this.any;
        }

        /**
         * Gets the value of the paramType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getParamType() {
            if (paramType == null) {
                return "OUT";
            } else {
                return paramType;
            }
        }

        /**
         * Sets the value of the paramType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setParamType(String value) {
            this.paramType = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ReturnValue {

        @XmlAttribute(required = true)
        protected String type;

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
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
     *     &lt;extension base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="paramType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="OUT" />
     *       &lt;anyAttribute processContents='skip'/>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class SysEx {

        @XmlAnyElement
        protected List<Element> any;
        @XmlAttribute(required = true)
        protected String paramType;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Element }
         * 
         * 
         */
        public List<Element> getAny() {
            if (any == null) {
                any = new ArrayList<Element>();
            }
            return this.any;
        }

        /**
         * Gets the value of the paramType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getParamType() {
            if (paramType == null) {
                return "OUT";
            } else {
                return paramType;
            }
        }

        /**
         * Sets the value of the paramType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setParamType(String value) {
            this.paramType = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }

    }

}
