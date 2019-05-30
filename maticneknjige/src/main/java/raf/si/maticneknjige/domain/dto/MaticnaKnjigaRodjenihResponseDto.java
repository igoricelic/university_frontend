package raf.si.maticneknjige.domain.dto;

import raf.si.maticneknjige.domain.MaticnaKnjigaRodjenih;
import raf.si.maticneknjige.domain.Stanovnik;

import java.time.LocalDateTime;

public class MaticnaKnjigaRodjenihResponseDto {

    private String adresa;
    private Stanovnik stanovnik;
    private LocalDateTime datum;

    public MaticnaKnjigaRodjenihResponseDto() {
    }

    public MaticnaKnjigaRodjenihResponseDto(MaticnaKnjigaRodjenih rodjenje) {
        this.adresa = rodjenje.getAdresa();
        this.datum = rodjenje.getDatum();
        this.stanovnik = rodjenje.getStanovnik();
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
