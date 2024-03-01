package com.james.board.api;

import com.james.board.domain.User;
import com.james.board.dto.CreateUserRequest;
import com.james.board.dto.DeleteUserResponse;
import com.james.board.dto.UpdateUserRequest;
import com.james.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/users")
    public User saveUser(@RequestBody CreateUserRequest request) {
//        User newUser = new User();
//        newUser.setName(request.getName());
//        newUser.setEmail(request.getEmail());
//        newUser.setAge(request.getAge());

        // Builder로 Entity 생성
        User newUser = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .age(request.getAge())
                .build();
        userService.join(newUser);

        return newUser;
    }

    @GetMapping("/api/users")
    public List<User> users() {
        List<User> allUsers = userService.findAllUsers();

        return allUsers;
    }

    @GetMapping("/api/users/{userId}")
    public User findUser(@PathVariable("userId") Long userId) {
        User oneUser = userService.findOneUser(userId);

        return oneUser;
    }

    @PatchMapping("/api/users/{userId}")
    public User updateUser(@PathVariable("userId") Long userId, @RequestBody UpdateUserRequest request) {
        userService.updateUser(userId, request.getEmail(), request.getAge());
        User updatedUser = userService.findOneUser(userId);

        return updatedUser;
    }

    @PatchMapping("/api/users/{userId}/delete")
    public DeleteUserResponse deleteUser(@PathVariable("userId") Long userId) throws Exception {
        userService.deleteUser(userId);
        User user = userService.findOneUser(userId);
        if (user.getIsDeleted() != true) {
            throw new Exception("Not Deleted");
        }

        return new DeleteUserResponse(user.getId(), user.getName(), user.getIsDeleted());
    }


}
