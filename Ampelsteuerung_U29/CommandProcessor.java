import java.util.Stack;

public class CommandProcessor {

    private static CommandProcessor singleton;
    
    private Stack<ICommandWithUndo> history = new Stack<>();

    private CommandProcessor() {}

    public void execute(ICommand command) {
        command.execute();
        if(command instanceof ICommandWithUndo) {
            history.push((ICommandWithUndo) command);
        }
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

    ICH MUSS NOCH NEN NEUEN ORDNER FÜR DIE U29 ANLEGEN UND DIE V2 WIEDER KLONEN!!!!!

    public static CommandProcessor getCommandProcessor() {
        if(singleton == null)
            singleton = new CommandProcessor();
        return singleton;
    }
}
