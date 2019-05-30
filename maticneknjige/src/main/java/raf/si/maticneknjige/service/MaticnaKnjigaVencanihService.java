package raf.si.maticneknjige.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import raf.si.maticneknjige.domain.MaticnaKnjigaVencanih;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaVencanihRequestDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaVencanihResponseDto;

public interface MaticnaKnjigaVencanihService {

    MaticnaKnjigaVencanih save(MaticnaKnjigaVencanihRequestDto maticnaKnjigaVencanihRequestDto);

    Page<MaticnaKnjigaVencanihResponseDto> findAll(Pageable pageable);
}
