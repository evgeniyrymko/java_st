package by.itsparnter.task.controller;

import by.itsparnter.task.controller.RoomController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
@Sql(value = {"/create-rooms-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-rooms-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RoomController roomController;

    @Test
    public void testIndexPage() throws Exception {
        this.mockMvc.perform(get("/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Rooms with bulbs")));
    }

    @Test
    public void roomsListTest() throws Exception {
        this.mockMvc.perform(get("/rooms/all"))
                .andDo(print())
                .andExpect(xpath("//tr[@id='rooms-list']/td").nodeCount(1));
    }

}
