package rs.edu.raf.si.lsd.domain.dto.demography;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AverageAgeResponseDTO {

    private double averageAge;
}
