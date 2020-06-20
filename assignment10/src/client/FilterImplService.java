
package client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "FilterImplService", targetNamespace = "http://implementation/", wsdlLocation = "http://localhost:8080/filter?wsdl")
public class FilterImplService
    extends Service
{

    private final static URL FILTERIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException FILTERIMPLSERVICE_EXCEPTION;
    private final static QName FILTERIMPLSERVICE_QNAME = new QName("http://implementation/", "FilterImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/filter?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        FILTERIMPLSERVICE_WSDL_LOCATION = url;
        FILTERIMPLSERVICE_EXCEPTION = e;
    }

    public FilterImplService() {
        super(__getWsdlLocation(), FILTERIMPLSERVICE_QNAME);
    }

    public FilterImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FILTERIMPLSERVICE_QNAME, features);
    }

    public FilterImplService(URL wsdlLocation) {
        super(wsdlLocation, FILTERIMPLSERVICE_QNAME);
    }

    public FilterImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FILTERIMPLSERVICE_QNAME, features);
    }

    public FilterImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FilterImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FilterImpl
     */
    @WebEndpoint(name = "FilterImplPort")
    public FilterImpl getFilterImplPort() {
        return super.getPort(new QName("http://implementation/", "FilterImplPort"), FilterImpl.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FilterImpl
     */
    @WebEndpoint(name = "FilterImplPort")
    public FilterImpl getFilterImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://implementation/", "FilterImplPort"), FilterImpl.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FILTERIMPLSERVICE_EXCEPTION!= null) {
            throw FILTERIMPLSERVICE_EXCEPTION;
        }
        return FILTERIMPLSERVICE_WSDL_LOCATION;
    }

}
