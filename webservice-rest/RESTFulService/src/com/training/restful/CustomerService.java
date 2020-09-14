/**
 * 
 */
package com.training.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author 150088
 *
 */
@Path(value = "/customer")
public class CustomerService {

    @GET
    @Produces(value = "application/xml")
    public Customer getCustomer() {
        System.out.println("Processing Request");
        Customer customer = new Customer();
        customer.setId(1);
        customer.setAddress("My Address");
        customer.setAge(30);
        customer.setName("Mike");
        customer.setEmail("a.x@f.com");
        return customer;
    }
}
