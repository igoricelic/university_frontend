package rs.edu.raf.poreskauprava.domain.dto.rate.tax;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.poreskauprava.domain.TaxRate;
import rs.edu.raf.poreskauprava.util.CategoryType;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaxRateResponseDTO {

    private Long id;

    private CategoryType categoryType;

    private int year;

    private double percentage;

    public TaxRateResponseDTO(TaxRate taxRate) {
        this.id = taxRate.getId();

        this.categoryType = taxRate.getCategory().getCategoryType();

        this.year = taxRate.getYear();

        this.percentage = taxRate.getPercentage();
    }
}
