package rs.edu.raf.poreskauprava.domain.dto.coefficient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.poreskauprava.util.CategoryType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCoefficientRequestDTO {

    private Long id;

    private int year;

    private CategoryType categoryType;

    private double coefficient;
}
