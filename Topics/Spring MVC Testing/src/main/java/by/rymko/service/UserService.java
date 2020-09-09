package by.rymko.service;

import by.rymko.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private static List<UserDto> usersList = new ArrayList<>();

    public UserService() {
        UserDto user1 = new UserDto(1, "Ivan", "Grodno");
        UserDto user2 = new UserDto(2, "Petr", "Minsk");
        UserDto user3 = new UserDto(3, "Alexey", "Vitebsk");
        usersList.addAll(Arrays.asList(user1, user2, user3));
    }

    public List<UserDto> findAll() {
        return usersList;
    }
}
