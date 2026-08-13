package Constant;

public enum Buttons {

    REGISTER("Register"),
    LOGOUT("Log out"),
    LOGIN("Log in");

    private final String buttonName;

    Buttons(String buttonName){
        this.buttonName = buttonName;
    }
    public String getButtonName() {
        return buttonName;
    }
}


