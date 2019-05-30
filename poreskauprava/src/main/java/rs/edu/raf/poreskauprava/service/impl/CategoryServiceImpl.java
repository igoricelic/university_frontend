package rs.edu.raf.poreskauprava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.raf.poreskauprava.dao.CategoryDao;
import rs.edu.raf.poreskauprava.domain.Category;
import rs.edu.raf.poreskauprava.domain.dto.category.CategoryRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.category.CategoryResponseDTO;
import rs.edu.raf.poreskauprava.service.CategoryService;
import rs.edu.raf.poreskauprava.util.CategoryType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public CategoryResponseDTO save(CategoryRequestDTO requestDTO) {
        Category category = Category.builder()
                .categoryType(requestDTO.getCategoryType())
                .build();

        if(category.getCategoryType() != null) {
            category = categoryDao.save(category);

            CategoryResponseDTO categoryResponseDTO = CategoryResponseDTO.builder()
                    .id(category.getId())
                    .categoryType(category.getCategoryType())
                    .build();

            return categoryResponseDTO;
        } else {
            return null;
        }
    }

    @Override
    public void delete(CategoryRequestDTO requestDTO) {
        Category category = Category.builder()
                .categoryType(requestDTO.getCategoryType())
                .build();

        categoryDao.delete(category);
    }

    @Override
    public List<CategoryResponseDTO> findAll() {
        Iterable<Category> categories = categoryDao.findAll();

        List<CategoryResponseDTO> categoryResponseDTOs = StreamSupport.stream(categories.spliterator(), false)
                .map(CategoryResponseDTO::new)
                .collect(Collectors.toList());

        return categoryResponseDTOs;
    }

    @Override
    public Category findByCategoryType(CategoryType categoryType) {
        Optional<Category> categoryOptional = categoryDao.findByCategoryType(categoryType);

        return categoryOptional.orElse(null);

    }
}
