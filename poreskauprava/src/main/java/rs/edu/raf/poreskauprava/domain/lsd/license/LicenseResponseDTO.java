package rs.edu.raf.poreskauprava.domain.lsd.license;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LicenseResponseDTO {

    private String type;
}
