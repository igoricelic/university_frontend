package rs.edu.raf.poreskauprava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.poreskauprava.domain.dto.payment.PaymentRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.payment.PaymentResponseDTO;
import rs.edu.raf.poreskauprava.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping(path = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "/save")
    public PaymentResponseDTO save(@RequestBody PaymentRequestDTO requestDTO) {
        return paymentService.save(requestDTO);
    }

    @GetMapping(path = "/delete")
    public void delete(PaymentRequestDTO requestDTO) {
        paymentService.delete(requestDTO);
    }

    @GetMapping(path = "/findAll")
    public List<PaymentResponseDTO> findAll() {
        return paymentService.findAll();
    }

    @GetMapping(path = "/findAllByIdentificator")
    public List<PaymentResponseDTO> findAllByIdentificator(PaymentRequestDTO requestDTO) {
        return paymentService.findAllByIdentificator(requestDTO);
    }
}
