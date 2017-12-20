
package com.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddResponse_QNAME = new QName("http://inf.service.app.demo.sysware.com/", "addResponse");
    private final static QName _GetRetInfoResponse_QNAME = new QName("http://inf.service.app.demo.sysware.com/", "getRetInfoResponse");
    private final static QName _GetRetInfo_QNAME = new QName("http://inf.service.app.demo.sysware.com/", "getRetInfo");
    private final static QName _AddEmployeeResponse_QNAME = new QName("http://inf.service.app.demo.sysware.com/", "addEmployeeResponse");
    private final static QName _AddEmployee_QNAME = new QName("http://inf.service.app.demo.sysware.com/", "addEmployee");
    private final static QName _Add_QNAME = new QName("http://inf.service.app.demo.sysware.com/", "add");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddEmployee }
     * 
     */
    public AddEmployee createAddEmployee() {
        return new AddEmployee();
    }

    /**
     * Create an instance of {@link GetRetInfoResponse }
     * 
     */
    public GetRetInfoResponse createGetRetInfoResponse() {
        return new GetRetInfoResponse();
    }

    /**
     * Create an instance of {@link Add }
     * 
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link Department }
     * 
     */
    public Department createDepartment() {
        return new Department();
    }

    /**
     * Create an instance of {@link RetInfo }
     * 
     */
    public RetInfo createRetInfo() {
        return new RetInfo();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link GetRetInfo }
     * 
     */
    public GetRetInfo createGetRetInfo() {
        return new GetRetInfo();
    }

    /**
     * Create an instance of {@link AddEmployeeResponse }
     * 
     */
    public AddEmployeeResponse createAddEmployeeResponse() {
        return new AddEmployeeResponse();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inf.service.app.demo.sysware.com/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<AddResponse>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRetInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inf.service.app.demo.sysware.com/", name = "getRetInfoResponse")
    public JAXBElement<GetRetInfoResponse> createGetRetInfoResponse(GetRetInfoResponse value) {
        return new JAXBElement<GetRetInfoResponse>(_GetRetInfoResponse_QNAME, GetRetInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRetInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inf.service.app.demo.sysware.com/", name = "getRetInfo")
    public JAXBElement<GetRetInfo> createGetRetInfo(GetRetInfo value) {
        return new JAXBElement<GetRetInfo>(_GetRetInfo_QNAME, GetRetInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inf.service.app.demo.sysware.com/", name = "addEmployeeResponse")
    public JAXBElement<AddEmployeeResponse> createAddEmployeeResponse(AddEmployeeResponse value) {
        return new JAXBElement<AddEmployeeResponse>(_AddEmployeeResponse_QNAME, AddEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inf.service.app.demo.sysware.com/", name = "addEmployee")
    public JAXBElement<AddEmployee> createAddEmployee(AddEmployee value) {
        return new JAXBElement<AddEmployee>(_AddEmployee_QNAME, AddEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://inf.service.app.demo.sysware.com/", name = "add")
    public JAXBElement<Add> createAdd(Add value) {
        return new JAXBElement<Add>(_Add_QNAME, Add.class, null, value);
    }

}
