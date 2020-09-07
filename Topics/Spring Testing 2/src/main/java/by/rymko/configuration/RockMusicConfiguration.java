package by.rymko.configuration;

import by.rymko.components.music.RockMusic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.rymko.components")
public class RockMusicConfiguration {

    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }
}
