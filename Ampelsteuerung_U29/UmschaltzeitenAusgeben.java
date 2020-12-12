public class UmschaltzeitenAusgeben implements ICommand {

    @Override
    public void execute() {
        System.out.println("T1: " + Ampelschaltplan.getAmpelschaltplan().getT1());
        System.out.println("T2: " + Ampelschaltplan.getAmpelschaltplan().getT2());
        System.out.println("T3: " + Ampelschaltplan.getAmpelschaltplan().getT3());
        System.out.println("T4: " + Ampelschaltplan.getAmpelschaltplan().getT4());
    }

}