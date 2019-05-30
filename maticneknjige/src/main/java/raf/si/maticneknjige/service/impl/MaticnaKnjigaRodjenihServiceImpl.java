package raf.si.maticneknjige.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import raf.si.maticneknjige.dao.MaticnaKnjigaRodjenihDao;
import raf.si.maticneknjige.dao.MaticnaKnjigaUmrlihDao;
import raf.si.maticneknjige.domain.MaticnaKnjigaRodjenih;
import raf.si.maticneknjige.domain.MaticnaKnjigaUmrlih;
import raf.si.maticneknjige.domain.Stanovnik;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaRodjenihRequestDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaRodjenihResponseDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaUmrlihRequestDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaUmrlihResponseDto;
import raf.si.maticneknjige.service.MaticnaKnjigaRodjenihService;
import raf.si.maticneknjige.service.MaticnaKnjigaUmrlihService;
import raf.si.maticneknjige.service.StanovnikService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaticnaKnjigaRodjenihServiceImpl implements MaticnaKnjigaRodjenihService {

    @Autowired
    private StanovnikService stanovnikService;

    @Autowired
    private MaticnaKnjigaRodjenihDao maticnaKnjigaRodjenihDao;

    @Override
    public MaticnaKnjigaRodjenih save(MaticnaKnjigaRodjenihRequestDto maticnaKnjigaRodjenihRequestDto) {
        Stanovnik stanovnikA = stanovnikService.findById(maticnaKnjigaRodjenihRequestDto.getStanovnik());
        return maticnaKnjigaRodjenihDao.save(new MaticnaKnjigaRodjenih(maticnaKnjigaRodjenihRequestDto.getAdresa(), LocalDateTime.now(), stanovnikA));
    }

    @Override
    public Page<MaticnaKnjigaRodjenihResponseDto> findAll(Pageable pageable) {
        Page<MaticnaKnjigaRodjenih> page = maticnaKnjigaRodjenihDao.findAll(pageable);
        List<MaticnaKnjigaRodjenihResponseDto> responseDtoList= new ArrayList<>();
        page.stream()
                .forEach(rodjenje-> responseDtoList.add(new MaticnaKnjigaRodjenihResponseDto(rodjenje)));
        return new PageImpl<>(responseDtoList, pageable, page.getTotalElements());
    }

}
