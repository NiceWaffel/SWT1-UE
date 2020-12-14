public class QuadriereA implements ICommandWithUndo {

    private int prev_a;

    @Override
    public void execute() {
        prev_a = MeineDaten.getSingleton().getA();
        MeineDaten.getSingleton().setA(prev_a * prev_a);
    }

    @Override
    public void undo() {
        MeineDaten.getSingleton().setA(prev_a);
    }
    
}
