package rs.edu.raf.poreskauprava.domain.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {

    private Long id;

    private String identificator;

    private int year;

    private double unpaid;

    private double paid;

    private double balance;

    private String accountNumber;
}
