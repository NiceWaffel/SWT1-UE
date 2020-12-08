
import java.awt.Graphics2D;
import java.awt.Color;

public class Gruen implements Farbe {

	@Override
	public Farbe umschalten() {
		if (Ampelschaltplan.getAmpelschaltplan().isNachtbetrieb())
			return new GelbBlinkend();
		return new Gelb();
	}

	@Override
	public void updateGraphics(Graphics2D g, int x) {
		g.setColor(Color.GREEN);
		g.fillOval(x, 200, 40, 40);
	}
}
