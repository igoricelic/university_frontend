package rs.edu.raf.poreskauprava.domain.lsd.parcel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParcelRequestDTO {

    private String jmbg;
}
