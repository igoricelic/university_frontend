package raf.si.maticneknjige.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import raf.si.maticneknjige.domain.MaticnaKnjigaUmrlih;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaUmrlihRequestDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaUmrlihResponseDto;

public interface MaticnaKnjigaUmrlihService {

    MaticnaKnjigaUmrlih save(MaticnaKnjigaUmrlihRequestDto maticnaKnjigaUmrlihRequestDto);

    Page<MaticnaKnjigaUmrlihResponseDto> findAll(Pageable pageable);

}
