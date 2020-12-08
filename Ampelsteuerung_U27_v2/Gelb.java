import java.awt.Color;
import java.awt.Graphics2D;

public class Gelb implements Farbe {

	@Override
	public Farbe umschalten() {
		if (Ampelschaltplan.getAmpelschaltplan().isNachtbetrieb())
			return new GelbBlinkend();
		return new Rot();
	}

	@Override
	public void updateGraphics(Graphics2D g, int x) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, 150, 40, 40);
	}
}
