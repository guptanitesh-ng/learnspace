/**
 * 
 */
package com.training.restful;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Link;

import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * @author 150088
 *
 */
@Path(value = "/customer")
public class CustomerService {

    @GET
    @Produces(value = "application/vnd.training.v1.0+json, text/plain, application/xml")
    public Customer getCustomer(@QueryParam("key") String key) {
        System.out.println("Processing Request " + key);
        Customer customer = getNewCustomer(key);
        return customer;
    }

    private Customer getNewCustomer(String key) {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setAddress("My Address " + key);
        customer.setAge(30);
        customer.setName("Mike");
        customer.setEmail("a.x@f.com");
        Order order = new Order();
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setOrderId("ABJ2738");
        OrderKey orderKey = new OrderKey();
        orderKey.setOrderId(order.getOrderId());
        Map<OrderKey, Order> orders = new HashMap<>();
        orders.put(orderKey, order);

        customer.setOrders(orders);
        customer.setLink(Link.fromUri("/orders").rel("orders").type("GET")
                .title("all orders for customer").build());
        return customer;
    }

    @POST
    @Consumes("multipart/form-data")
    @Produces("application/json")
    public Customer createCustomer(@FormDataParam("name") String name,
            @FormDataParam("address") InputStream address) {
        String addressValue = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(address))) {
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            addressValue = out.toString();
            System.out.println(out.toString()); // Prints the string content read from input stream
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return getNewCustomer(addressValue);
    }
}
