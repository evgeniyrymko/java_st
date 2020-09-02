package by.rymko;

import by.rymko.music.Music;

public class MusicPlayer {

    private Music music1;

    private Music music2;

    public MusicPlayer(Music music1, Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic() {
        return "Playing: " + music1.getSong() + ", " + music2.getSong();
    }
}
