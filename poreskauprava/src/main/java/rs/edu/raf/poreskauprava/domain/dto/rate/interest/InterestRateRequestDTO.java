package rs.edu.raf.poreskauprava.domain.dto.rate.interest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InterestRateRequestDTO {

    private Long id;

    private int year;

    private double percentage;
}
