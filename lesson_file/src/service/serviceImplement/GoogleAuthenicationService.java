package service.serviceImplement;

import service.IAuthenticationService;

public class GoogleAuthenicationService implements IAuthenticationService {
    @Override
    public void login() {
        System.out.println("Login with Google");
    }

    @Override
    public void signUp() {
        System.out.println("Sign up with Google");
    }
}
