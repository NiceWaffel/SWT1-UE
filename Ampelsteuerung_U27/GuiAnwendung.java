import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GuiAnwendung {

	private JFrame frame;
	private JPanel canvas;

	private Thread ampelController = null;

	private Ampel hauptAmpel;
	private Ampel nebenAmpel;
	private int uptime = 0;

	public static void main(String[] args) {
		new GuiAnwendung();
	}

	public GuiAnwendung() {
		hauptAmpel = new Ampel(new Gruen());
		nebenAmpel = new Ampel(new Rot());

		frame = new JFrame("Ampel");
		frame.setSize(400, 340);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Shutting down...");
				ampelController.stop();
				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
			}

			@Override
			public void windowActivated(WindowEvent arg0) {
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
			}

		});

		canvas = new JPanel() {
			private static final long serialVersionUID = 1L;

			private boolean blinkendAn = false;

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

				switch (hauptAmpel.getFarbe().getAnzeigeFarbe().getRGB()) {
					case 0xffff0000:
						System.out.println("Hauptampel: ROT");
						g2d.setColor(Color.RED);
						g2d.fillOval(80, 100, 40, 40);
						break;
					case 0xff00ff00:
						System.out.println("Hauptampel: GRÜN");
						g2d.setColor(Color.GREEN);
						g2d.fillOval(80, 200, 40, 40);
						break;
					case 0xffffff00:
						System.out.println("Hauptampel: GELB");
						g2d.setColor(Color.YELLOW);
						g2d.fillOval(80, 150, 40, 40);
						break;
					case 0xffffc800:
						System.out.println("Hauptampel: ORANGE");
						g2d.setColor(Color.RED);
						g2d.fillOval(80, 100, 40, 40);
						g2d.setColor(Color.YELLOW);
						g2d.fillOval(80, 150, 40, 40);
						break;
					case 0xff000000:
						if(blinkendAn) {
							g2d.setColor(Color.YELLOW);
							g2d.fillOval(80, 150, 40, 40);
						}
						break;

					default:
						break;
				}

				switch (nebenAmpel.getFarbe().getAnzeigeFarbe().getRGB()) {
					case 0xffff0000:
						System.out.println("Nebenampel: ROT");
						g2d.setColor(Color.RED);
						g2d.fillOval(280, 100, 40, 40);
						break;
					case 0xff00ff00:
						System.out.println("Nebenampel: GRÜN");
						g2d.setColor(Color.GREEN);
						g2d.fillOval(280, 200, 40, 40);
						break;
					case 0xffffff00:
						System.out.println("Nebenampel: GELB");
						g2d.setColor(Color.YELLOW);
						g2d.fillOval(280, 150, 40, 40);
						break;
					case 0xffffc800:
						System.out.println("Nebenampel: ORANGE");
						g2d.setColor(Color.RED);
						g2d.fillOval(280, 100, 40, 40);
						g2d.setColor(Color.YELLOW);
						g2d.fillOval(280, 150, 40, 40);
						break;
					case 0xff000000:
						if(blinkendAn) {
							g2d.setColor(Color.YELLOW);
							g2d.fillOval(280, 150, 40, 40);
						}
						break;

					default:
						break;
				}

				g2d.setColor(Color.BLACK);
				g2d.drawOval(79, 99, 41, 41);
				g2d.drawOval(79, 149, 41, 41);
				g2d.drawOval(79, 199, 41, 41);

				g2d.drawOval(279, 99, 41, 41);
				g2d.drawOval(279, 149, 41, 41);
				g2d.drawOval(279, 199, 41, 41);

				blinkendAn = !blinkendAn;
			}
		};
		frame.add(canvas);
		frame.setVisible(true);

		ampelController = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while(true) {
						if((uptime / 30) % 2 == 0) {
							hauptAmpel.setNachtbetrieb(false);
							nebenAmpel.setNachtbetrieb(false);
							uptime += 6;

							Thread.sleep(4500);
							hauptAmpel.schalten();
							nebenAmpel.schalten();
							canvas.repaint(); // Anzeige aktualisieren

							Thread.sleep(1500);
							hauptAmpel.schalten();
							nebenAmpel.schalten();
							canvas.repaint();
						} else {
							hauptAmpel.setNachtbetrieb(true);
							nebenAmpel.setNachtbetrieb(true);
							uptime += 1;

							Thread.sleep(1000);
							hauptAmpel.schalten();
							nebenAmpel.schalten();
							canvas.repaint();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		ampelController.start();
	}
}
