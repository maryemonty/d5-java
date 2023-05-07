package player;

class PlayerMultimediale {
    private ElementoMultimediale[] playlist;
    private int numeroElementi;

    public PlayerMultimediale(int dimensione) {
        setPlaylist(new ElementoMultimediale[dimensione]);
        numeroElementi = 0;
    }

    public void aggiungiElemento(ElementoMultimediale elemento) {
        if (numeroElementi < getPlaylist().length) {
            getPlaylist()[numeroElementi] = elemento;
            numeroElementi++;
        } else {
            System.out.println("La playlist è piena, non è possibile aggiungere altri elementi.");
        }
    }
    
    public int getNumeroElementi() {
        return numeroElementi;
    }

	public ElementoMultimediale[] getPlaylist() {
		return playlist;
	}

	public void setPlaylist(ElementoMultimediale[] playlist) {
		this.playlist = playlist;
	}
	
	public void play(int index) {
	    if (index >= 0 && index < playlist.length) {
	        playlist[index].play();
	    } else {
	        System.out.println("Indice non valido.");
	    }
	}


}
