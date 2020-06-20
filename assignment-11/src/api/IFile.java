package api;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;
import java.util.List;

@MTOM
@WebService(name= "IFile" ,targetNamespace = "http://s19358/mtom")
public interface IFile {

    public static final String URI = "http://localhost:8080/mtom";

    @WebMethod(action = "http://s19358/mtom/UploadFile")
    public boolean UploadFile(String name, byte[] fileData, String[] keywords);


    @WebMethod(action = "http://s19358/mtom/QueryFile")
    public List<FILE> QueryFile(String[] keywords);

    @WebMethod(action = "http://s19358/mtom/DownloadFile")
    public FILE DownloadFile(String filename);
}
