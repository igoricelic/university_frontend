package rs.edu.raf.poreskauprava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.poreskauprava.domain.dto.category.CategoryRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.category.CategoryResponseDTO;
import rs.edu.raf.poreskauprava.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "/save")
    public CategoryResponseDTO save(@Valid @RequestBody CategoryRequestDTO requestDTO) {
        return categoryService.save(requestDTO);
    }

    @GetMapping(path = "/delete")
    public void delete(@Valid CategoryRequestDTO requestDTO) {
        categoryService.delete(requestDTO);
    }

    @GetMapping(path = "/findAll")
    public List<CategoryResponseDTO> findAll() {
        return categoryService.findAll();
    }
}
