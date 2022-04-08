package mortenpa.com.github.cusman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String address;
    private String country;
    private String clientManagerUser;

    protected Client() {}

    public Client(String firstName, String lastName, String clientManagerUser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientManagerUser = clientManagerUser;
    }

    @Override
    public String toString() {
        return String.format(
                "Client[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getClientManagerUser() {
        return clientManagerUser;
    }

    public void setClientManagerUser(String clientManagerUser) {
        this.clientManagerUser = clientManagerUser;
    }
}