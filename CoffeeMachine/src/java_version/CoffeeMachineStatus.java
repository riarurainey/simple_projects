package java_version;

public enum CoffeeMachineStatus {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit");

    private final String statusName;

    CoffeeMachineStatus(String str) {
        this.statusName = str;
    }
}