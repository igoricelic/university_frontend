package rs.edu.raf.poreskauprava.domain.dto.coefficient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.poreskauprava.domain.CategoryCoefficient;
import rs.edu.raf.poreskauprava.util.CategoryType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCoefficientResponseDTO {

    private Long id;

    private int year;

    private CategoryType categoryType;

    private double coefficient;

    public CategoryCoefficientResponseDTO(CategoryCoefficient categoryCoefficient) {
        this.id = categoryCoefficient.getId();

        this.year = categoryCoefficient.getYear();

        this.categoryType = categoryCoefficient.getCategory().getCategoryType();

        this.coefficient = categoryCoefficient.getCoefficient();
    }
}
