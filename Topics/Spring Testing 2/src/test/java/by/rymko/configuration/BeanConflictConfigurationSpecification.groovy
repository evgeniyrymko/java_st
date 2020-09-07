package by.rymko.configuration


import by.rymko.components.music.Music
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import spock.lang.Specification

@ContextConfiguration(classes = BeanConflictConfiguration, loader = AnnotationConfigContextLoader)
class BeanConflictConfigurationSpecification extends Specification {

    @Autowired
    ApplicationContext applicationContext

    @Autowired
    @Qualifier("classicalMusic01")
    Music music

    def "application context should be loaded"() {
        expect:
        applicationContext != null
    }

    def "music should be properly injected"(){
        expect:
        music != null
    }


}