package rs.edu.raf.poreskauprava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.poreskauprava.dao.CategoryCoefficientDao;
import rs.edu.raf.poreskauprava.dao.CategoryDao;
import rs.edu.raf.poreskauprava.domain.Category;
import rs.edu.raf.poreskauprava.domain.CategoryCoefficient;
import rs.edu.raf.poreskauprava.domain.dto.category.CategoryRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.category.CategoryResponseDTO;
import rs.edu.raf.poreskauprava.domain.dto.coefficient.CategoryCoefficientRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.coefficient.CategoryCoefficientResponseDTO;
import rs.edu.raf.poreskauprava.service.CategoryCoefficientService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryCoefficientServiceImpl implements CategoryCoefficientService {

    @Autowired
    private CategoryCoefficientDao categoryCoefficientDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public CategoryCoefficientResponseDTO save(CategoryCoefficientRequestDTO requestDTO) {
        CategoryCoefficient categoryCoefficient = CategoryCoefficient.builder()
                .year(requestDTO.getYear())
                .coefficient(requestDTO.getCoefficient())
                .build();

        Optional<Category> categoryOptional = categoryDao.findByCategoryType(requestDTO.getCategoryType());

        if(categoryOptional.isPresent()) {
            Category category = categoryOptional.get();

            categoryCoefficient.setCategory(category);

            categoryCoefficient = categoryCoefficientDao.save(categoryCoefficient);

            CategoryCoefficientResponseDTO responseDTO = CategoryCoefficientResponseDTO.builder()
                    .id(categoryCoefficient.getId())
                    .categoryType(categoryCoefficient.getCategory().getCategoryType())
                    .coefficient(categoryCoefficient.getCoefficient())
                    .year(categoryCoefficient.getYear())
                    .build();

            return responseDTO;
        }

        return null;
    }

    @Override
    public void delete(CategoryCoefficientRequestDTO requestDTO) {
        CategoryCoefficient categoryCoefficient = CategoryCoefficient.builder()
                .id(requestDTO.getId())
                .build();

        categoryCoefficientDao.delete(categoryCoefficient);
    }

    @Override
    public List<CategoryCoefficientResponseDTO> findAll() {
        Iterable<CategoryCoefficient> categoryCoefficients = categoryCoefficientDao.findAll();

        List<CategoryCoefficientResponseDTO> responseDTOs = StreamSupport.stream(categoryCoefficients.spliterator(), false)
                .map(CategoryCoefficientResponseDTO::new)
                .collect(Collectors.toList());

        return responseDTOs;
    }

    @Override
    public CategoryCoefficient findByCategory(Category category) {
        return categoryCoefficientDao.findCategoryCoefficientByCategory(category);
    }
}
