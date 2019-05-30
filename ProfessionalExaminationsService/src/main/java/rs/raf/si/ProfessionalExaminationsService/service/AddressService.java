package rs.raf.si.ProfessionalExaminationsService.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import rs.raf.si.ProfessionalExaminationsService.domain.dto.AddressRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.AddressResponseDto;

public interface AddressService {
	
	Page<AddressResponseDto> findAll(Pageable pageable);
	
	AddressResponseDto save(AddressRequestDto addressRequestDto);
	
	AddressResponseDto update(AddressRequestDto addressRequestDto);

}
