package raf.si.maticneknjige.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import raf.si.maticneknjige.domain.Stanovnik;
import raf.si.maticneknjige.domain.dto.StanovnikRequestDto;
import raf.si.maticneknjige.domain.dto.StanovnikResponseDto;
import raf.si.maticneknjige.service.StanovnikService;

@RestController
@RequestMapping(value = "/stanovnik")
public class StanovnikApi {

    @Autowired
    private StanovnikService stanovnikService;

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Stanovnik findById(@PathVariable Long id, HttpServletRequest httpServletRequest) {
//        TokenData td = (TokenData) httpServletRequest.getAttribute("loggedUser");
        return stanovnikService.findById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Stanovnik save(@RequestBody StanovnikRequestDto stanovnikRequestDto) {
        return stanovnikService.save(stanovnikRequestDto);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<StanovnikResponseDto> findAll(@PageableDefault(value = 8, page = 0) Pageable pageable,
                                              HttpServletRequest httpServletRequest) {
//        TokenData td = (TokenData) httpServletRequest.getAttribute("loggedUser");
        return stanovnikService.findAll(pageable);
    }
    
    @RequestMapping(value = "/findAllAsString", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> findAllAsString() {
    	return stanovnikService.findAllAsString();
    }
}
