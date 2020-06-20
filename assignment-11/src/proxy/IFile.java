
package proxy;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IFile", targetNamespace = "http://s19358/mtom")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IFile {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod(operationName = "UploadFile")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "UploadFile", targetNamespace = "http://s19358/mtom", className = "proxy.UploadFile")
    @ResponseWrapper(localName = "UploadFileResponse", targetNamespace = "http://s19358/mtom", className = "proxy.UploadFileResponse")
    @Action(input = "http://s19358/mtom/IFile/UploadFileRequest", output = "http://s19358/mtom/IFile/UploadFileResponse")
    public boolean uploadFile(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        byte[] arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        List<String> arg2);

    /**
     * 
     * @param arg0
     * @return
     *     returns proxy.File
     */
    @WebMethod(operationName = "DownloadFile")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "DownloadFile", targetNamespace = "http://s19358/mtom", className = "proxy.DownloadFile")
    @ResponseWrapper(localName = "DownloadFileResponse", targetNamespace = "http://s19358/mtom", className = "proxy.DownloadFileResponse")
    @Action(input = "http://s19358/mtom/IFile/DownloadFileRequest", output = "http://s19358/mtom/IFile/DownloadFileResponse")
    public File downloadFile(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<proxy.File>
     */
    @WebMethod(operationName = "QueryFile")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "QueryFile", targetNamespace = "http://s19358/mtom", className = "proxy.QueryFile")
    @ResponseWrapper(localName = "QueryFileResponse", targetNamespace = "http://s19358/mtom", className = "proxy.QueryFileResponse")
    @Action(input = "http://s19358/mtom/IFile/QueryFileRequest", output = "http://s19358/mtom/IFile/QueryFileResponse")
    public List<File> queryFile(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

}
