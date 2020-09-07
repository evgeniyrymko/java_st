package by.rymko.configuration

import by.rymko.components.MusicPlayer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import spock.lang.Specification
import spock.lang.Unroll

@ContextConfiguration(classes = MusicPlayerConfiguration, loader = AnnotationConfigContextLoader)
class MusicPlayerConfigurationSpecification extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    @Autowired
    private MusicPlayer musicPlayer

    def "application context should be loaded"() {
        expect:
        applicationContext != null
    }

    @Unroll
    def "music player bean should not be null and inner fields should be injected"() {
        expect:
        musicPlayer != null
        musicPlayer.getMusic1() != null
        musicPlayer.getMusic2() != null
    }
}