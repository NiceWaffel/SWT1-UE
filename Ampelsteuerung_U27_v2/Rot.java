import java.awt.Color;

public class Rot implements Farbe {

	public Farbe umschalten(boolean nachtbetrieb) {
		if(nachtbetrieb)
			return new GelbBlinkend();
		return new Orange();
	}

	public Color getAnzeigeFarbe() {
		return Color.RED;
	}
}
