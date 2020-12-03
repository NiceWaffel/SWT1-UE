import java.awt.Color;

public class Controller {

	private HPDrucker hpDrucker;
	private Drucker drucker;
	private ColorSensor sensor;

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.sensorFarbeDrucken();
	}

	public Controller() {
		hpDrucker = new HPDrucker();
		drucker = new HPDruckerAdapter(hpDrucker);
		sensor = new ColorSensor();
	}

	public void sensorFarbeDrucken() {
		Color color = sensor.getColor();
		drucker.print(color);
	}
}
