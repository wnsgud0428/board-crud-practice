package com.james.board.api;

import com.james.board.domain.user.User;
import com.james.board.domain.user.dto.CreateUserRequest;
import com.james.board.domain.user.dto.DeleteUserResponse;
import com.james.board.domain.user.dto.UpdateUserRequest;
import com.james.board.domain.user.UserService;
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
        userService.createUser(newUser);

        return newUser;
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        List<User> allUsers = userService.getUserList();

        return allUsers;
    }

    @GetMapping("/api/users/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        User oneUser = userService.findUser(userId);

        return oneUser;
    }

    @PatchMapping("/api/users/{userId}")
    public User updateUser(@PathVariable("userId") Long userId, @RequestBody UpdateUserRequest request) {
        userService.updateUser(userId, request.getEmail(), request.getAge());
        User updatedUser = userService.findUser(userId);

        return updatedUser;
    }

    @PatchMapping("/api/users/{userId}/delete")
    public DeleteUserResponse deleteUser(@PathVariable("userId") Long userId) throws Exception {
        userService.deleteUser(userId);
        User user = userService.findUser(userId);
        if (user.getIsDeleted() != true) {
            throw new Exception("Not Deleted");
        }

        return new DeleteUserResponse(user.getId(), user.getName(), user.getIsDeleted());
    }


}
