package rs.edu.raf.poreskauprava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.poreskauprava.domain.dto.coefficient.CategoryCoefficientRequestDTO;
import rs.edu.raf.poreskauprava.domain.dto.coefficient.CategoryCoefficientResponseDTO;
import rs.edu.raf.poreskauprava.service.CategoryCoefficientService;

import java.util.List;

@RestController
@RequestMapping(path = "/categoryCoefficients")
public class CategoryCoefficientController {

    @Autowired
    private CategoryCoefficientService categoryCoefficientService;

    @PostMapping(path = "/save")
    public CategoryCoefficientResponseDTO save(@RequestBody CategoryCoefficientRequestDTO requestDTO) {
        return categoryCoefficientService.save(requestDTO);
    }

    @GetMapping(path = "/delete")
    public void delete(CategoryCoefficientRequestDTO requestDTO) {
        categoryCoefficientService.delete(requestDTO);
    }

    @GetMapping
    public List<CategoryCoefficientResponseDTO> findAll(){
        return categoryCoefficientService.findAll();
    }
}
