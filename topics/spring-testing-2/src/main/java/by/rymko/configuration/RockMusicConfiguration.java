package by.rymko.configuration;

import by.rymko.component.music.RockMusic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RockMusicConfiguration {

    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }
}
