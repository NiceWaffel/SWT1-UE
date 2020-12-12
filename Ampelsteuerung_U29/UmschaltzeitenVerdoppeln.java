public class UmschaltzeitenVerdoppeln implements ICommandWithUndo {

    @Override
    public void execute() {
        Ampelschaltplan.getAmpelschaltplan().setT1(Ampelschaltplan.getAmpelschaltplan().getT1() * 2);
        Ampelschaltplan.getAmpelschaltplan().setT2(Ampelschaltplan.getAmpelschaltplan().getT2() * 2);
        Ampelschaltplan.getAmpelschaltplan().setT3(Ampelschaltplan.getAmpelschaltplan().getT3() * 2);
        Ampelschaltplan.getAmpelschaltplan().setT4(Ampelschaltplan.getAmpelschaltplan().getT4() * 2);
    }

    @Override
    public void undo() {
        // Da die verdoppelten Umschaltzeiten garantiert gerade Ganzzahlen sind muss kein Snapshot gespeichert werden
        Ampelschaltplan.getAmpelschaltplan().setT1(Ampelschaltplan.getAmpelschaltplan().getT1() / 2);
        Ampelschaltplan.getAmpelschaltplan().setT2(Ampelschaltplan.getAmpelschaltplan().getT2() / 2);
        Ampelschaltplan.getAmpelschaltplan().setT3(Ampelschaltplan.getAmpelschaltplan().getT3() / 2);
        Ampelschaltplan.getAmpelschaltplan().setT4(Ampelschaltplan.getAmpelschaltplan().getT4() / 2);
    }
    
}
