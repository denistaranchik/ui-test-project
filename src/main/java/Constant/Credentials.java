package Constant;

public enum Credentials {

    VALID_EMAIL("tva428870@gmail.com"),
    INVALID_EMAIL("tva428870gmail.com"),
    VALID_PASSWORD("qwerty2111"),
    INVALID_PASSWORD("qwerty21111");

    private final String credentialsName;

    Credentials(String credentialsName) {
        this.credentialsName = credentialsName;
    }
    public String getCredentials() {
        return credentialsName;
    }
}
