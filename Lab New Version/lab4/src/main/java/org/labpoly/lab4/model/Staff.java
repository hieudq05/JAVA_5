package org.labpoly.lab4.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staff {
    @NotBlank(message = "Email is required!")
    @Email(message = "Please enter available email!")
    private String email;

    @NotBlank(message = "Full name is required!")
    private String fullname;

    @NotNull(message = "Photo is required!")
    private String photo;

    @NotNull(message = "Please choose one!")
    private Boolean gender;

    @NotNull
    @DateTimeFormat(
            pattern="MM/dd/yyyy")
    @Past(message = "Birthday is not available!")
    private LocalDate birthday;

    @NotNull(message = "Salary is required!")
    @Min(value = 1000, message = "Salary must not under 1000.")
    private double salary;

    private Integer level;
}
