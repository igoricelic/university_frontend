package rs.edu.raf.poreskauprava.service;

import rs.edu.raf.poreskauprava.domain.Category;
import rs.edu.raf.poreskauprava.domain.CategoryCoefficient;
import rs.edu.raf.poreskauprava.domain.dto.coefficient.CategoryCoefficientRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.coefficient.CategoryCoefficientResponseDTO;

import java.util.List;

public interface CategoryCoefficientService {

    CategoryCoefficientResponseDTO save(CategoryCoefficientRequestDTO requestDTO);

    void delete(CategoryCoefficientRequestDTO requestDTO);

    List<CategoryCoefficientResponseDTO> findAll();

    CategoryCoefficient findByCategory(Category category);
}
