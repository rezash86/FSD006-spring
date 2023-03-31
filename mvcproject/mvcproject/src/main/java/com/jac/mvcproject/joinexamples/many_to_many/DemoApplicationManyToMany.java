package com.jac.mvcproject.joinexamples.many_to_many;

import com.jac.mvcproject.joinexamples.PostRepositoryWithTag;
import com.jac.mvcproject.joinexamples.many_to_many.model.Post;
import com.jac.mvcproject.joinexamples.many_to_many.model.Tag;
import com.jac.mvcproject.joinexamples.many_to_many.repository.StudentRepository;
import com.jac.mvcproject.joinexamples.many_to_many.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplicationManyToMany implements CommandLineRunner {

    private final PostRepositoryWithTag postRepository;
    private final TagRepository tagRepository;

    private final StudentRepository studentRepository;

    @Autowired
    public DemoApplicationManyToMany(PostRepositoryWithTag postRepository, TagRepository tagRepository, StudentRepository studentRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationManyToMany.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Tag tag1 = Tag
                .builder()
                .name("#McDonald")
                .usedPosts(new ArrayList<>())
                .build();

        Tag tag2 = Tag
                .builder()
                .name("#Vegeterian")
                .usedPosts(new ArrayList<>())
                .build();

        Post post = Post
                .builder()
                .title("from scratch 2")
                .description("very important 2")
                .content("very serious issue")
                .usedTags(List.of(tag1, tag2))
                .build();

        tag1.getUsedPosts().add(post);
        tag2.getUsedPosts().add(post);

        postRepository.save(post);

    }
}
