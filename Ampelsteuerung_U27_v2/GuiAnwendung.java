import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class GuiAnwendung {

	private JFrame frame;
	private JPanel canvas;

	public GuiAnwendung() {
		frame = new JFrame("Ampel");
		frame.setSize(400, 340);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Shutting down...");
				System.exit(0);
			}
		});

		canvas = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.setBackground(Color.DARK_GRAY);
				g2d.setColor(Color.DARK_GRAY);
				g2d.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

				g2d.setColor(Color.LIGHT_GRAY);
				g2d.drawString("Hauptstraßenampel", 100 - g2d.getFontMetrics().stringWidth("Hauptstraßenampel") / 2,
						50);
				g2d.drawString("Nebenstraßenampel", 300 - g2d.getFontMetrics().stringWidth("Nebenstraßenampel") / 2,
						50);

				// Zeichnet die Ampel
				g2d.setColor(Color.GRAY);
				g2d.fillRect(60, 80, 80, 180);
				g2d.fillRect(260, 80, 80, 180);
				g2d.fillRect(95, 260, 10, 80);
				g2d.fillRect(295, 260, 10, 80);
				g2d.setStroke(new BasicStroke(3f));
				g2d.setColor(Color.BLACK);
				g2d.drawRect(59, 81, 81, 181);
				g2d.drawRect(259, 81, 81, 181);
				g2d.drawRect(94, 261, 11, 81);
				g2d.drawRect(294, 261, 11, 81);

				Ampelschaltplan.getAmpelschaltplan().getHauptAmpel().getFarbe().updateGraphics(g2d, 80);
				Ampelschaltplan.getAmpelschaltplan().getNebenAmpel().getFarbe().updateGraphics(g2d, 280);

				// Ampelleutchten Outlines
				g2d.setColor(Color.BLACK);
				g2d.drawOval(79, 99, 41, 41);
				g2d.drawOval(79, 149, 41, 41);
				g2d.drawOval(79, 199, 41, 41);
				g2d.drawOval(279, 99, 41, 41);
				g2d.drawOval(279, 149, 41, 41);
				g2d.drawOval(279, 199, 41, 41);
			}
		};
		frame.add(canvas);
		frame.setVisible(true);
	}

	public void repaint() {
		canvas.repaint();
	}
}
