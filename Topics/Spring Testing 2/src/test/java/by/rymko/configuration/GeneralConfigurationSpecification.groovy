package by.rymko.configuration

import by.rymko.components.music.ClassicalMusic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import spock.lang.Specification

@ContextConfiguration(classes = GeneralConfiguration, loader = AnnotationConfigContextLoader)
class GeneralConfigurationSpecification extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    @Autowired
    private ClassicalMusic classicalMusic

    def "application context should be loaded"() {
        expect:
        applicationContext != null
    }

    def "classical music bean should not be null"() {
        expect:
        classicalMusic != null
    }


}