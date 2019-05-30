package rs.edu.raf.poreskauprava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.poreskauprava.dao.InterestRateDao;
import rs.edu.raf.poreskauprava.domain.InterestRate;
import rs.edu.raf.poreskauprava.domain.dto.rate.interest.InterestRateRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.rate.interest.InterestRateResponseDTO;
import rs.edu.raf.poreskauprava.service.InterestRateService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InterestRateServiceImpl implements InterestRateService {

    @Autowired
    private InterestRateDao interestRateDao;

    @Override
    public InterestRateResponseDTO save(InterestRateRequestDTO requestDTO) {
        InterestRate interestRate = InterestRate.builder()
                .year(requestDTO.getYear())
                .percentage(requestDTO.getPercentage())
                .build();


        interestRate = interestRateDao.save(interestRate);


        InterestRateResponseDTO responseDTO = InterestRateResponseDTO.builder()
                .id(interestRate.getId())
                .year(interestRate.getYear())
                .percentage(interestRate.getPercentage())
                .build();

        return responseDTO;
    }

    @Override
    public void delete(InterestRateRequestDTO requestDTO) {
        InterestRate interestRate = InterestRate.builder()
                .id(requestDTO.getId())
                .build();

        interestRateDao.delete(interestRate);
    }

    @Override
    public List<InterestRateResponseDTO> findAll() {
        Iterable<InterestRate> interestRates = interestRateDao.findAll();

        List<InterestRateResponseDTO> responseDTOs = StreamSupport.stream(interestRates.spliterator(), false)
                .map(InterestRateResponseDTO::new)
                .collect(Collectors.toList());

        return responseDTOs;
    }

    @Override
    public InterestRate findByYear(int year) {
        return interestRateDao.findByYear(year);
    }
}
