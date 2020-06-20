package implementation;

import api.FILE;
import api.IFile;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.MTOM;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
@MTOM
@WebService( //
        name = "IFile", //
        targetNamespace = "http://s19358/mtom" //   bunu calistirip dene sil clienti yada wsdl i tekrar dene
)
public class FileImpl implements IFile {


    List<FILE> files =new ArrayList<>();

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public static void main(String... args) {


        Endpoint.publish(IFile.URI, new FileImpl());
        LOGGER.info("SERVICE STARTED");
    }

    public FileImpl() {
    }

    @Override
    public boolean UploadFile(String name, byte[] fileData, String[] keywords) {

        try {
            FILE file = new FILE(name, fileData.length, keywords, fileData);
            files.add(file);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public List<FILE> QueryFile(String[] keywords) {
        List<FILE> returningFiles =new ArrayList<>();
        for(String key : keywords){
            for (int i = 0; i < files.size() ; i++) {
                if (Arrays.asList(files.get(i).getKeywords()).contains(key)){
                    returningFiles.add(files.get(i));
                    break;
                }
            }
        }
        return returningFiles;
    }

    @Override
    public FILE DownloadFile(String filename) {
        for (int i = 0; i < files.size(); i++) {
            if(files.get(i).fileName.equals(filename)){
                return files.get(i);
            }
        }
        return null;
    }


}
