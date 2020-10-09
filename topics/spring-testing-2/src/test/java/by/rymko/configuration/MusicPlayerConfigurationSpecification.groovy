package by.rymko.configuration

import by.rymko.component.MusicPlayer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = MusicPlayerConfiguration)
class MusicPlayerConfigurationSpecification extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    @Autowired
    private MusicPlayer musicPlayer

    def "application context should be loaded"() {
        expect:
        applicationContext != null
    }

    def "music player bean should not be null and inner fields should be injected"() {
        expect:
        musicPlayer != null
        musicPlayer.getMusic1() != null
        musicPlayer.getMusic2() != null
    }
}