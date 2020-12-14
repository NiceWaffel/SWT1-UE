public class SchoeneRechnung implements ICommandWithUndo {

    private int prev_a;

    @Override
    public void execute() {
        prev_a = MeineDaten.getSingleton().getA();
        MeineDaten.getSingleton().setA(MeineDaten.getSingleton().getB() - MeineDaten.getSingleton().getC());
    }

    @Override
    public void undo() {
        MeineDaten.getSingleton().setA(prev_a);
    }
    
}
