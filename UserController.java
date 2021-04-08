
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public List<User> getAge(@RequestParam String name,
                                                @RequestParam("age") Integer age) {
        return userRepository.findAllByNameContainsAndAge(name, age);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        return userRepository.saveAndFlush(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {
        user.setId(id);
        return userRepository.saveAndFlush(user);
    }

    @PatchMapping("/{id}")
    public User updateAge(@PathVariable Long id,
                              @RequestParam Integer age) {
        User user = userRepository.findById(id).get();
        user.setAge(age);
        return userRepository.saveAndFlush(user);
    }



}
