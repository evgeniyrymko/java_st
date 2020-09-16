package by.rymko.controller;

import by.rymko.dto.UserDto;
import by.rymko.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userServiceMock;

    @InjectMocks
    private UserController userController;

    @Before
    public void setup() {
    //    MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    public void shouldReturnUserById() throws Exception {
        UserDto user = new UserDto(1, "Test Name", "Test Address");
        Mockito.when(userServiceMock.findById(1)).thenReturn(user);
        mockMvc.perform(get("/users/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Test Name"))
                .andExpect(jsonPath("$.address").value("Test Address"));
    }

}