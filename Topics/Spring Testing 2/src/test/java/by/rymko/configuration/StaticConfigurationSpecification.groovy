package by.rymko.configuration

import by.rymko.components.music.ClassicalMusic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import spock.lang.Specification

//@ContextConfiguration(loader = AnnotationConfigContextLoader)
class StaticConfigurationSpecification extends Specification {

    @Configuration
    static class ContextConfiguration {
        @Bean
        ClassicalMusic classicalMusic() {
            return new ClassicalMusic()
        }
    }

    @Autowired
    ApplicationContext applicationContext

    @Autowired
    ClassicalMusic classicalMusic

    def "application context should be loaded"() {
        expect:
        applicationContext != null
    }

    def "classical music bean should be defined in static configuration class"() {
        expect:
        classicalMusic != null
    }
}