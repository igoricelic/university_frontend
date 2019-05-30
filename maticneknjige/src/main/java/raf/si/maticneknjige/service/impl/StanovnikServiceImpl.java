package raf.si.maticneknjige.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import raf.si.maticneknjige.dao.StanovnikDao;
import raf.si.maticneknjige.domain.MaticnaKnjigaRodjenih;
import raf.si.maticneknjige.domain.MaticnaKnjigaUmrlih;
import raf.si.maticneknjige.domain.Stanovnik;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaRodjenihRequestDto;
import raf.si.maticneknjige.domain.dto.StanovnikRequestDto;
import raf.si.maticneknjige.domain.dto.StanovnikResponseDto;
import raf.si.maticneknjige.exception.ResourceNotFoundException;
import raf.si.maticneknjige.service.MaticnaKnjigaRodjenihService;
import raf.si.maticneknjige.service.MaticnaKnjigaUmrlihService;
import raf.si.maticneknjige.service.MaticnaKnjigaVencanihService;
import raf.si.maticneknjige.service.StanovnikService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StanovnikServiceImpl implements StanovnikService {

    @Autowired
    private StanovnikDao stanovnikDao;

    @Autowired
    private MaticnaKnjigaRodjenihService maticnaKnjigaRodjenihService;

    @Autowired
    private MaticnaKnjigaUmrlihService maticnaKnjigaUmrlihService;

    @Autowired
    private MaticnaKnjigaVencanihService maticnaKnjigaVencanihService;

    @Override
    public Stanovnik save(StanovnikRequestDto stanovnikRequestDto) {
        Stanovnik stanovnik = stanovnikDao.save(new Stanovnik(stanovnikRequestDto.getIme(),stanovnikRequestDto.getPrezime(),
                stanovnikRequestDto.getJmbg(),stanovnikRequestDto.getAdresa()));

        maticnaKnjigaRodjenihService.save(new MaticnaKnjigaRodjenihRequestDto(stanovnik.getId(), stanovnik.getAdresa()));
        return stanovnik;
    }



    @Override
    public Stanovnik findById(Long id) {
        Optional<Stanovnik> stanovnikOptional= stanovnikDao.findById(id);
        if (!stanovnikOptional.isPresent()) {
            throw new ResourceNotFoundException("Nisam nasao stanovnika.");
        }
        return stanovnikOptional.get();
    }

    @Override
    public Page<StanovnikResponseDto> findAll(Pageable pageable) {
        Page<Stanovnik> page = stanovnikDao.findAll(pageable);
        List<StanovnikResponseDto> responseDtoList= new ArrayList<>();
        page.stream()
                .forEach(stanovnik-> {
                    MaticnaKnjigaRodjenih maticnaKnjigaRodjenih = stanovnik.getMaticnaKnjigaRodjenih();
                    int yearsOld = LocalDateTime.now().getYear() - maticnaKnjigaRodjenih.getDatum().getYear();
                    MaticnaKnjigaUmrlih maticnaKnjigaUmrlih = stanovnik.getMaticnaKnjigaUmrlih();
                    responseDtoList.add(new StanovnikResponseDto(stanovnik, maticnaKnjigaRodjenih, yearsOld, maticnaKnjigaUmrlih));
                });
        return new PageImpl<>(responseDtoList, pageable, page.getTotalElements());
    }



	@Override
	public List<String> findAllAsString() {
		return stanovnikDao.findAll().stream().map(Stanovnik::toString).collect(Collectors.toList());
	}
}
