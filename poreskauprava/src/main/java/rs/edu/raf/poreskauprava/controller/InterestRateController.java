package rs.edu.raf.poreskauprava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.poreskauprava.dao.InterestRateDao;
import rs.edu.raf.poreskauprava.domain.dto.rate.interest.InterestRateRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.rate.interest.InterestRateResponseDTO;
import rs.edu.raf.poreskauprava.service.InterestRateService;

import java.util.List;

@RestController
@RequestMapping(path = "/interestRates")
public class InterestRateController {

    @Autowired
    private InterestRateService interestRateService;

    @PostMapping(path = "/save")
    public InterestRateResponseDTO save(@RequestBody  InterestRateRequestDTO requestDTO) {
        return interestRateService.save(requestDTO);
    }

    @GetMapping(path = "/delete")
    public void delete(InterestRateRequestDTO requestDTO) {
        interestRateService.delete(requestDTO);
    }

    @GetMapping(path = "/findAll")
    public List<InterestRateResponseDTO> findAll() {
        return interestRateService.findAll();
    }
}
