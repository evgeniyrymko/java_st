package rc.bootsecurity.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.bootsecurity.db.UserRepository;
import rc.bootsecurity.model.User;

import java.util.List;

@RestController
@RequestMapping("api/public")
@CrossOrigin
public class PublicRestApiController {

    private UserRepository userRepository;

    public PublicRestApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("test")
    public String test1() {
        return "API Test";
    }

    @GetMapping("management/reports")
    public String test2() {
        return "Some report data";
    }

    @GetMapping("admin/users")
    public List<User> test3() {
        return this.userRepository.findAll();
    }
}
