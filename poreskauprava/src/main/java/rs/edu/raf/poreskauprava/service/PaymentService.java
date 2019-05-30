package rs.edu.raf.poreskauprava.service;

import rs.edu.raf.poreskauprava.domain.Payment;
import rs.edu.raf.poreskauprava.domain.dto.payment.PaymentRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.payment.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {

    PaymentResponseDTO save(PaymentRequestDTO requestDTO);

    void delete(PaymentRequestDTO requestDTO);

    List<PaymentResponseDTO> findAll();

    List<Payment> findAllByIdentificator(String identificator);

    List<PaymentResponseDTO> findAllByIdentificator(PaymentRequestDTO requestDTO);

    void save(Payment payment);
}
