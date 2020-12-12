public class FussgaengerAmpel implements ICommandWithUndo {

    private int old_t2;
    private int old_t4;

    @Override
    public void execute() {
        old_t2 = Ampelschaltplan.getAmpelschaltplan().getT2();
        old_t4 = Ampelschaltplan.getAmpelschaltplan().getT4();
        Ampelschaltplan.getAmpelschaltplan().setT2(0);
        Ampelschaltplan.getAmpelschaltplan().setT4(0);
    }

    @Override
    public void undo() {
        Ampelschaltplan.getAmpelschaltplan().setT2(old_t2);
        Ampelschaltplan.getAmpelschaltplan().setT4(old_t4);
    }
    
}
