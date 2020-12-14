public class Ausgeben implements ICommand {

    @Override
    public void execute() {
        System.out.println("A: " + MeineDaten.getSingleton().getA());
        System.out.println("B: " + MeineDaten.getSingleton().getB());
        System.out.println("C: " + MeineDaten.getSingleton().getC());
    }
    
}
