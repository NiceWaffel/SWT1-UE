import java.awt.Color;

public class Orange implements Farbe {

	public Farbe umschalten(boolean nachtbetrieb) {
		if(nachtbetrieb)
			return new GelbBlinkend();
		return new Gruen();
	}

	public Color getAnzeigeFarbe() {
		return Color.ORANGE;
	}
}
