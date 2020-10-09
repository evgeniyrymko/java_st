package by.rymko.configuration;

import by.rymko.component.MusicPlayer;
import by.rymko.component.music.ClassicalMusic;
import by.rymko.component.music.RockMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ClassicalMusicConfiguration.class, RockMusicConfiguration.class})
public class MusicPlayerConfiguration {

    @Autowired
    private ClassicalMusic classicalMusic;

    @Autowired
    private RockMusic rockMusic;

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(classicalMusic, rockMusic);
    }
}
