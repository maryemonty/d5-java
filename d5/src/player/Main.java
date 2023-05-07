package player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayerMultimediale player = new PlayerMultimediale(5);
        Scanner in = new Scanner(System.in);
        boolean sceltaValida = true;

        do {
            System.out.println("Scrivi I se vuoi creare una immagine, V se vuoi creare un video, \nR se vuoi creare una registrazione audio o G se vuoi eseguire la playlist: ");
            char sceltaElementoMultimediale = Character.toUpperCase(in.next().charAt(0));

            switch(sceltaElementoMultimediale) {
                case 'R':
                    System.out.println("Crea un titolo per la tua Registrazione Audio: ");
                    in.nextLine(); // 
                    String titoloRegistrazioneAudio = in.nextLine();
                    System.out.print("Aggiungi la durata della registrazione audio che hai creato per " + titoloRegistrazioneAudio + ": ");
                    int durata = in.nextInt();
                    System.out.print("Aggiungi il volume: ");
                    int volume = in.nextInt();
                    RegistrazioneAudio registrazioneAudio = new RegistrazioneAudio(titoloRegistrazioneAudio, durata, volume);
                    System.out.print("Vuoi aggiungere questo elemento alla playlist? (Y/N): ");
                    char aggiungiRegistrazione = Character.toUpperCase(in.next().charAt(0));
                    switch(aggiungiRegistrazione) {
                    case 'Y':
                    	player.aggiungiElemento(registrazioneAudio);
                    case 'N':
                    	sceltaValida = false;
                    }
                    break;
                    

                case 'I':
                	System.out.println("Crea un titolo per la tua Immagine: ");
                    in.nextLine(); 
                    String titoloImmagine = in.nextLine();
                    System.out.print("Aggiungi la luminosità con cui vuoi visualizzare " + titoloImmagine + ": ");
                    int luminosita = in.nextInt();
                    Immagine immagine = new Immagine(titoloImmagine, luminosita);
                    System.out.print("Vuoi aggiungere questo elemento alla playlist? (Y/N): ");
                    char aggiungiImmagine = Character.toUpperCase(in.next().charAt(0));
                    switch(aggiungiImmagine) {
                    case 'Y':
                    	player.aggiungiElemento(immagine);
                    case 'N':
                    	sceltaValida = false;
                    }
                    break;

                case 'V':
                	System.out.println("Crea un titolo per il tuo video: ");
                    in.nextLine(); // 
                    String titoloVideo = in.nextLine();
                    System.out.print("Aggiungi il volume per " + titoloVideo + ": ");
                    int volumeVideo = in.nextInt();
                    System.out.print("Aggiungi la luminosità: ");
                    int luminositaVideo = in.nextInt();
                    Video video = new Video(titoloVideo, luminositaVideo, volumeVideo);
                    System.out.print("Vuoi aggiungere questo elemento alla playlist? (Y/N): ");
                    char aggiungiVideo = Character.toUpperCase(in.next().charAt(0));
                    switch(aggiungiVideo) {
                    case 'Y':
                    	player.aggiungiElemento(video);
                    case 'N':
                    	sceltaValida = false;
                    }
                    break;
                    
                case 'G':
                    System.out.println("Scegli un numero da 1 a 5 o 0 per tornare indietro");
                    int libreria = in.nextInt();
                    if (libreria < 0 || libreria > 5) {
                        System.out.println("Numero non valido.");
                    }else if(libreria == 0){
                    	sceltaValida = false;
                    } 
                    else {
                        ElementoMultimediale elemento = player.getPlaylist()[libreria - 1];
                        System.out.println("Hai selezionato " + elemento.getTitolo() + "? (Y/N)");
                        char consenso = Character.toUpperCase(in.next().charAt(0));
                        if (consenso == 'Y') {
                            player.play(libreria - 1);
                            if (elemento instanceof RegistrazioneAudio) {
                                RegistrazioneAudio registrazioneAudio1 = (RegistrazioneAudio) elemento;
                                char sceltaVolume;
                                do {
                                    System.out.println("Vuoi alzare o abbassare il volume? (premi 1 per abbassare, 2 per alzare o N per uscire)");
                                    sceltaVolume = Character.toUpperCase(in.next().charAt(0));
                                    if (sceltaVolume == '1') {
                                        registrazioneAudio1.abbassaVolume();
                                        player.play(libreria - 1);
                                    } else if (sceltaVolume == '2') {
                                        registrazioneAudio1.alzaVolume();
                                        player.play(libreria - 1);
                                    } else if (sceltaVolume == 'N') {
                                        sceltaValida = false;
                                        break;
                                    } else {
                                        System.out.println("Scelta non valida.");
                                    }
                                } while (sceltaVolume != 'N');
                            } else if (elemento instanceof Immagine) {
                                Immagine immagine1 = (Immagine) elemento;
                                immagine1.show();
                                char sceltaLuminosita;
                                do {
                                    System.out.println("Vuoi alzare o abbassare la luminosità? (premi 1 per abbassare, 2 per alzare o N per uscire)");
                                    sceltaLuminosita = Character.toUpperCase(in.next().charAt(0));
                                    if (sceltaLuminosita == '1') {
                                    	immagine1.abbassaLuminosita();
                                    	immagine1.show();
                                    } else if (sceltaLuminosita == '2') {
                                    	immagine1.alzaLuminosita();
                                    	immagine1.show();
                                    } else if (sceltaLuminosita == 'N') {
                                        sceltaValida = false;
                                        break;
                                    } else {
                                        System.out.println("Scelta non valida.");
                                    }
                                } while (sceltaLuminosita != 'N');
                            } else if (elemento instanceof Video) {
                                Video video1 = (Video) elemento;
                                video1.playVideo();
                                char sceltaLuminosita;
                                do {
                                    System.out.println("Premi 1 per abbassare la luminosità, 2 per alzare la luminosità, \n3 per abbassare il volume e 4 per alzare il volumte o N per uscire");
                                    sceltaLuminosita = Character.toUpperCase(in.next().charAt(0));
                                    if (sceltaLuminosita == '1') {
                                    	video1.abbassaLuminosita();
                                    	video1.playVideo();
                                    } else if (sceltaLuminosita == '2') {
                                    	video1.alzaLuminosita();
                                    	video1.playVideo();
                                    } 
                                    else if (sceltaLuminosita == '3') {
                                    	video1.alzaVolume();
                                    	video1.playVideo();
                                    }else if (sceltaLuminosita == '4') {
                                    	video1.abbassaVolume();
                                    	video1.playVideo();
                                    }else if (sceltaLuminosita == 'N') {
                                        sceltaValida = false;
                                        break;
                                    } else {
                                        System.out.println("Scelta non valida.");
                                    }
                                } while (sceltaLuminosita != 'N');
                            }
                            
                        }
                    }
                    break;



                default:
                    System.out.println("Scelta non valida.");
                    sceltaValida = false;
                    break;
            }
        } while(!sceltaValida);

        in.close();
    }
}