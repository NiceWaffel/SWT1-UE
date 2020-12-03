import java.awt.Color;

public class ColorSensor {

	public Color getColor() {
		return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}
}
