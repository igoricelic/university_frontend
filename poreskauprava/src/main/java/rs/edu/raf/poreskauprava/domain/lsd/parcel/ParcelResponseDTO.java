package rs.edu.raf.poreskauprava.domain.lsd.parcel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.poreskauprava.domain.lsd.license.LicenseResponseDTO;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParcelResponseDTO {

    private String parcelNumber;

    private Long surface;

    private Long estimatedValue;

    private List<LicenseResponseDTO> licenses;
}
