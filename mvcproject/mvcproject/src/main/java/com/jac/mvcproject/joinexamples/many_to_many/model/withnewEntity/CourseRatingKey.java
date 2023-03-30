package com.jac.mvcproject.joinexamples.many_to_many.model.withnewEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

//https://www.baeldung.com/jpa-many-to-many
@Embeddable
public class CourseRatingKey implements Serializable {

    private static final long serialVersionUID = -6249759082107368355L;
    @Column(name = "student_id")
    Long studentId;

    @Column(name = "course_id")
    Long courseId;
}
