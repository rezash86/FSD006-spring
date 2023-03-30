package com.jac.mvcproject.joinexamples.many_to_many.model.withnewEntity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="my_course")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course")
    List<CourseRating> ratings;
}
