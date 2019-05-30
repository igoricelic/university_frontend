package rs.edu.raf.poreskauprava.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.poreskauprava.util.CategoryType;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
}
