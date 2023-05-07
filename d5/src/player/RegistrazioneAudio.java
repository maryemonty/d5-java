package player;

class RegistrazioneAudio extends ElementoMultimediale {
    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo, durata);
        this.volume = volume;
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
    
    @Override
    public void play() {
        System.out.println("Riproduco la registrazione audio " + getTitolo());
        for (int i = 0; i < getDurata(); i++) {
            String punti = "!".repeat(volume);
            System.out.println(getTitolo() + " " + punti);
        }
    }

}
