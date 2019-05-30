package rs.edu.raf.poreskauprava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.edu.raf.poreskauprava.service.PaymentCalculationService;

@RestController
@RequestMapping(path = "/paymentCalculation")
public class PaymentCalculationController {


    @Autowired
    private PaymentCalculationService paymentCalculationService;

    @GetMapping(path = "/calculate")
    public void calculate() {
            paymentCalculationService.calculate();
    }
}
