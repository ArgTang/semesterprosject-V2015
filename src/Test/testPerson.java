package Test;

import Person.Person;
import Person.ContactInfo;

/**
 * Created by steinar on 14.04.2015.
 */
public class testPerson extends Person {

    private static int sosialnumber = 1234567;
    private ContactInfo contact = new ContactInfo("adress", "em@ail.com", "city", 12345678);

    public testPerson(String firstName, String lastName, ContactInfo contact) {
        super(firstName, lastName, ++sosialnumber, contact );
    }
}