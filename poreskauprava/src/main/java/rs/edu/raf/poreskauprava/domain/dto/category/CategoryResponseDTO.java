package rs.edu.raf.poreskauprava.domain.dto.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.poreskauprava.domain.Category;
import rs.edu.raf.poreskauprava.util.CategoryType;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDTO {

    private Long id;

    private CategoryType categoryType;

    public CategoryResponseDTO(Category category) {
        this.id = category.getId();
        this.categoryType = category.getCategoryType();
    }
}
