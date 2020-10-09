package by.rymko.component;

import by.rymko.component.music.Music;

public class MusicPlayer {

    private Music music1;

    private Music music2;

    public MusicPlayer(Music music1, Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public Music getMusic1() {
        return music1;
    }

    public Music getMusic2() {
        return music2;
    }

    public String playMusic() {
        return "Playing: " + music1.getSong() + ", " + music2.getSong();
    }
}
