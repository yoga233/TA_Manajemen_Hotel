package Model;

import Entity.LoginEntity;

public class ModelLogin {
    private LoginEntity login;

    public ModelLogin() {
        this.login = new LoginEntity();
    }

    public Boolean cekLogin(String username, String password) {
        return login.getUsername().equals(username) && login.getPassword().equals(password);
    }    
}
