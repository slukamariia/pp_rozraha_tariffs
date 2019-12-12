package tariffs.command.operators;

public enum ActionMenu {
    ADD("add - add tariff to operator"),
    DEL("del - delete an tariff"),
    FIND("find - show all tariffs in range"),
    BACK("back - go to the previous menu");

    private String description;

    ActionMenu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
