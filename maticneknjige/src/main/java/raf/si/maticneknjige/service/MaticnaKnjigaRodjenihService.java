package raf.si.maticneknjige.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import raf.si.maticneknjige.domain.MaticnaKnjigaRodjenih;
import raf.si.maticneknjige.domain.MaticnaKnjigaUmrlih;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaRodjenihRequestDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaRodjenihResponseDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaUmrlihRequestDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaUmrlihResponseDto;

public interface MaticnaKnjigaRodjenihService {

    MaticnaKnjigaRodjenih save(MaticnaKnjigaRodjenihRequestDto maticnaKnjigaRodjenihRequestDto);

    Page<MaticnaKnjigaRodjenihResponseDto> findAll(Pageable pageable);
}
