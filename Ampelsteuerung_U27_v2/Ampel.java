public class Ampel {

	private Farbe farbe;
	private Farbe startFarbe;

	public Ampel(Farbe startZustand) {
		this.farbe = startZustand;
		this.startFarbe = startZustand;
	}

	public void schalten() {
		farbe = farbe.umschalten();
	}

	public Farbe getFarbe() {
		return this.farbe;
	}

	public void setToStartFarbe() {
		this.farbe = startFarbe;
	}
}
