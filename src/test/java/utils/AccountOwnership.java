package utils;

public enum  AccountOwnership {

    JOINT("joint"),
    INDIVIDUAL("individual");


    private final String ownership;

    AccountOwnership(String ownership){
        this.ownership=ownership;
    }

    public String getOwnership() {
        return ownership;
    }
}
