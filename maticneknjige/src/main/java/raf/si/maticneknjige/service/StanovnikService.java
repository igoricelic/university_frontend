package raf.si.maticneknjige.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import raf.si.maticneknjige.domain.Stanovnik;
import raf.si.maticneknjige.domain.dto.StanovnikRequestDto;
import raf.si.maticneknjige.domain.dto.StanovnikResponseDto;

public interface StanovnikService {

    Stanovnik save(StanovnikRequestDto stanovnikRequestDto);

    Stanovnik findById(Long id);

    Page<StanovnikResponseDto> findAll(Pageable pageable);
    
    List<String> findAllAsString();

}
