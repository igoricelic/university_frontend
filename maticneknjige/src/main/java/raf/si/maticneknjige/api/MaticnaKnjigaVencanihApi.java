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
import raf.si.maticneknjige.domain.MaticnaKnjigaVencanih;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaVencanihRequestDto;
import raf.si.maticneknjige.domain.dto.MaticnaKnjigaVencanihResponseDto;
import raf.si.maticneknjige.service.MaticnaKnjigaVencanihService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/maticnaKnjigaVencanih")
public class MaticnaKnjigaVencanihApi {

    @Autowired
    private MaticnaKnjigaVencanihService maticnaKnjigaVencanihService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<MaticnaKnjigaVencanihResponseDto> findAll(@PageableDefault(value = 8, page = 0) Pageable pageable,
                                                          HttpServletRequest httpServletRequest) {
//        TokenData td = (TokenData) httpServletRequest.getAttribute("loggedUser");
        return maticnaKnjigaVencanihService.findAll(pageable);
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public MaticnaKnjigaVencanih save(@RequestBody MaticnaKnjigaVencanihRequestDto maticnaKnjigaVencanihRequestDto) {
        return maticnaKnjigaVencanihService.save(maticnaKnjigaVencanihRequestDto);
    }
}
