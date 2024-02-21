package service;
//what is loosely coupling

import service.serviceImplement.GithubAuthenicationService;

// Tightly Coupling
public class Main {
    public static void main(String[] args) {
        AuthenticationService authenticationService = new AuthenticationService(new GithubAuthenicationService());
        authenticationService.login();
        authenticationService.signUp();
    }
}
