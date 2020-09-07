package by.rymko.configuration;

import by.rymko.components.music.ClassicalMusic;
import by.rymko.components.music.Music;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.rymko.components")
public class BeanConflictConfiguration {

    @Bean
    public Music classicalMusic01() {
        return new ClassicalMusic();
    }

    @Bean
    public Music classicalMusic02() {
        return new ClassicalMusic();
    }
}
