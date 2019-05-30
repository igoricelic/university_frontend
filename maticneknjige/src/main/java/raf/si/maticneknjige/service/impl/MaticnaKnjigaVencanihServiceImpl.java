package raf.si.maticneknjige.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import raf.si.maticneknjige.dao.MaticnaKnjigaVencanihDao;
import raf.si.maticneknjige.domain.MaticnaKnjigaVencanih;
import raf.si.maticneknjige.domain.Stanovnik;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaVencanihRequestDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaVencanihResponseDto;
import raf.si.maticneknjige.service.MaticnaKnjigaVencanihService;
import raf.si.maticneknjige.service.StanovnikService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MaticnaKnjigaVencanihServiceImpl implements MaticnaKnjigaVencanihService {

    @Autowired
    private MaticnaKnjigaVencanihDao maticnaKnjigaVencanihDao;

    @Autowired
    private StanovnikService stanovnikService;

    @Override
    public MaticnaKnjigaVencanih save(MaticnaKnjigaVencanihRequestDto maticnaKnjigaVencanihRequestDto) {
        Stanovnik stanovnikA = stanovnikService.findById(maticnaKnjigaVencanihRequestDto.getStanovnikA());
        Stanovnik stanovnikB = stanovnikService.findById(maticnaKnjigaVencanihRequestDto.getStanovnikB());

        MaticnaKnjigaVencanih vencanje = new MaticnaKnjigaVencanih(stanovnikA, stanovnikB, maticnaKnjigaVencanihRequestDto.getAdresaVencanja(), LocalDateTime.now());
        return maticnaKnjigaVencanihDao.save(vencanje);
    }

    @Override
    public Page<MaticnaKnjigaVencanihResponseDto> findAll(Pageable pageable) {
        Page<MaticnaKnjigaVencanih> page = maticnaKnjigaVencanihDao.findAll(pageable);
        List<MaticnaKnjigaVencanihResponseDto> responseDtoList= new ArrayList<>();
        page.stream()
                .forEach(vecanje -> responseDtoList.add(new MaticnaKnjigaVencanihResponseDto(vecanje)));
        return new PageImpl<>(responseDtoList, pageable, page.getTotalElements());
    }
}
