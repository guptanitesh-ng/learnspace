package com.training.restful;

import java.util.Map;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    @XmlAttribute
    private int id;
    @XmlElement
    private String name;
    @XmlElement
    private String address;
    @XmlElement
    private int age;
    @XmlElement
    private String email;
    @XmlElement
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private Link link;

    private Map<OrderKey, Order> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age
                + ", email=" + email + ", link=" + link + ", orders=" + orders + "]";
    }

    public Map<OrderKey, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<OrderKey, Order> orders) {
        this.orders = orders;
    }
}
