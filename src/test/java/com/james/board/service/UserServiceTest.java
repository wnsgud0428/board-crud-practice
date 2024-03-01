package com.james.board.service;

import com.james.board.domain.user.User;
import com.james.board.domain.user.UserService;
import com.james.board.domain.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired UserRepository userRepository;

    @Test
    void 회원가입() {
        // given
        User newUser = new User();
        newUser.setName("test1");

        // when
        Long newUserId = userService.createUser(newUser);

        // then
        User findUser = userRepository.findById(newUserId).get();
        Assertions.assertThat(newUser).isEqualTo(findUser);
    }
}