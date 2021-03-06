
/*
 * 
 */

package com.cognizant;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.3.1-patch-01
 * Mon Jun 24 16:50:33 IST 2013
 * Generated source version: 2.3.1-patch-01
 * 
 */


@WebServiceClient(name = "CalculatorService", 
                  wsdlLocation = "file:/D:/Study/Web%20Service/wsdl/CalculatorService.wsdl",
                  targetNamespace = "http://cognizant.com/") 
public class CalculatorService_Service extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://cognizant.com/", "CalculatorService");
    public final static QName CalculatorPort = new QName("http://cognizant.com/", "CalculatorPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/Study/Web%20Service/wsdl/CalculatorService.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/D:/Study/Web%20Service/wsdl/CalculatorService.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public CalculatorService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CalculatorService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculatorService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CalculatorService_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }
    public CalculatorService_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CalculatorService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CalculatorService
     */
    @WebEndpoint(name = "CalculatorPort")
    public CalculatorService getCalculatorPort() {
        return super.getPort(CalculatorPort, CalculatorService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalculatorService
     */
    @WebEndpoint(name = "CalculatorPort")
    public CalculatorService getCalculatorPort(WebServiceFeature... features) {
        return super.getPort(CalculatorPort, CalculatorService.class, features);
    }

}
