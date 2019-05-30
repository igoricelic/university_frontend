package rs.edu.raf.poreskauprava.service;

import rs.edu.raf.poreskauprava.domain.lsd.parcel.ParcelResponseDTO;

import java.util.List;

public interface ParcelService {

    List<ParcelResponseDTO> getAllParcelsFor(String jmbg);
}
