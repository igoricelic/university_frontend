package rs.edu.raf.poreskauprava.domain.dto.rate.interest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.poreskauprava.domain.InterestRate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InterestRateResponseDTO {

    private Long id;

    private int year;

    private double percentage;

    public InterestRateResponseDTO(InterestRate interestRate) {
        this.id = interestRate.getId();

        this.year = interestRate.getYear();

        this.percentage = interestRate.getPercentage();
    }
}
