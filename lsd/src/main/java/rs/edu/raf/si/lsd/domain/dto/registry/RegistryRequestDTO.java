package rs.edu.raf.si.lsd.domain.dto.registry;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistryRequestDTO {
    private int generation;
}
