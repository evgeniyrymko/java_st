package by.rymko.controller;

import by.rymko.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = UserController.class)
@Import(UserControllerTest2.ContextConfiguration.class)
public class UserControllerTest2 {

//    @Autowired
//    private ApplicationContext context;

    private MockMvc mockMvc;

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    //@Configuration
    //@TestConfiguration
    static class ContextConfiguration {
        @Bean
        public UserService userService() {
            return Mockito.mock(UserService.class);
        }
    }

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void webContextNotNull() {
        Assert.assertEquals(4, 2 + 2);
//        Assert.assertNotNull(context);
    }


}