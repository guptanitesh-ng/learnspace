package com.training.restful;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;

@Provider
@Produces("text/plain")
public class PlainTextWriter implements MessageBodyWriter<Customer> {

    @Override
    public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {

        System.out.println(arg0);
        return Customer.class.equals(arg0);
    }

    @Override
    public void writeTo(Customer customer, Class<?> arg1, Type arg2, Annotation[] arg3,
            MediaType arg4, MultivaluedMap<String, Object> arg5, OutputStream outputStream)
            throws IOException, WebApplicationException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, customer.toString());
    }

}
