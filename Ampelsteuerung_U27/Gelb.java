import java.awt.Color;

public class Gelb implements Farbe {

	public Farbe umschalten(boolean nachtbetrieb) {
		if(nachtbetrieb)
			return new GelbBlinkend();
		return new Rot();
	}

	public Color getAnzeigeFarbe() {
		return Color.YELLOW;
	}
}
