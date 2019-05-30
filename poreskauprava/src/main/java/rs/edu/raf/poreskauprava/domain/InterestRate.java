package rs.edu.raf.poreskauprava.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InterestRate {

    @Id
    @GeneratedValue
    private Long id;

    private int year;

    private double percentage;
}
