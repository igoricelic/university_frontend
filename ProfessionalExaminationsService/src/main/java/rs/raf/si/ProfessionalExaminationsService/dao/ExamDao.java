package rs.raf.si.ProfessionalExaminationsService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.raf.si.ProfessionalExaminationsService.domain.Exam;

public interface ExamDao extends JpaRepository<Exam, Long> {

}
