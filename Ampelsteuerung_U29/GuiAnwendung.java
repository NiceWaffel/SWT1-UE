import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

public class GuiAnwendung {

	private JFrame frame;
	private JPanel canvas;

	public GuiAnwendung() {
		frame = new JFrame("Ampel");
		frame.setSize(400, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Shutting down...");
				System.exit(0);
			}
		});

		frame.setLayout(null);
		frame.setBackground(Color.DARK_GRAY);

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

				// Ampelleuchten Outlines
				g2d.setColor(Color.BLACK);
				g2d.drawOval(79, 99, 41, 41);
				g2d.drawOval(79, 149, 41, 41);
				g2d.drawOval(79, 199, 41, 41);
				g2d.drawOval(279, 99, 41, 41);
				g2d.drawOval(279, 149, 41, 41);
				g2d.drawOval(279, 199, 41, 41);
			}
		};
		canvas.setBounds(0, 170, 400, 340);
		frame.add(canvas);

		JButton verdoppelButton = new JButton("Umschaltzeiten Verdoppeln");
		verdoppelButton.setBounds(20, 20, 360, 24);
		verdoppelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ampelschaltplan.getAmpelschaltplan().getCommandProcessor().execute(new UmschaltzeitenVerdoppeln());
			}
		});
		frame.add(verdoppelButton);

		JButton printButton = new JButton("Umschaltzeiten drucken");
		printButton.setBounds(20, 55, 360, 24);
		printButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ampelschaltplan.getAmpelschaltplan().getCommandProcessor().execute(new UmschaltzeitenAusgeben());
			}
		});
		frame.add(printButton);

		JButton fussgaengerButton = new JButton("Zur Fußgängerampel machen");
		fussgaengerButton.setBounds(20, 90, 360, 24);
		fussgaengerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ampelschaltplan.getAmpelschaltplan().getCommandProcessor().execute(new FussgaengerAmpel());
			}
		});
		frame.add(fussgaengerButton);

		JButton undoButton = new JButton("Rückgängig machen");
		undoButton.setBounds(20, 125, 360, 24);
		undoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ampelschaltplan.getAmpelschaltplan().getCommandProcessor().undo(1);
			}
		});
		frame.add(undoButton);

		frame.setVisible(true);
	}

	public void repaint() {
		canvas.repaint();
	}
}
