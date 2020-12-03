package de.nicewaffel.kaffeeautomat;

public class KaramellsirupDeko extends Decorator {

	public KaramellsirupDeko(Heissgetraenk getraenk) {
		super(getraenk);
	}
	
	@Override
	public void schrittAusfuehren() {
		super.schrittAusfuehren();
		System.out.println("Karamellsirup hinzufügen...");
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
