import java.awt.Graphics2D;

public interface Farbe {
	public Farbe umschalten();
	public void updateGraphics(Graphics2D g, int x);
}
