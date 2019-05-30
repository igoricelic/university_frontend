package rs.edu.raf.poreskauprava.domain.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.edu.raf.poreskauprava.domain.Payment;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {

    private Long id;

    private String identificator;

    private int year;

    private double unpaid;

    private double paid;

    private double balance;

    private String accountNumber;

    public PaymentResponseDTO(Payment payment) {
        this.id = payment.getId();

        this.identificator = payment.getIdentificator();

        this.year = payment.getYear();

        this.unpaid = payment.getUnpaid();

        this.paid = payment.getPaid();

        this.balance = payment.getBalance();

        this.accountNumber = payment.getAccountNumber();
    }
}
