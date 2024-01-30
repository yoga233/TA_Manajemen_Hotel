package Controller;

import Model.ModelLogin;

public class ControllerLogin {
    private ModelLogin modelLogin;

    public ControllerLogin(ModelLogin modelLogin) {
        this.modelLogin = modelLogin;
    }
    public ControllerLogin() {
        this.modelLogin = new ModelLogin();
    }

    public boolean cekLogin(String username, String password) {
        return modelLogin.cekLogin(username, password);
    }
}
