public class Ampelschaltplan {

	private static Ampelschaltplan singleton;
	private boolean nachtbetrieb;

	private Ampel hauptAmpel;
	private Ampel nebenAmpel;

	private int t1 = 4000; // Hauptampel Grün, Nebenampel Rot
	private int t2 = 1500; // Hauptampel Gelb, Nebenampel Orange
	private int t3 = 3000; // Hauptampel Rot, Nebenampel Grün
	private int t4 = 1500; // Hauptampel Orange, Nebenampel Gelb

	private GuiAnwendung gui;

	private CommandProcessor commandProcessor;

	public static void main(String[] args) {
		singleton = new Ampelschaltplan();
	}

	public CommandProcessor getCommandProcessor() {
		return commandProcessor;
	}

	private Ampelschaltplan() {
		this.nachtbetrieb = false;
		hauptAmpel = new Ampel(new Gruen());
		nebenAmpel = new Ampel(new Rot());

		commandProcessor = new CommandProcessor();

        gui = new GuiAnwendung();

		Thread ampelController = new Thread(new Runnable() {
            private int uptime = 0; // Uptime in milliseconds
			@Override
			public void run() {
				try {
					while(true) {
						if((uptime / 30000) % 2 == 0) {
                            if(nachtbetrieb) {
                                hauptAmpel.setToStartFarbe();
                                nebenAmpel.setToStartFarbe();
                                nachtbetrieb = false;
                            }
							uptime += t1 + t2 + t3 + t4;

							Thread.sleep(t1);
							hauptAmpel.schalten();
							nebenAmpel.schalten();
							gui.repaint(); // Anzeige aktualisieren

							Thread.sleep(t2);
							hauptAmpel.schalten();
							nebenAmpel.schalten();
							gui.repaint();

							Thread.sleep(t3);
							hauptAmpel.schalten();
							nebenAmpel.schalten();
							gui.repaint();

							Thread.sleep(t4);
							hauptAmpel.schalten();
							nebenAmpel.schalten();
							gui.repaint();
						} else {
							nachtbetrieb = true;
							uptime += 1000;

							Thread.sleep(1000);
							hauptAmpel.schalten();
							nebenAmpel.schalten();
							gui.repaint();
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		ampelController.start();
    }

    public Ampel getNebenAmpel() {
        return nebenAmpel;
    }

    public Ampel getHauptAmpel() {
        return hauptAmpel;
    }

    public static Ampelschaltplan getAmpelschaltplan() {
        return singleton;
    }

    public boolean isNachtbetrieb() {
        return this.nachtbetrieb;
	}
	
	public int getT4() {
		return t4;
	}

	public void setT4(int t4) {
		this.t4 = t4;
	}

	public int getT3() {
		return t3;
	}

	public void setT3(int t3) {
		this.t3 = t3;
	}

	public int getT2() {
		return t2;
	}

	public void setT2(int t2) {
		this.t2 = t2;
	}

	public int getT1() {
		return t1;
	}

	public void setT1(int t1) {
		this.t1 = t1;
	}
}
