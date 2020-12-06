import java.awt.Color;

public class Gruen implements Farbe {

	public Farbe umschalten(boolean nachtbetrieb) {
		if(nachtbetrieb)
			return new GelbBlinkend();
		return new Gelb();
	}

	public Color getAnzeigeFarbe() {
		return Color.GREEN;
	}
}
