package com.james.board.api;

import com.james.board.domain.post.Post;
import com.james.board.domain.post.PostService;
import com.james.board.domain.post.dto.CreatePostRequest;
import com.james.board.domain.post.dto.EditPostRequest;
import com.james.board.domain.post.dto.GetPostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostApiController {
    private final PostService postService;

    @PostMapping("/api/posts")
    public Long createPost(@RequestBody CreatePostRequest request) {
        Long postId = postService.createPost(request.getAuthorId(), request.getTitle(), request.getContent());

        return postId;
    }

    @GetMapping("/api/posts/{postId}")
    public GetPostResponse getPost(@PathVariable("postId") Long postId) {
        Post post = postService.getPost(postId);

        return new GetPostResponse(post.getId(), post.getTitle(), post.getContent());
    }

    @PatchMapping("/api/posts/{postId}")
    public Long editPost(@PathVariable Long postId, @RequestBody EditPostRequest request) {
        postService.editPost(postId, request.getNewTitle(), request.getNewContent());

        return postId;
    }
}
