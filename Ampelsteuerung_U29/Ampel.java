public class Ampel {

	private IFarbe farbe;
	private IFarbe startFarbe;

	public Ampel(IFarbe startZustand) {
		this.farbe = startZustand;
		this.startFarbe = startZustand;
	}

	public void schalten() {
		farbe = farbe.umschalten();
	}

	public IFarbe getFarbe() {
		return this.farbe;
	}

	public void setToStartFarbe() {
		this.farbe = startFarbe;
	}
}
