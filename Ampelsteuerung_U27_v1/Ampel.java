public class Ampel {

	private boolean nachtbetrieb = false;
	private Farbe farbe;
	private Farbe startFarbe;

	public Ampel(Farbe startZustand) {
		this.farbe = startZustand;
		this.startFarbe = startZustand;
	}

	public void schalten() {
		farbe = farbe.umschalten(this.nachtbetrieb);
	}

	public Farbe getFarbe() {
		return this.farbe;
	}

	public boolean isNachtbetrieb() {
		return this.nachtbetrieb;
	}

	public void setNachtbetrieb(boolean val) {
		if(!val && this.nachtbetrieb)
			this.farbe = startFarbe; // Bei Umschalten in Tagbetrieb wird wieder bei der Startfarbe gestartet
		this.nachtbetrieb = val;
	}
}
