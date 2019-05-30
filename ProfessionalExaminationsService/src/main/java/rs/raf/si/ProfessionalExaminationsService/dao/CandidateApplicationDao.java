package rs.raf.si.ProfessionalExaminationsService.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import rs.raf.si.ProfessionalExaminationsService.domain.CandidateApplication;

public interface CandidateApplicationDao extends JpaRepository<CandidateApplication, Long> {
	
	Page<CandidateApplication> findByCandidateJmbg(String candidateJmbg, Pageable pageable);
	
	Page<CandidateApplication> findByTerm_Id(Long termId, Pageable pageable);

}
