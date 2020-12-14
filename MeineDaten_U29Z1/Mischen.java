public class Mischen implements ICommandWithUndo {

    @Override
    public void execute() {
        int buf = MeineDaten.getSingleton().getC();

        MeineDaten.getSingleton().setC(MeineDaten.getSingleton().getB());
        MeineDaten.getSingleton().setB(MeineDaten.getSingleton().getA());
        MeineDaten.getSingleton().setA(buf);
    }

    @Override
    public void undo() {
        int buf = MeineDaten.getSingleton().getA();
        
        MeineDaten.getSingleton().setA(MeineDaten.getSingleton().getB());
        MeineDaten.getSingleton().setB(MeineDaten.getSingleton().getC());
        MeineDaten.getSingleton().setC(buf);
    }
    
}
