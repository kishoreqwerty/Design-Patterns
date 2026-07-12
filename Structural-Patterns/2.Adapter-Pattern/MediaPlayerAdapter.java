// Target interface expected by the client
interface MediaPlayer {
    void play(String fileName);
}

// Existing implementation that already matches the interface
class MP3Player implements MediaPlayer {

    @Override
    public void play(String fileName) {
        System.out.println("Playing MP3 file: " + fileName);
    }
}

// Third-party library with an incompatible interface
class VLCPlayer {

    public void playVLC(String videoFile) {
        System.out.println("Playing VLC file: " + videoFile);
    }
}

// Adapter that converts MediaPlayer requests
// into VLCPlayer compatible calls
class VLCAdapter implements MediaPlayer {

    private VLCPlayer vlcPlayer;

    public VLCAdapter() {
        this.vlcPlayer = new VLCPlayer();
    }

    @Override
    public void play(String fileName) {
        // Translate the expected method call
        // to the actual VLC implementation
        vlcPlayer.playVLC(fileName);
    }
}

// Client class
class AudioPlayer {

    private MediaPlayer mediaPlayer;

    public AudioPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public void playMedia(String fileName) {
        mediaPlayer.play(fileName);
    }
}

// Driver code
public class Main {

    public static void main(String[] args) {

        // Native support for MP3 files
        AudioPlayer mp3Player =
                new AudioPlayer(new MP3Player());

        mp3Player.playMedia("song.mp3");

        System.out.println();

        // VLC support added using Adapter
        AudioPlayer vlcPlayer =
                new AudioPlayer(new VLCAdapter());

        vlcPlayer.playMedia("movie.vlc");
    }
}