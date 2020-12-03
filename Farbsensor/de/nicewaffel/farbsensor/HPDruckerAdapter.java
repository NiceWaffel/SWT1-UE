import java.awt.Color;

public class HPDruckerAdapter() implements Drucker {
	
	private HPDrucker spezDrucker;

	public HPDruckerAdapter(HPDrucker drucker) {
		this.spezDrucker = drucker;
	}

	@Override
	public void print(Color color) {
		int c, m, y;
		c = 255 - color.r;
		m = 255 - color.g;
		y = 255 - color.b;

		spezDrucker.print(c, m, y);
	}
}
