import java.util.Scanner;

public class Interaktion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CommandProcessor commandProcessor = new CommandProcessor();

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
                    commandProcessor.execute(new QuadriereA());
                    break;
                case 2:
                    commandProcessor.execute(new SchoeneRechnung());
                    break;
                case 3:
                    commandProcessor.execute(new Mischen());
                    break;
                case 4:
                    commandProcessor.undo(1);
                    break;
                case 5:
                    commandProcessor.execute(new Ausgeben());
                    break;
                case 6:
                    wiederhole = false;
                    break;
            }
        }

        sc.close();
    }

}
