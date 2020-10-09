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
        UserDto user4 = new UserDto(4, "Andrey", "Schuchin");
        UserDto user5 = new UserDto(5, "Max", "Lida");
        usersList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }

    public List<UserDto> findAll() {
        return usersList;
    }

    public UserDto findById(int userId) {
        UserDto userById = null;
        for (UserDto userDto : usersList) {
            if (userDto.getId() == userId) userById = userDto;
        }
        return userById;
    }

    public UserDto addUser(UserDto userDto) {
        int maxUsersListId = usersList.stream()
                .mapToInt(UserDto::getId)
                .max()
                .orElse(0);
        userDto.setId(maxUsersListId + 1);
        usersList.add(userDto);
        return userDto;
    }
}
