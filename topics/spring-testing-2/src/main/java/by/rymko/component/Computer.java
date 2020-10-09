package by.rymko.component;

public class Computer {

    private MusicPlayer musicPlayer;

    public Computer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        return "Computer" + " " + musicPlayer.playMusic();
    }
}
