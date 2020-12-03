package de.nicewaffel.kaffeeautomat;

public class Espresso implements Heissgetraenk {

	@Override
	public void schrittAusfuehren() {
		System.out.println("Espresso eingießen...");
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
