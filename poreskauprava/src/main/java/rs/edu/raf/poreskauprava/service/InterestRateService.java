package rs.edu.raf.poreskauprava.service;

import rs.edu.raf.poreskauprava.domain.InterestRate;
import rs.edu.raf.poreskauprava.domain.dto.rate.interest.InterestRateRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.rate.interest.InterestRateResponseDTO;

import java.util.List;

public interface InterestRateService {

    InterestRateResponseDTO save(InterestRateRequestDTO requestDTO);

    void delete(InterestRateRequestDTO requestDTO);

    List<InterestRateResponseDTO> findAll();

    InterestRate findByYear(int year);
}
