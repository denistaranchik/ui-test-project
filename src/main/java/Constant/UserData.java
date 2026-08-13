package Constant;

public enum UserData {

    FIRSTNAME("Denys"),
    LASTNAME("Dzen");

    private final String userData;

    UserData(String userData) {
        this.userData = userData;
    }
    public String getUserData() {
        return userData;
    }
}
