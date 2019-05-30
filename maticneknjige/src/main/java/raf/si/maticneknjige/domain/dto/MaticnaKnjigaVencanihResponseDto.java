package raf.si.maticneknjige.domain.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import raf.si.maticneknjige.domain.MaticnaKnjigaVencanih;
import raf.si.maticneknjige.domain.Stanovnik;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class MaticnaKnjigaVencanihResponseDto {

    private Long id;

    private Stanovnik stanovnikA;

    private Stanovnik stanovnikB;

    private String adresaVencanja;

    private LocalDateTime datumVencanja;

    public MaticnaKnjigaVencanihResponseDto(Long id, Stanovnik stanovnikA, Stanovnik stanovnikB, String adresaVencanja, LocalDateTime datumVencanja) {
        this.id = id;
        this.stanovnikA = stanovnikA;
        this.stanovnikB = stanovnikB;
        this.adresaVencanja = adresaVencanja;
        this.datumVencanja = datumVencanja;
    }

    public MaticnaKnjigaVencanihResponseDto(MaticnaKnjigaVencanih vecanje) {
        this.id = vecanje.getId();
        this.stanovnikA = vecanje.getStanovnikA();
        this.stanovnikB = vecanje.getStanovnikB();
        this.adresaVencanja = vecanje.getAdresaVencanja();
        this.datumVencanja = vecanje.getDatumVencanja();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stanovnik getStanovnikA() {
        return stanovnikA;
    }

    public void setStanovnikA(Stanovnik stanovnikA) {
        this.stanovnikA = stanovnikA;
    }

    public Stanovnik getStanovnikB() {
        return stanovnikB;
    }

    public void setStanovnikB(Stanovnik stanovnikB) {
        this.stanovnikB = stanovnikB;
    }

    public String getAdresaVencanja() {
        return adresaVencanja;
    }

    public void setAdresaVencanja(String adresaVencanja) {
        this.adresaVencanja = adresaVencanja;
    }

    public LocalDateTime getDatumVencanja() {
        return datumVencanja;
    }

    public void setDatumVencanja(LocalDateTime datumVencanja) {
        this.datumVencanja = datumVencanja;
    }
}
