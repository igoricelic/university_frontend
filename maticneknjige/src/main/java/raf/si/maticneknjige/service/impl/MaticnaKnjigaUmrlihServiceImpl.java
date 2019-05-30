package raf.si.maticneknjige.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import raf.si.maticneknjige.dao.MaticnaKnjigaUmrlihDao;
import raf.si.maticneknjige.domain.MaticnaKnjigaUmrlih;
import raf.si.maticneknjige.domain.Stanovnik;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaUmrlihRequestDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaUmrlihResponseDto;
import raf.si.maticneknjige.service.MaticnaKnjigaUmrlihService;
import raf.si.maticneknjige.service.StanovnikService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaticnaKnjigaUmrlihServiceImpl implements MaticnaKnjigaUmrlihService {

    @Autowired
    private StanovnikService stanovnikService;

    @Autowired
    private MaticnaKnjigaUmrlihDao maticnaKnjigaUmrlihDao;

    @Override
    public MaticnaKnjigaUmrlih save(MaticnaKnjigaUmrlihRequestDto maticnaKnjigaUmrlihRequestDto) {
        Stanovnik stanovnikA = stanovnikService.findById(maticnaKnjigaUmrlihRequestDto.getStanovnik());
        return maticnaKnjigaUmrlihDao.save(new MaticnaKnjigaUmrlih(maticnaKnjigaUmrlihRequestDto.getAdresa(), LocalDateTime.now(), stanovnikA));
    }

    @Override
    public Page<MaticnaKnjigaUmrlihResponseDto> findAll(Pageable pageable) {
        Page<MaticnaKnjigaUmrlih> page = maticnaKnjigaUmrlihDao.findAll(pageable);
        List<MaticnaKnjigaUmrlihResponseDto> responseDtoList= new ArrayList<>();
        page.stream()
                .forEach(umrlica-> responseDtoList.add(new MaticnaKnjigaUmrlihResponseDto(umrlica)));
        return new PageImpl<>(responseDtoList, pageable, page.getTotalElements());
    }
}
