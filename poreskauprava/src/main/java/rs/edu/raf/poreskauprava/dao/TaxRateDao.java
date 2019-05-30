package rs.edu.raf.poreskauprava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.edu.raf.poreskauprava.domain.Category;
import rs.edu.raf.poreskauprava.domain.TaxRate;

public interface TaxRateDao extends JpaRepository<TaxRate, Long> {

    TaxRate findByCategory(Category category);
}
