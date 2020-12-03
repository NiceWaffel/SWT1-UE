package de.nicewaffel.kaffeeautomat;

public class SchokosirupDeko extends Decorator {

	public SchokosirupDeko(Heissgetraenk getraenk) {
		super(getraenk);
	}
	
	@Override
	public void schrittAusfuehren() {
		super.schrittAusfuehren();
		System.out.println("Schokosirup hinzufügen...");
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
