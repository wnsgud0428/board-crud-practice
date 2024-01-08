package com.james.board.service;

import com.james.board.domain.User;
import com.james.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 회원 가입
    @Transactional(readOnly = false)
    public Long join(User user) {
        User newUser = userRepository.save(user);

        return newUser.getId();
    }


    // 회원 조회
    public User findOneUser(Long userId) {
        User findUser = userRepository.findById(userId).get();

        return findUser;
    }

    // 회원 전체 조회
    public List<User> findAllUsers() {
        List<User> all = userRepository.findAll();

        return all;
    }

    @Transactional(readOnly = false)
    public void updateUser(Long id, String email, int age) {
        User user = userRepository.findById(id).get();
        user.setEmail(email);
        user.setAge(age);
    }

    @Transactional(readOnly = false)
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        user.setIsDeleted(true);
    }

}
