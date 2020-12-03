package de.nicewaffel.kaffeeautomat;

public class Entkoffeiniert implements Heissgetraenk {

	@Override
	public void schrittAusfuehren() {
		System.out.println("Entkoffeinierten Kaffee eingießen...");
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
