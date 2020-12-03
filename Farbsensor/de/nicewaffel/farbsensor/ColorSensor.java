import java.awt.Color;

public class ColorSensor {

	public Color getColor() {
		return new Color(Math.random() * 255, Math.random() * 255, Math.random() * 255);
	}
}
