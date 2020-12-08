import java.awt.Color;

public class GelbBlinkend implements Farbe {

	public Farbe umschalten(boolean nachtbetrieb) {
		return this;
	}

	public Color getAnzeigeFarbe() {
		return Color.BLACK;
	}
}
