package rs.edu.raf.poreskauprava.service.impl;

import org.springframework.stereotype.Service;
import rs.edu.raf.poreskauprava.domain.lsd.resident.ResidentResponseDTO;
import rs.edu.raf.poreskauprava.service.ResidentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResidentServiceImpl implements ResidentService {
    @Override
    public List<ResidentResponseDTO> getAllResidents() {
        List<ResidentResponseDTO> residents = new ArrayList<>();

        residents.add(new ResidentResponseDTO("1"));

        return residents;
    }
}
