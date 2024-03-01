package com.james.board.domain.post;

import com.james.board.domain.post.dto.CreatePostRequest;
import com.james.board.domain.user.User;
import com.james.board.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 글 등록

    @Transactional(readOnly = false)
    public Long createPost(Long userId, String title, String content) {
        User author = userRepository.findById(userId).get();

        Post post = Post.createPost(author, title, content);
        postRepository.save(post);

        return post.getId();
    }

    // 글 조회
    public Post getPost(Long postId) {
        Post post = postRepository.findById(postId).get();

        return post;
    }

    // 글 전체 조회
    public List<Post> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();

        return allPosts;
    }

    // 글 수정
    @Transactional
    public void editPost(Long postId, String newTitle, String newContent) {
        Post post = postRepository.findById(postId).get();
        post.changeTitle(newTitle);
        post.changeContent(newContent);
    }

}