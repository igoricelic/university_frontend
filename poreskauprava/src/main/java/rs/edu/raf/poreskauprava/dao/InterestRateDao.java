package rs.edu.raf.poreskauprava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.edu.raf.poreskauprava.domain.InterestRate;

public interface InterestRateDao extends JpaRepository<InterestRate, Long> {

    InterestRate findByYear(int year);
}
