package rs.edu.raf.poreskauprava.service;

import rs.edu.raf.poreskauprava.domain.Category;
import rs.edu.raf.poreskauprava.domain.TaxRate;
import rs.edu.raf.poreskauprava.domain.dto.rate.tax.TaxRateRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.rate.tax.TaxRateResponseDTO;

import java.util.List;

public interface TaxRateService {

    TaxRateResponseDTO save(TaxRateRequestDTO requestDTO);

    void delete(TaxRateRequestDTO requestDTO);

    List<TaxRateResponseDTO> findAll();

    TaxRate findByCategory(Category category);
}
