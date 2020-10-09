package by.rymko.configuration;

import by.rymko.component.music.ClassicalMusic;
import by.rymko.component.music.Music;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
