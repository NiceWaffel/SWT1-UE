public class MeineDaten {

    private static MeineDaten singleton;

    private int a;
    private int b;
    private int c;

    private MeineDaten() {
        a = (int) (Math.random() * 400);
        b = (int) (Math.random() * 400);
        c = (int) (Math.random() * 400);
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static MeineDaten getSingleton() {
        if(singleton == null)
            singleton = new MeineDaten();
        return singleton;
    }

}
