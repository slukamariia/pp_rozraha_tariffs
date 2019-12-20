package tariffs.metaInf;

public enum MenuItems {
    PRINT("PRINT - print all operators information"),
    ADD("ADD - addition operator"),
    DEL("DEL - delete operator"),
    ACT("ACT - action with an operator"),
    EXIT("EXIT - exit program");

    private String description;

    MenuItems(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
