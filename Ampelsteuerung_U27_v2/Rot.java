import java.awt.Color;
import java.awt.Graphics2D;

public class Rot implements Farbe {

	@Override
	public Farbe umschalten() {
		if (Ampelschaltplan.getAmpelschaltplan().isNachtbetrieb())
			return new GelbBlinkend();
		return new Orange();
	}

	@Override
	public void updateGraphics(Graphics2D g, int x) {
		g.setColor(Color.RED);
		g.fillOval(x, 100, 40, 40);
	}
}
