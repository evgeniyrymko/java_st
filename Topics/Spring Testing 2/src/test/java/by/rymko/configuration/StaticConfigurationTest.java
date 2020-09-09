package by.rymko.configuration;

import by.rymko.component.music.ClassicalMusic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class StaticConfigurationTest {

    @Configuration
    static class ContextConfiguration {
        @Bean
        ClassicalMusic classicalMusic() {
            return new ClassicalMusic();
        }
    }

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ClassicalMusic classicalMusic;

    @Test
    public void contextNotNull() {
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        Assert.notNull(applicationContext);
    }

    @Test
    public void classicalMusicBeanNotNull() {
        Assert.notNull(classicalMusic);
    }
}
