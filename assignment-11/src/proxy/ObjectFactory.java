
package proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the proxy package. 
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

    private final static QName _UploadFile_QNAME = new QName("http://s19358/mtom", "UploadFile");
    private final static QName _DownloadFile_QNAME = new QName("http://s19358/mtom", "DownloadFile");
    private final static QName _DownloadFileResponse_QNAME = new QName("http://s19358/mtom", "DownloadFileResponse");
    private final static QName _QueryFile_QNAME = new QName("http://s19358/mtom", "QueryFile");
    private final static QName _QueryFileResponse_QNAME = new QName("http://s19358/mtom", "QueryFileResponse");
    private final static QName _UploadFileResponse_QNAME = new QName("http://s19358/mtom", "UploadFileResponse");
    private final static QName _UploadFileArg1_QNAME = new QName("", "arg1");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UploadFile }
     * 
     */
    public UploadFile createUploadFile() {
        return new UploadFile();
    }

    /**
     * Create an instance of {@link DownloadFile }
     * 
     */
    public DownloadFile createDownloadFile() {
        return new DownloadFile();
    }

    /**
     * Create an instance of {@link DownloadFileResponse }
     * 
     */
    public DownloadFileResponse createDownloadFileResponse() {
        return new DownloadFileResponse();
    }

    /**
     * Create an instance of {@link QueryFile }
     * 
     */
    public QueryFile createQueryFile() {
        return new QueryFile();
    }

    /**
     * Create an instance of {@link QueryFileResponse }
     * 
     */
    public QueryFileResponse createQueryFileResponse() {
        return new QueryFileResponse();
    }

    /**
     * Create an instance of {@link UploadFileResponse }
     * 
     */
    public UploadFileResponse createUploadFileResponse() {
        return new UploadFileResponse();
    }

    /**
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://s19358/mtom", name = "UploadFile")
    public JAXBElement<UploadFile> createUploadFile(UploadFile value) {
        return new JAXBElement<UploadFile>(_UploadFile_QNAME, UploadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://s19358/mtom", name = "DownloadFile")
    public JAXBElement<DownloadFile> createDownloadFile(DownloadFile value) {
        return new JAXBElement<DownloadFile>(_DownloadFile_QNAME, DownloadFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DownloadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://s19358/mtom", name = "DownloadFileResponse")
    public JAXBElement<DownloadFileResponse> createDownloadFileResponse(DownloadFileResponse value) {
        return new JAXBElement<DownloadFileResponse>(_DownloadFileResponse_QNAME, DownloadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://s19358/mtom", name = "QueryFile")
    public JAXBElement<QueryFile> createQueryFile(QueryFile value) {
        return new JAXBElement<QueryFile>(_QueryFile_QNAME, QueryFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://s19358/mtom", name = "QueryFileResponse")
    public JAXBElement<QueryFileResponse> createQueryFileResponse(QueryFileResponse value) {
        return new JAXBElement<QueryFileResponse>(_QueryFileResponse_QNAME, QueryFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadFileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://s19358/mtom", name = "UploadFileResponse")
    public JAXBElement<UploadFileResponse> createUploadFileResponse(UploadFileResponse value) {
        return new JAXBElement<UploadFileResponse>(_UploadFileResponse_QNAME, UploadFileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "arg1", scope = UploadFile.class)
    public JAXBElement<byte[]> createUploadFileArg1(byte[] value) {
        return new JAXBElement<byte[]>(_UploadFileArg1_QNAME, byte[].class, UploadFile.class, ((byte[]) value));
    }

}
