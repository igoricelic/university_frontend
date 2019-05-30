package raf.si.maticneknjige.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import raf.si.maticneknjige.domain.MaticnaKnjigaRodjenih;
import raf.si.maticneknjige.domain.MaticnaKnjigaUmrlih;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaRodjenihRequestDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaRodjenihResponseDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaUmrlihRequestDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaUmrlihResponseDto;
import raf.si.maticneknjige.service.MaticnaKnjigaRodjenihService;
import raf.si.maticneknjige.service.MaticnaKnjigaUmrlihService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/maticnaKnjigaRodjenih")
public class MaticnaKnjigaRodjenihApi {

    @Autowired
    private MaticnaKnjigaRodjenihService maticnaKnjigaRodjenihService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<MaticnaKnjigaRodjenihResponseDto> findAll(@PageableDefault(value = 8, page = 0) Pageable pageable,
                                                          HttpServletRequest httpServletRequest) {
//        TokenData td = (TokenData) httpServletRequest.getAttribute("loggedUser");
        return maticnaKnjigaRodjenihService.findAll(pageable);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public MaticnaKnjigaRodjenih save(@RequestBody MaticnaKnjigaRodjenihRequestDto maticnaKnjigaRodjenihRequestDto) {
        return maticnaKnjigaRodjenihService.save(maticnaKnjigaRodjenihRequestDto);
    }
}
