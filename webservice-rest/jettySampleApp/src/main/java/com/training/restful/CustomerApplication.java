/**
 * 
 */
package com.training.restful;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author 150088
 *
 */
@ApplicationPath("/services")
public class CustomerApplication extends Application {

    private Set<Object> singletons = new HashSet<>();

    public CustomerApplication() {
        singletons.add(new CustomerService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    /*
     * @Override public Set<Class<?>> getClasses() { Set<Class<?>> classes = new HashSet<>();
     * classes.add(JacksonFeature.class); return classes; }
     */
}
