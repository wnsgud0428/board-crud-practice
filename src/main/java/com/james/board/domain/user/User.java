package com.james.board.domain.user;

import com.james.board.domain.post.Post;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String email;
    private int age;
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "author")
    private List<Post> posts = new ArrayList<>();


    public User() {

    }

    @Builder
    public User(Long id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }


}
