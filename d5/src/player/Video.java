package player;

class Video extends ElementoMultimediale {
    private int volume;
    private int luminosita;

    public Video(String titolo, int luminosita, int volume) {
        super(titolo, luminosita);
        this.volume = volume;
        this.luminosita = luminosita;
    }
    
    public void abbassaLuminosita() {
        luminosita = luminosita > 0 ? luminosita - 1 : 0;
    }

    public void alzaLuminosita() {
        luminosita++;
    }
    
    public int getLuminosita() {
        return this.luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    public void abbassaVolume() {
        volume = volume > 0 ? volume - 1 : 0;
    }

    public void alzaVolume() {
        volume++;
    }
    
    public int getVolume() {
        return this.volume;
    }
    
    public void playVideo() {
		System.out.println("Riproduco il video " + getTitolo());
	    for (int i = 0; i < 1; i++) {
	        String puntiEsclamativi = "!".repeat(getVolume());
	        String asterischi = "*".repeat(getLuminosita());
	        System.out.println(getTitolo() + " " + puntiEsclamativi + asterischi);
    }
}
    public void play() {
        
    }

}

