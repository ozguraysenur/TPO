
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
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

    private final static QName _FilterBirthDate_QNAME = new QName("http://implementation/", "filterBirthDate");
    private final static QName _FilterSurnameResponse_QNAME = new QName("http://implementation/", "filterSurnameResponse");
    private final static QName _FilterBirthDateResponse_QNAME = new QName("http://implementation/", "filterBirthDateResponse");
    private final static QName _FilterSurname_QNAME = new QName("http://implementation/", "filterSurname");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FilterSurnameResponse }
     * 
     */
    public FilterSurnameResponse createFilterSurnameResponse() {
        return new FilterSurnameResponse();
    }

    /**
     * Create an instance of {@link FilterBirthDateResponse }
     * 
     */
    public FilterBirthDateResponse createFilterBirthDateResponse() {
        return new FilterBirthDateResponse();
    }

    /**
     * Create an instance of {@link FilterSurname }
     * 
     */
    public FilterSurname createFilterSurname() {
        return new FilterSurname();
    }

    /**
     * Create an instance of {@link FilterBirthDate }
     * 
     */
    public FilterBirthDate createFilterBirthDate() {
        return new FilterBirthDate();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterBirthDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://implementation/", name = "filterBirthDate")
    public JAXBElement<FilterBirthDate> createFilterBirthDate(FilterBirthDate value) {
        return new JAXBElement<FilterBirthDate>(_FilterBirthDate_QNAME, FilterBirthDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterSurnameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://implementation/", name = "filterSurnameResponse")
    public JAXBElement<FilterSurnameResponse> createFilterSurnameResponse(FilterSurnameResponse value) {
        return new JAXBElement<FilterSurnameResponse>(_FilterSurnameResponse_QNAME, FilterSurnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterBirthDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://implementation/", name = "filterBirthDateResponse")
    public JAXBElement<FilterBirthDateResponse> createFilterBirthDateResponse(FilterBirthDateResponse value) {
        return new JAXBElement<FilterBirthDateResponse>(_FilterBirthDateResponse_QNAME, FilterBirthDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterSurname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://implementation/", name = "filterSurname")
    public JAXBElement<FilterSurname> createFilterSurname(FilterSurname value) {
        return new JAXBElement<FilterSurname>(_FilterSurname_QNAME, FilterSurname.class, null, value);
    }

}
