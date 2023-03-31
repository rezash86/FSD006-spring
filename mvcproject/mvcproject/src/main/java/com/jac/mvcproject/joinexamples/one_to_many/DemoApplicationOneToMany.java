package com.jac.mvcproject.joinexamples.one_to_many;

import com.jac.mvcproject.joinexamples.one_to_many.model.Comment;
import com.jac.mvcproject.joinexamples.one_to_many.repository.CommentRepository;
import com.jac.mvcproject.joinexamples.one_to_many.model.Post;
import com.jac.mvcproject.joinexamples.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplicationOneToMany implements CommandLineRunner {

    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    @Autowired
    public DemoApplicationOneToMany(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationOneToMany.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //insertData();

        //if you want to update the entity
        //what would you do????

        //1 - you fetch the object
        //2- modify your object e.x adding comments
        //3- save it again
        //updateData(3L);

        insertComment(1L);
        showComments(1L);

    }


    private void insertData(){
        List<Comment> comments = List.of(
                Comment
                .builder()
                        .text("funnny post")

                .build(),
                Comment
                .builder()
                        .text("so lame.. boooo")
                .build()
        );
        var post = Post
                .builder()
                .title("this is my vacation post3")
                .content("this is the content")
                .description("this is a description")
                .comments(null)
                .build();

        postRepository.save(post);
    }

    private void updateData(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);

        if(optionalPost.isPresent()){
            Post fetchedPost = optionalPost.get();
            fetchedPost.setComments(List.of(Comment.builder().text("wow , very nice picture2").build()));
            postRepository.save(fetchedPost);
        }
    }

    private void insertComment(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);

        if(optionalPost.isPresent()){
            Post fetchedPost = optionalPost.get();
            Comment comment = Comment.builder().post(fetchedPost)
                    .text("This is my comment for the beautiful picture").build();
            commentRepository.save(comment);
        }
        //https://www.javaguides.net/2022/02/spring-data-jpa-one-to-many-bidirectional-mapping.html
    }

    private void updateComment(Long commentId){
        Optional<Comment> comment =  commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment commentFetched = comment.get();
            commentFetched.setText("new text");
            commentRepository.save(commentFetched);
        }
    }

    private void showComments(Long postId){
//        Optional<Post> post =  postRepository.findById(postId);
//        if(post.isPresent()){
//            Post postFetch = post.get();
//            List<Comment> comments = postFetch.getComments();
//        }

        commentRepository.findByPostId(postId).forEach(comment -> System.out.println(comment.getText()));
    }
}
