package by.rymko

import by.rymko.configuration.SpringConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import spock.lang.Specification

@ContextConfiguration(classes = SpringConfiguration, loader = AnnotationConfigContextLoader)
class ContextSpecification extends Specification {

    @Autowired
    private ApplicationContext applicationContext

    def "two plus two should be equal four"() {
        expect:
        2 + 2 == 4
    }

    def "application context should be loaded"() {
        expect:
        applicationContext == null
    }

}