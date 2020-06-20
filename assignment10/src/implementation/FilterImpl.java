package implementation;

import api.*;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebService( //
//        name = "IFilter", //
//        targetNamespace = "http://s19358/filter" //   bunu calistirip dene sil clienti yada wsdl i tekrar dene
)
public class FilterImpl implements IFilter {

    private static final Logger LOGGER = Logger.getAnonymousLogger();
    List<Person> personList =Person.loadData();


    public static void main(String... args) {


        Endpoint.publish(IFilter.URI, new FilterImpl());
        LOGGER.info("SERVICE STARTED");
    }

    public FilterImpl() {
    }


    public List<Person> filterBirthDate(Date d) {
        return personList.stream()
                .filter(s ->s.getBirthdate().compareTo(d) == 0)
                .collect(Collectors.toList());
    }

    public List<Person>  filterSurname(String n) {
        return  personList.stream()
                .filter(p -> p.getSurname().equals(n))
                .collect(Collectors.toList());
    }
}