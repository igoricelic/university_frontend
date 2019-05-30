package rs.raf.si.ProfessionalExaminationsService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.raf.si.ProfessionalExaminationsService.domain.Address;

public interface AddressDao extends JpaRepository<Address, Long> {

}
