package rs.edu.raf.poreskauprava.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCoefficient {

    @Id
    @GeneratedValue
    private long id;

    private int year;

    @OneToOne
    private Category category;

    private double coefficient;
}
