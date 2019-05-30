package rs.edu.raf.poreskauprava.service.impl;

import org.springframework.stereotype.Service;
import rs.edu.raf.poreskauprava.domain.lsd.license.LicenseResponseDTO;
import rs.edu.raf.poreskauprava.domain.lsd.parcel.ParcelResponseDTO;
import rs.edu.raf.poreskauprava.service.ParcelService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParcelServiceImpl implements ParcelService {


    @Override
    public List<ParcelResponseDTO> getAllParcelsFor(String jmbg) {

        List<ParcelResponseDTO> parcelResponseDTOs = new ArrayList<>();
        List<LicenseResponseDTO> licenses = new ArrayList<>();
        licenses.add(new LicenseResponseDTO("KUCA"));

        for(int i = 0; i < 10; i++) {
            parcelResponseDTOs.add(
                    ParcelResponseDTO.builder()
                    .parcelNumber(String.valueOf(i))
                    .surface((long) i)
                    .estimatedValue((long) i)
                    .licenses(licenses)
                    .build()
            );
        }

        return parcelResponseDTOs;
    }
}
