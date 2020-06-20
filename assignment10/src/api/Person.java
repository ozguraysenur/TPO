package api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person{

    public String firstname;
    public String surname;
    public Date birthdate;
    public Person(){

    }

    public Person(String firstname, String surname, Date birthdate) {
        this.firstname = firstname;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return firstname;
    }



    public String getSurname() {
        return surname;
    }



    public Date getBirthdate() {
        return birthdate;
    }



    public static List<Person> loadData(){
        List<Person> tmp =new ArrayList<>();
        tmp.add(new Person("Aysenur","Ozgur", dateFormat("1997-06-08")));
        tmp.add(new Person("Aksel","Can", dateFormat("1970-06-17")));
        tmp.add(new Person("Sule","Cevik",dateFormat("1991-02-14")));
        return tmp;
    }

    public static Date dateFormat(String s){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(s);
        } catch (ParseException e) {
            System.out.println("Err in date");
            return  null;
        }

    }


}
