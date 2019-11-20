package tariffs.command;

public class ExitCommand implements Command {
    public void exit(){
        System.exit(1);
    }
    public void execute() {
       exit();
    }
}
