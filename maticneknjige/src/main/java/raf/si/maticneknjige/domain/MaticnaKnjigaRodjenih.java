package raf.si.maticneknjige.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "maticnaKnjigaRodjenih")
public class MaticnaKnjigaRodjenih {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adresa;

    private LocalDateTime datum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stanovnik")
    @JsonBackReference
    private Stanovnik stanovnik;

    public MaticnaKnjigaRodjenih() {
    }

    public MaticnaKnjigaRodjenih(String adresa, LocalDateTime datum, Stanovnik stanovnik) {
        this.adresa = adresa;
        this.datum = datum;
        this.stanovnik = stanovnik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public Stanovnik getStanovnik() {
        return stanovnik;
    }

    public void setStanovnik(Stanovnik stanovnik) {
        this.stanovnik = stanovnik;
    }
}
