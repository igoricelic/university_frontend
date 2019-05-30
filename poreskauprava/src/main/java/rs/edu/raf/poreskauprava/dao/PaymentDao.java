package rs.edu.raf.poreskauprava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.edu.raf.poreskauprava.domain.Payment;

import java.util.List;

public interface PaymentDao extends JpaRepository<Payment, Long> {

    List<Payment> findAllByIdentificator(String identificator);
}
