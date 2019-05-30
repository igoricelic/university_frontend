package rs.edu.raf.poreskauprava.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private String identificator;

    private int year;

    private double unpaid;

    private double paid;

    private double balance;

    private String accountNumber;
}
