package rs.edu.raf.poreskauprava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.edu.raf.poreskauprava.domain.Category;
import rs.edu.raf.poreskauprava.domain.CategoryCoefficient;

public interface CategoryCoefficientDao extends JpaRepository<CategoryCoefficient, Long> {

    CategoryCoefficient findCategoryCoefficientByCategory(Category category);
}
