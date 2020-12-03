package de.nicewaffel.kaffeeautomat;

public abstract class Decorator implements Heissgetraenk {

    protected Heissgetraenk getraenk;

    protected Decorator(Heissgetraenk getraenk) {
        this.getraenk = getraenk;
    }
    
	public void schrittAusfuehren() {
		getraenk.schrittAusfuehren();
	}
}
