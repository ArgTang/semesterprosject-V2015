package Person;

import java.util.List;
import java.util.Set;

/**
 * Created by steinar on 27.03.2015.
 */
public abstract class Person {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber; //If we make this a number: 0304052345 will become 304052345
    private ContactInfo contactInfo;
    private String password;

    public Person(String firstName, String lastName, String socialSecurityNumber, ContactInfo contactInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.contactInfo = contactInfo;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getAdress() {
        return contactInfo.getAddress();
    }
    public String getCity() {
        return contactInfo.getCity();
    }
    public int getCitynumber() {
        return contactInfo.getCitynumber();
    }
    public String getEmail() {
        return contactInfo.getEmail();
    }
    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }
    public Set<Integer> getPhoneNumbers() {
        return contactInfo.getPhoneNumbers();
    }

    public void addPhonenumber(int phonenumber) {
        contactInfo.addPhonenumber(phonenumber);
    }
    public void addPhonenumber(List<Integer> list) { contactInfo.setPhonenumbers(list); }

    public void setPassword(String password) { this.password = password; }
}