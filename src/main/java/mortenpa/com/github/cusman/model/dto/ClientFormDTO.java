package mortenpa.com.github.cusman.model.dto;

import mortenpa.com.github.cusman.model.Client;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClientFormDTO {

    private long id;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    @Size(min = 4, max = 32, message = "Invalid username. Username must be between 4 and 32 characters")
    private String username;


    @Size(min = 0, max = 254, message = "Invalid email. Username must be less than 254 characters")
    private String email;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    private String country;

    public ClientFormDTO(Client client){
        if (client != null) {
            this.id = client.getId();
            this.firstName = client.getFirstName();
            this.lastName = client.getLastName();
            this.username = client.getUsername();
            this.email = client.getEmail();
            this.address = client.getAddress();
            this.country = client.getCountry();
        }
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
