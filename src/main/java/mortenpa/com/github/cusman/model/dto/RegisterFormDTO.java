package mortenpa.com.github.cusman.model.dto;

public class RegisterFormDTO extends LoginFormDTO{

    private String passwordVerification;
    public String getPasswordVerification() {
        return passwordVerification;
    }

    public void setPasswordVerification(String passwordVerification) {
        this.passwordVerification = passwordVerification;
    }

}
