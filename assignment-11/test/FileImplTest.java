
import api.FILE;
import api.IFile;
import org.junit.Assert;
import org.junit.Test;
import proxy.FileImplService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FileImplTest {


    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }

    URL wsdl;

    {
        try {
            wsdl = new URL(IFile.URI + "?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    FileImplService service = new FileImplService(wsdl);
    proxy.IFile proxy = service.getIFilePort();

    File file = new File("src/SampleFiles/file1");
    @Test
    public void uploadFile() throws IOException {


        Assert.assertNotNull(file);
        Assert.assertTrue(file.exists());
        Assert.assertTrue(proxy.uploadFile(file.getName(),
                Files.readAllBytes(file.toPath()),
                Arrays.asList(file.canRead() + " ", file.canWrite() + " ", file.getAbsolutePath())));
    }

    @Test
    public void queryFile() {

        Assert.assertEquals(1,proxy.queryFile(Arrays.asList(file.canRead() + " ")).size());
    }

    @Test
    public void downloadFile() throws IOException {

        proxy.File filee = proxy.downloadFile(file.getName());
        Assert.assertNotNull(filee);
        Assert.assertArrayEquals(filee.getRawData(), Files.readAllBytes(file.toPath()));
    }
}