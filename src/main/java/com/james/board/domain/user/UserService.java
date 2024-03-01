package com.james.board.domain.user;

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
    public Long createUser(User user) {
        userRepository.save(user);

        return user.getId();
    }

    // 회원 조회
    public User findUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    // 회원 전체 조회
    public List<User> getUserList() {
        return userRepository.findAll();
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
