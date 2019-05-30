package rs.edu.raf.poreskauprava.service;

import rs.edu.raf.poreskauprava.domain.lsd.resident.ResidentResponseDTO;

import java.util.List;

public interface ResidentService {

    List<ResidentResponseDTO> getAllResidents();

}
