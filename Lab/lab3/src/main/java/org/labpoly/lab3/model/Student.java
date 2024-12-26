package org.labpoly.lab3.model;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.NumberFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @NotBlank(message = "{student.name.required}")
    String name;

    @NotBlank(message = "{student.email.required}")
    @Email(message = "{student.email.invalid}")
    String email;

    @NotNull(message = "{student.marks.required}")
    @Min(value = 0, message = "{student.marks.value}")
    @Max(value = 10, message = "{student.marks.value}")
    @NumberFormat(pattern = "##.#####")
    Double marks;

    @NotNull(message = "{student.gender.required}")
    Boolean gender;

    @NotBlank(message = "{student.faculty.required}")
    String faculty;

    @NotEmpty(message = "{student.hobby.required}")
    String[] hobbies;

}
