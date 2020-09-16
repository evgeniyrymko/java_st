package by.rymko.controller;

import by.rymko.configuration.SpringConfiguration;
import by.rymko.dto.UserDto;
import by.rymko.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringConfiguration.class)
public class UserControllerTest3 {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private UserService userServiceMock = Mockito.mock(UserService.class);

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void webContextNotNull() {
        Assert.assertNotNull(wac);
    }

    @Test
    public void givenWacWhenServletContextThenItProvidesControllers() {
        ServletContext servletContext = wac.getServletContext();
        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("userController"));
        Assert.assertNotNull(wac.getBean("helloController"));
        Assert.assertNotNull(wac.getBean("userService"));
    }

    @Test
    public void shouldReturnUserById() throws Exception {
        UserDto user = new UserDto(1, "Test Name", "Test Address");
        Mockito.when(userServiceMock.findById(1)).thenReturn(user);
        mockMvc.perform(get("/users/1"))
                .andDo(MockMvcResultHandlers.print());
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(1))
//                .andExpect(jsonPath("$.name").value("Test Name"))
//                .andExpect(jsonPath("$.address").value("Test Address"));
    }

}