package com.jac.mvcproject.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentGetOutputDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}
