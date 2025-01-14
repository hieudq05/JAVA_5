package org.labpoly.lab2.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    String name;
    Double price;
}
