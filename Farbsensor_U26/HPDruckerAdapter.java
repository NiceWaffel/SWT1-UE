import java.awt.Color;

public class HPDruckerAdapter implements Drucker {
	
	private HPDrucker spezDrucker;

	public HPDruckerAdapter(HPDrucker drucker) {
		this.spezDrucker = drucker;
	}

	@Override
	public void print(Color color) {
		int c, m, y;
		c = 255 - color.getRed();
		m = 255 - color.getGreen();
		y = 255 - color.getBlue();

		spezDrucker.print(c, m, y);
	}
}
