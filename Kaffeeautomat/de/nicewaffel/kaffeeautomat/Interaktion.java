package de.nicewaffel.kaffeeautomat;

import java.util.Scanner;

public class Interaktion {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String antwort;
		System.out.println("Willkommen bei Starbox!");
		
		Heissgetraenk bestellung = null;
		
		boolean valideBestellung = false;
		while(!valideBestellung) {
			valideBestellung = true;
			
			System.out.println("Welches Getränk möchten Sie bestellen?");
			System.out.println("[1] Kaffee");
			System.out.println("[2] Entkoffeinierter Kaffee");
			System.out.println("[3] Espresso");
			System.out.println("Geben Sie die gewünschte Zahl an: ");
			
			antwort = scanner.nextLine();
			switch (antwort.trim().charAt(0)) {
				case '1':
					bestellung = new Kaffee();
					System.out.println("Sie haben einen Kaffee bestellt.");
					break;
				case '2':
					bestellung = new Entkoffeiniert();
					System.out.println("Sie haben einen entkoffeinierten Kaffee bestellt.");
					break;
				case '3':
					bestellung = new Espresso();
					System.out.println("Sie haben einen Espresso bestellt.");
					break;
				default:
					valideBestellung = false;
					System.out.println("Bitte geben Sie eine valide Zahl ein.");
					break;
			}
		}
		
		System.out.println("Wollen sie Schokosirup zu ihrem bestellten Produkt dazu? [j/n]:");
		antwort = scanner.nextLine();
		if(antwort.trim().toLowerCase().charAt(0) == 'j') {
			bestellung = new SchokosirupDeko(bestellung);
		}
		
		System.out.println("Wollen sie Karamellsirup zu ihrem bestellten Produkt dazu? [j/n]:");
		antwort = scanner.nextLine();
		if(antwort.trim().toLowerCase().charAt(0) == 'j') {
			bestellung = new KaramellsirupDeko(bestellung);
		}
		
		System.out.println("Wollen sie Milchschaum zu ihrem bestellten Produkt dazu? [j/n]:");
		antwort = scanner.nextLine();
		if(antwort.trim().toLowerCase().charAt(0) == 'j') {
			bestellung = new MilchschaumDeko(bestellung);
		}
		scanner.close();
		System.out.println(); // Leerzeile
		
		bestellung.schrittAusfuehren();
		System.out.println("Genießen Sie ihr Getränk!");
	}

}
