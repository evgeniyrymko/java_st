package by.rymko.configuration;

import by.rymko.components.music.ClassicalMusic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.rymko.components")
public class ClassicalMusicConfiguration {

    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

}
