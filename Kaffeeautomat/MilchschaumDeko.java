package de.nicewaffel.kaffeeautomat;

public class MilchschaumDeko extends Decorator {
	
	public MilchschaumDeko(Heissgetraenk getraenk) {
		super(getraenk);
	}
	
	@Override
	public void schrittAusfuehren() {
		super.schrittAusfuehren();
		System.out.println("Milchschaum hinzufügen...");
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
