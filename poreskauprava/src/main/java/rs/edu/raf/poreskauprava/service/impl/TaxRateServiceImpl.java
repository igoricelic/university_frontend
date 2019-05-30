package rs.edu.raf.poreskauprava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.poreskauprava.dao.CategoryDao;
import rs.edu.raf.poreskauprava.dao.TaxRateDao;
import rs.edu.raf.poreskauprava.domain.Category;
import rs.edu.raf.poreskauprava.domain.TaxRate;
import rs.edu.raf.poreskauprava.domain.dto.rate.tax.TaxRateRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.rate.tax.TaxRateResponseDTO;
import rs.edu.raf.poreskauprava.service.TaxRateService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaxRateServiceImpl implements TaxRateService {

    @Autowired
    private TaxRateDao taxRateDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public TaxRateResponseDTO save(TaxRateRequestDTO requestDTO) {
        TaxRate taxRate = TaxRate.builder()
                .id(requestDTO.getId())
                .year(requestDTO.getYear())
                .percentage(requestDTO.getPercentage())
                .build();

        Optional<Category> categoryOptional = categoryDao.findByCategoryType(requestDTO.getCategoryType());

        if(categoryOptional.isPresent()) {
            Category category = categoryOptional.get();

            taxRate.setCategory(category);

            taxRate = taxRateDao.save(taxRate);

            TaxRateResponseDTO taxRateResponseDTO = TaxRateResponseDTO
                    .builder()
                    .id(taxRate.getId())
                    .categoryType(taxRate.getCategory().getCategoryType())
                    .year(taxRate.getYear())
                    .percentage(taxRate.getPercentage())
                    .build();

            return taxRateResponseDTO;
        } else {
            return null;
        }
    }

    @Override
    public void delete(TaxRateRequestDTO requestDTO) {
            TaxRate taxRate = TaxRate.builder()
                    .id(requestDTO.getId())
                    .build();

            taxRateDao.delete(taxRate);
    }

    @Override
    public List<TaxRateResponseDTO> findAll() {
        Iterable<TaxRate> taxRates = taxRateDao.findAll();

        List<TaxRateResponseDTO> taxRateResponseDTOs = StreamSupport.stream(taxRates.spliterator(), false)
                .map(TaxRateResponseDTO::new)
                .collect(Collectors.toList());

        return taxRateResponseDTOs;
    }

    @Override
    public TaxRate findByCategory(Category category) {
        return taxRateDao.findByCategory(category);
    }

}
