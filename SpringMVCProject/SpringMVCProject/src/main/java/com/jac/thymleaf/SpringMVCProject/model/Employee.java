package com.jac.thymleaf.SpringMVCProject.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    private Long id;

    @NotEmpty(message = "First name cannot be empty.")
    @Size(min = 5, max = 250)
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty.")
    @Size(min = 5, max = 250)
    private String lastName;

    @Email
    @NotEmpty(message = "Email cannot be empty.")
    private String email;
}
