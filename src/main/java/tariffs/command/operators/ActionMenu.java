package tariffs.command.operators;

public enum ActionMenu {
    ADD("ADD - add tariff to operator"),
    DEL("DEL - delete an tariff"),
    FIND("FIND - show all tariffs in range"),
    BACK("BACK - go to the previous menu");

    private String description;

    ActionMenu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
