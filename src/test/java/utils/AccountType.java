package utils;

public enum  AccountType {

    //constants
    STANDARD("standard"),
    INTEREST("interest");


    private final String type;

    AccountType(String type) {
        this.type=type;
    }

    public String getType(){
        return type;
    }


}
