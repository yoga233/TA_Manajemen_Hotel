package Entity;

public class LoginEntity extends UserEntity {
    public LoginEntity() {
        super("admin", "admin");
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

