package rs.raf.si.ProfessionalExaminationsService.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import rs.raf.si.ProfessionalExaminationsService.dao.AddressDao;
import rs.raf.si.ProfessionalExaminationsService.domain.Address;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.AddressRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.AddressResponseDto;
import rs.raf.si.ProfessionalExaminationsService.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	private AddressDao addressDao;
	
	@Autowired
	public AddressServiceImpl(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	public Page<AddressResponseDto> findAll(Pageable pageable) {
		Page<Address> page = addressDao.findAll(pageable);
		return new PageImpl<>(page.stream().map(AddressResponseDto::new).collect(Collectors.toList()), pageable, page.getTotalElements());
	}

	@Override
	public AddressResponseDto save(AddressRequestDto addressRequestDto) {
		Address address = new Address();
		address.setCity(addressRequestDto.getCity());
		address.setHouseNumber(addressRequestDto.getHouseNumber());
		address.setPostCode(address.getPostCode());
		address.setStreet(addressRequestDto.getStreet());
		addressDao.save(address);
		return new AddressResponseDto(address);
	}

	@Override
	public AddressResponseDto update(AddressRequestDto addressRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
