package mortenpa.com.github.cusman.model.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDTO {

    @NotNull
    @NotBlank
    @Size(min = 4, max = 32, message = "Invalid username. Username must be between 4 and 32 characters")
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 64, message = "Invalid password. Password must be between 8 and 64 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
