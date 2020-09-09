package by.rymko.controller;

import by.rymko.configuration.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration(classes = SpringConfiguration.class)
public class UserControllerTest {

    @Autowired
    private ApplicationContext context;

//    private MockMvc mockMvc;

//    @Before
//    public void setup() {
//        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.webApplicationContext);
//        this.mockMvc = builder.build();
//    }

    @Test
    public void webContextNotNull() {
        int amount = 0;
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
            amount++;
        }
        System.out.println(amount);
        Assert.notNull(context);
    }
}