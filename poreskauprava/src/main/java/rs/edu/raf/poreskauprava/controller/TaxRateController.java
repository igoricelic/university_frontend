package rs.edu.raf.poreskauprava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.poreskauprava.domain.dto.rate.tax.TaxRateRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.rate.tax.TaxRateResponseDTO;
import rs.edu.raf.poreskauprava.service.TaxRateService;

import java.util.List;

@RestController
@RequestMapping(path = "/taxRates")
public class TaxRateController {

    @Autowired
    private TaxRateService taxRateService;

    @PostMapping(path = "/save")
    public TaxRateResponseDTO save(@RequestBody  TaxRateRequestDTO requestDTO) {
        return taxRateService.save(requestDTO);
    }

    @GetMapping(path = "/delete")
    public void delete(TaxRateRequestDTO requestDTO) {
        taxRateService.delete(requestDTO);
    }

    @GetMapping(path = "/findAll")
    public List<TaxRateResponseDTO> findAll() {
        return taxRateService.findAll();
    }
}
