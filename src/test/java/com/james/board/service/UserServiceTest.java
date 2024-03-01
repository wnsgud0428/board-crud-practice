package com.james.board.service;

import com.james.board.domain.User;
import com.james.board.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @Test
    void 회원가입() {
        // given
        User newUser = new User();
        newUser.setName("test1");

        // when
        Long newUserId = userService.join(newUser);

        // then
        User findUser = userRepository.findById(newUserId).get();
        Assertions.assertThat(newUser).isEqualTo(findUser);
    }
}