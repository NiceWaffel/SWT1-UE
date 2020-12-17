public class Mischen implements ICommandWithUndo {

    int old_a;
    int old_b;
    int old_c;

    @Override
    public void execute() {
        old_a = MeineDaten.getSingleton().getA();
        old_b = MeineDaten.getSingleton().getB();
        old_c = MeineDaten.getSingleton().getC();

        MeineDaten.getSingleton().setC(old_b);
        MeineDaten.getSingleton().setB(old_a);
        MeineDaten.getSingleton().setA(old_c);
    }

    @Override
    public void undo() {
        MeineDaten.getSingleton().setA(old_a);
        MeineDaten.getSingleton().setB(old_b);
        MeineDaten.getSingleton().setC(old_c);
    }
    
}
