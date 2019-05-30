package raf.si.maticneknjige.domain.dto;

import raf.si.maticneknjige.domain.MaticnaKnjigaUmrlih;
import raf.si.maticneknjige.domain.Stanovnik;

import java.time.LocalDateTime;

public class MaticnaKnjigaUmrlihResponseDto {

    private String adresa;
    private Stanovnik stanovnik;
    private LocalDateTime datum;

    public MaticnaKnjigaUmrlihResponseDto() {
    }

    public MaticnaKnjigaUmrlihResponseDto(MaticnaKnjigaUmrlih umrlica) {
        this.adresa = umrlica.getAdresa();
        this.datum = umrlica.getDatum();
        this.stanovnik = umrlica.getStanovnik();
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Stanovnik getStanovnik() {
        return stanovnik;
    }

    public void setStanovnik(Stanovnik stanovnik) {
        this.stanovnik = stanovnik;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }
}
