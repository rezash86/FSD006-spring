package com.jac.thymleaf.SpringMVCProject.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
