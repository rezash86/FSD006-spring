package com.jac.mvcproject.joinexamples.many_to_many.model.withnewEntity;

import jakarta.persistence.*;
import lombok.*;

//https://www.baeldung.com/jpa-many-to-many
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseRating {

    @EmbeddedId
    private CourseRatingKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    MyStudent student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    MyCourse course;

    int rating;
}
