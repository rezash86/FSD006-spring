package com.jac.mvcproject.joinexamples.many_to_many.model.withnewEntity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="my_student")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student")
    List<CourseRating> ratings;
}
