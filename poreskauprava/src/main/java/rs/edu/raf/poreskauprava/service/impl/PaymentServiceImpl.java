package rs.edu.raf.poreskauprava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.poreskauprava.dao.PaymentDao;
import rs.edu.raf.poreskauprava.domain.Payment;
import rs.edu.raf.poreskauprava.domain.dto.payment.PaymentRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.payment.PaymentResponseDTO;
import rs.edu.raf.poreskauprava.service.PaymentService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public PaymentResponseDTO save(PaymentRequestDTO requestDTO) {
        Payment payment = Payment.builder()
                .identificator(requestDTO.getIdentificator())
                .year(requestDTO.getYear())
                .unpaid(requestDTO.getUnpaid())
                .paid(requestDTO.getPaid())
                .balance(requestDTO.getBalance())
                .accountNumber(requestDTO.getAccountNumber())
                .build();

        payment = paymentDao.save(payment);



        PaymentResponseDTO responseDTO = PaymentResponseDTO.builder()
                .id(payment.getId())
                .identificator(requestDTO.getIdentificator())
                .year(payment.getYear())
                .unpaid(payment.getUnpaid())
                .paid(payment.getPaid())
                .balance(payment.getBalance())
                .accountNumber(payment.getAccountNumber())
                .build();

        return responseDTO;
    }

    @Override
    public void delete(PaymentRequestDTO requestDTO) {
        Payment payment = Payment.builder()
                .id(requestDTO.getId())
                .build();

        paymentDao.delete(payment);
    }

    @Override
    public List<PaymentResponseDTO> findAll() {
        Iterable<Payment> payments = paymentDao.findAll();

        List<PaymentResponseDTO> responseDTOs = StreamSupport.stream(payments.spliterator(), false)
                .map(PaymentResponseDTO::new)
                .collect(Collectors.toList());

        return responseDTOs;
    }

    @Override
    public List<Payment> findAllByIdentificator(String identificator) {
        return paymentDao.findAllByIdentificator(identificator);
    }

    @Override
    public List<PaymentResponseDTO> findAllByIdentificator(PaymentRequestDTO requestDTO) {
        List<Payment> payments = paymentDao.findAllByIdentificator(requestDTO.getIdentificator());

        List<PaymentResponseDTO> responseDTOs = payments.stream()
                .map(PaymentResponseDTO::new)
                .collect(Collectors.toList());

        return responseDTOs;
    }

    @Override
    public void save(Payment payment) {
        paymentDao.save(payment);
    }
}
