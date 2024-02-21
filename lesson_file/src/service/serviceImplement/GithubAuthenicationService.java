package service.serviceImplement;

import service.IAuthenticationService;

public class GithubAuthenicationService implements IAuthenticationService {

    @Override
    public void login() {
        System.out.println("Login with Github");
    }

    @Override
    public void signUp() {
        System.out.println("Sign up with Github");
    }
}
