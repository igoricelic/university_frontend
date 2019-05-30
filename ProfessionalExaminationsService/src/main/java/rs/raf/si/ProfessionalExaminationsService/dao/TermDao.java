package rs.raf.si.ProfessionalExaminationsService.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import rs.raf.si.ProfessionalExaminationsService.domain.Term;

public interface TermDao extends JpaRepository<Term, Long> {
	
	Page<Term> findByExam_Id (Long examId, Pageable pageable);
	
	Page<Term> findByAddress_Id (Long addressId, Pageable pageable);

}
