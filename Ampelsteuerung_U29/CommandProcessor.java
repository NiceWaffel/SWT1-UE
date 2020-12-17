import java.util.Stack;

public class CommandProcessor {
    
    private Stack<ICommandWithUndo> history = new Stack<>();

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
}
