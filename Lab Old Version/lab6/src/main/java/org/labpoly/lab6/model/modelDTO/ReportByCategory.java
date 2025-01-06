package org.labpoly.lab6.model.modelDTO;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.labpoly.lab6.model.Category}
 */
@Value
@Data
public class ReportByCategory implements Serializable {
    String categoryName;
    Double totalPrice;
    Long quantity;
}