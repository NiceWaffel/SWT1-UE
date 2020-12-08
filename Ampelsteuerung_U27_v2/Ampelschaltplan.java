public class Ampelschaltplan {

    public static Ampelschaltplan singleton;
    private boolean nachtbetrieb;

    private Ampel hauptAmpel;
    private Ampel nebenAmpel;

    private GuiAnwendung gui;

	public static void main(String[] args) {
		singleton = new Ampelschaltplan();
	}

    private Ampelschaltplan() {
        this.nachtbetrieb = false;
        hauptAmpel = new Ampel(new Gruen());
        nebenAmpel = new Ampel(new Rot());

        gui = new GuiAnwendung();

		Thread ampelController = new Thread(new Runnable() {
            private int uptime = 0;
			@Override
			public void run() {
				try {
					while(true) {
						if((uptime / 30) % 2 == 0) {
                            if(nachtbetrieb) {
                                hauptAmpel.setToStartFarbe();
                                nebenAmpel.setToStartFarbe();
                                nachtbetrieb = false;
                            }
							uptime += 6;

							Thread.sleep(4500);
							hauptAmpel.schalten();
							nebenAmpel.schalten();
							gui.repaint(); // Anzeige aktualisieren

							Thread.sleep(1500);
							hauptAmpel.schalten();
							nebenAmpel.schalten();
							gui.repaint();
						} else {
							nachtbetrieb = true;
							uptime += 1;

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
}
