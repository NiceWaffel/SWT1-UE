import java.awt.Color;
import java.awt.Graphics2D;

public class GelbBlinkend implements Farbe {

	boolean gelb = false;

	@Override
	public Farbe umschalten() {
		if (Ampelschaltplan.getAmpelschaltplan().isNachtbetrieb())
			return this;
		return new Rot();
	}

	@Override
	public void updateGraphics(Graphics2D g, int x) {
		if(gelb)
			g.setColor(Color.YELLOW);
		else
			g.setColor(Color.GRAY);
		gelb = !gelb;
		g.fillOval(x, 150, 40, 40);
	}
}
