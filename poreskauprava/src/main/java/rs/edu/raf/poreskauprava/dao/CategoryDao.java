package rs.edu.raf.poreskauprava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.edu.raf.poreskauprava.domain.Category;
import rs.edu.raf.poreskauprava.util.CategoryType;

import java.util.Optional;

public interface CategoryDao extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryType(CategoryType categoryType);
}
