package service;

public class AuthenticationService {
    private final IAuthenticationService authService;

    public AuthenticationService(IAuthenticationService authService) {
        this.authService = authService;
    }

    public void signUp() {
        authService.signUp();
    }

    public void login() {
        authService.login();
    }
}
