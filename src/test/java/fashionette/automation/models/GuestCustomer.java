package fashionette.automation.models;

import org.apache.tools.ant.taskdefs.email.EmailAddress;

import java.time.LocalDate;

public class GuestCustomer {
    public String name;
    public String surname;
    public LocalDate birthday;
    public EmailAddress email;
}
