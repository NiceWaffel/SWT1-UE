package de.nicewaffel.kaffeeautomat;

public class Kaffee implements Heissgetraenk {

	@Override
	public void schrittAusfuehren() {
		System.out.println("Kaffee eingießen...");
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
