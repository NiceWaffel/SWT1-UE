import java.util.Stack;

public class CommandProcessor {

    private static CommandProcessor singleton;

    private Stack<ICommandWithUndo> history = new Stack<>();

    public void execute(ICommand command) {
        if(command instanceof ICommandWithUndo) {
            history.push((ICommandWithUndo) command);
        }
        command.execute();
    }

    public void undo(int n) {
        for(int i = 0; i < n; i++) {
            if(history.empty()) {
                System.out.println("Anfang der Historie erreicht!");
                break;
            }
            ICommandWithUndo com = history.pop();
            com.undo();
        }
    }

    public static CommandProcessor getCommandProcessor() {
        if(singleton == null)
            singleton = new CommandProcessor();
        return singleton;
    }
}
