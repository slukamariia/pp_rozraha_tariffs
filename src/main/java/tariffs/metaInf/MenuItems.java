package tariffs.metaInf;

public enum MenuItems {
    PRINT("print - print all operators information"),
    ADD("add - addition operator"),
    DEL("del - delete operator"),
    ACT("act - action with an operator"),
    EXIT("exit - exit program");

    private String description;

    MenuItems(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
