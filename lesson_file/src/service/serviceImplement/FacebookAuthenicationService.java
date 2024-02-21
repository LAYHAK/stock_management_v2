package service.serviceImplement;

import service.IAuthenticationService;

public class FacebookAuthenicationService implements IAuthenticationService {

    @Override
    public void login() {
        System.out.println("Login with Facebook");
    }

    @Override
    public void signUp() {
        System.out.println("Sign up with Facebook");
    }
}
