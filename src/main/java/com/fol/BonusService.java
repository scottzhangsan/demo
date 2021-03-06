
/*
 * 
 */

package com.fol;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.1.2
 * Wed Nov 15 14:39:17 CST 2017
 * Generated source version: 2.1.2
 * 
 */


@WebServiceClient(name = "BonusService", 
                  wsdlLocation = "http://esb01.jqdev.saic-gm.com:7005/esb/ws/fol/bonus/v1?WSDL",
                  targetNamespace = "http://ws.agent.service.dms.sgm.com/") 
public class BonusService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://ws.agent.service.dms.sgm.com/", "BonusService");
    public final static QName BonusServicePort = new QName("http://ws.agent.service.dms.sgm.com/", "BonusServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://esb01.jqdev.saic-gm.com:7005/esb/ws/fol/bonus/v1?WSDL");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://esb01.jqdev.saic-gm.com:7005/esb/ws/fol/bonus/v1?WSDL");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public BonusService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BonusService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BonusService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns BonusOperationWebService
     */
    @WebEndpoint(name = "BonusServicePort")
    public BonusOperationWebService getBonusServicePort() {
        return super.getPort(BonusServicePort, BonusOperationWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BonusOperationWebService
     */
    @WebEndpoint(name = "BonusServicePort")
    public BonusOperationWebService getBonusServicePort(WebServiceFeature... features) {
        return super.getPort(BonusServicePort, BonusOperationWebService.class, features);
    }

}
