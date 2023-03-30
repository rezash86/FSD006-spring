package com.jac.mvcproject.joinexamples.many_to_many.model;

import com.jac.mvcproject.joinexamples.one_to_many.model.Comment;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", unique = true)
    private String title;

    private String description;

    private String content;

    @ManyToMany(mappedBy = "usedPosts", cascade = CascadeType.ALL)
    List<Tag> usedTags;
}
