package mortenpa.com.github.cusman.model;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "CUSMAN_USER")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String username;
    private String passwordHash;

    protected User () {};

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(String username, String password){
        this.username = username;
        this.passwordHash = encoder.encode(password);
        System.out.println(passwordHash);
    }

    public boolean passwordIsCorrect(String password){
        return encoder.matches(password, passwordHash);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

}