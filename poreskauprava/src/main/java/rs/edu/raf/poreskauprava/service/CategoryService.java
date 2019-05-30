package rs.edu.raf.poreskauprava.service;

import rs.edu.raf.poreskauprava.domain.Category;
import rs.edu.raf.poreskauprava.domain.dto.category.CategoryRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.category.CategoryResponseDTO;
import rs.edu.raf.poreskauprava.util.CategoryType;

import java.util.List;

public interface CategoryService {

    CategoryResponseDTO save(CategoryRequestDTO requestDTO);

    void delete(CategoryRequestDTO requestDTO);

    List<CategoryResponseDTO> findAll();

    Category findByCategoryType(CategoryType categoryType);
}
