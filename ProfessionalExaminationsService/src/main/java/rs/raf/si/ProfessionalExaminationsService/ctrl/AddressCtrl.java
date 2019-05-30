package rs.raf.si.ProfessionalExaminationsService.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rs.raf.si.ProfessionalExaminationsService.domain.dto.AddressRequestDto;
import rs.raf.si.ProfessionalExaminationsService.domain.dto.AddressResponseDto;
import rs.raf.si.ProfessionalExaminationsService.service.AddressService;

@RestController
@RequestMapping(path = "/address")
public class AddressCtrl {

	private AddressService addressService;

	@Autowired
	public AddressCtrl(AddressService addressService) {
		this.addressService = addressService;
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody Page<AddressResponseDto> findAll(Pageable pageable) {
		return addressService.findAll(pageable);
	}

	@PostMapping(path = "/save")
	public @ResponseBody AddressResponseDto save(@RequestBody AddressRequestDto addressRequestDto) {
		return addressService.save(addressRequestDto);
	}

	@PutMapping(path = "/update")
	public @ResponseBody AddressResponseDto update(@RequestBody AddressRequestDto addressRequestDto) {
		return addressService.update(addressRequestDto);
	}

}
