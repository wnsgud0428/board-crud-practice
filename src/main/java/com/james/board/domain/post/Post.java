package com.james.board.domain.post;

import com.james.board.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED) // 이유를 알고 코드를 쓰자!
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    public static Post createPost(User user, String title, String content) {
        Post post = new Post();
        post.author = user;
        post.title = title;
        post.content = content;

        return post;
    }

    public void changeTitle(String newTitle) {
        this.title = newTitle;
    }

    public void changeContent(String newContent) {
        this.content = newContent;
    }

}
