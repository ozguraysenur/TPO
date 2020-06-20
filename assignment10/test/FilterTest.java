import api.IFilter;
import client.FilterImpl;
import client.FilterImplService;
import client.Person;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FilterTest {
    URL wsdl;

    {
        try {
            wsdl = new URL(IFilter.URI + "?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    FilterImplService service = new FilterImplService(wsdl);
    FilterImpl proxy = service.getFilterImplPort();

    @Test
    public void filterBirthDate() {

         List<Person> res = proxy.filterBirthDate(new XMLGregorianCalendarImpl(new GregorianCalendar(1970, Calendar.JUNE,17)));
        Assert.assertEquals(1, res.size());
    }

    @Test
    public void filterSurname() {

        List<Person> res = proxy.filterSurname("Ozgur");
        Assert.assertEquals(1, res.size());

        List<Person> res1 = proxy.filterSurname("Cevik");
        Assert.assertEquals("Cevik",res1.get(0).getSurname());
    }

}
