package api;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService(name = "IFilter" , targetNamespace = "http://s19358/filter")
public interface IFilter {

    public static final String URI = "http://localhost:8080/filter";

    @WebMethod(action = "http://s19358/filter/birthdate")
    List<Person> filterBirthDate(Date request);

    @WebMethod(action = "http://s19358/filter/surname")
    List<Person> filterSurname(String request);


}
