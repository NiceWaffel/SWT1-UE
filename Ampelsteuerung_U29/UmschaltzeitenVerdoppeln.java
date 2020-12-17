public class UmschaltzeitenVerdoppeln implements ICommandWithUndo {

    int old_t1;
    int old_t2;
    int old_t3;
    int old_t4;

    @Override
    public void execute() {
        old_t1 = Ampelschaltplan.getAmpelschaltplan().getT1();
        old_t2 = Ampelschaltplan.getAmpelschaltplan().getT2();
        old_t3 = Ampelschaltplan.getAmpelschaltplan().getT3();
        old_t4 = Ampelschaltplan.getAmpelschaltplan().getT4();

        Ampelschaltplan.getAmpelschaltplan().setT1(Ampelschaltplan.getAmpelschaltplan().getT1() * 2);
        Ampelschaltplan.getAmpelschaltplan().setT2(Ampelschaltplan.getAmpelschaltplan().getT2() * 2);
        Ampelschaltplan.getAmpelschaltplan().setT3(Ampelschaltplan.getAmpelschaltplan().getT3() * 2);
        Ampelschaltplan.getAmpelschaltplan().setT4(Ampelschaltplan.getAmpelschaltplan().getT4() * 2);
    }

    @Override
    public void undo() {
        Ampelschaltplan.getAmpelschaltplan().setT1(old_t1);
        Ampelschaltplan.getAmpelschaltplan().setT2(old_t2);
        Ampelschaltplan.getAmpelschaltplan().setT3(old_t3);
        Ampelschaltplan.getAmpelschaltplan().setT4(old_t4);
    }
    
}
