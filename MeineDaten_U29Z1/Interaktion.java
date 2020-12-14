import java.util.Scanner;

public class Interaktion {

    public static void main(String[] args) {
        new Interaktion();
    }

    public Interaktion() {
        Scanner sc = new Scanner(System.in);

        boolean wiederhole = true;
        while(wiederhole) {
            System.out.println("Wählen sie eine Aktion");
            System.out.println("[1] Quadriere A");
            System.out.println("[2] Schöne Rechnung");
            System.out.println("[3] Mischen");
            System.out.println("[4] Rückgängig");
            System.out.println("[5] Ausgeben");
            System.out.println("[6] Beenden");

            int antwort = Integer.parseInt(sc.nextLine());
            switch(antwort) {
                case 1:
                    CommandProcessor.getCommandProcessor().execute(new QuadriereA());
                    break;
                case 2:
                    CommandProcessor.getCommandProcessor().execute(new SchoeneRechnung());
                    break;
                case 3:
                    CommandProcessor.getCommandProcessor().execute(new Mischen());
                    break;
                case 4:
                    CommandProcessor.getCommandProcessor().undo(1);
                    break;
                case 5:
                    CommandProcessor.getCommandProcessor().execute(new Ausgeben());
                    break;
                case 6:
                    wiederhole = false;
                    break;
            }
        }

        sc.close();
    }

}
