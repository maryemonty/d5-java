package player;

class Immagine extends ElementoMultimediale {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo, luminosita);
        this.luminosita = luminosita;
    }

    public void abbassaLuminosita() {
        luminosita = luminosita > 0 ? luminosita - 1 : 0;
    }

    public void alzaLuminosita() {
        luminosita++;
    }
    
    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    public void show() {
        System.out.print(getTitolo() + " ");
        for(int i = 0; i < luminosita; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public void play() {
    }
}
