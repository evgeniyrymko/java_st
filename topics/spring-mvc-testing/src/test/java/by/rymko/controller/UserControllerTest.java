package by.rymko.controller;

import by.rymko.dto.UserDto;
import by.rymko.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    public void findByIdTest() throws Exception {
        //given
        UserDto user = new UserDto(1, "Test Name", "Test Address");

        //when
        when(userServiceMock.findById(1)).thenReturn(user);

        //then
        mockMvc.perform(get("/users/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(user.getId()))
                .andExpect(jsonPath("$.name").value(user.getName()))
                .andExpect(jsonPath("$.address").value(user.getAddress()));
    }

    @Test
    public void findAllTest() throws Exception {
        //given
        UserDto user1 = new UserDto(1, "Test Name 1", "Test Address 1");
        UserDto user2 = new UserDto(2, "Test Name 2", "Test Address 2");
        List<UserDto> users = Arrays.asList(user1, user2);

        //when
        when(userServiceMock.findAll()).thenReturn(users);

        //then
        mockMvc.perform(get("/users/all"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value(user1.getName()))
                .andExpect(jsonPath("$[1].name").value(user2.getName()))
                .andExpect(jsonPath("$.length()").value(users.size()));

        verify(userServiceMock, times(1)).findAll();
        verifyNoMoreInteractions(userServiceMock);

    }

    @Test
    public void addUserTest() throws Exception {
        //given
        UserDto userDtoReq = new UserDto("Test Name", "Test Address");
        UserDto userDtoReqFail = new UserDto("", "Test Address");
        UserDto userDtoRes = new UserDto(1, userDtoReq.getName(), userDtoReq.getAddress());
        ObjectMapper mapper = new ObjectMapper();
        String userDtoReqJson = mapper.writeValueAsString(userDtoReq);
        String userDtoReqFailJson = mapper.writeValueAsString(userDtoReqFail);

        //when
        when(userServiceMock.addUser(any(UserDto.class))).thenReturn(userDtoRes);

        //then
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userDtoReqFailJson)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(userDtoRes.getId()))
                .andExpect(jsonPath("$.name").value(userDtoRes.getName()))
                .andExpect(jsonPath("$.address").value(userDtoRes.getAddress()));

        verify(userServiceMock, times(1)).addUser(any(UserDto.class));
        verifyNoMoreInteractions(userServiceMock);
    }

}