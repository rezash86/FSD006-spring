package com.jac.mvcproject.model;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Long id;

    private String studentNumber;

    private String firstName;

    private String lastName;

    private String email;
}
