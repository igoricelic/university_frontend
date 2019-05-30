package rs.edu.raf.poreskauprava.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaxRate {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Category category;

    private int year;

    private double percentage;
}
