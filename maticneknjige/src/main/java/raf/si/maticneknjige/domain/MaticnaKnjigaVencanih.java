package raf.si.maticneknjige.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "maticnaKnjigaVencanih")
public class MaticnaKnjigaVencanih {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "stanovnik_a")
    @JsonBackReference
    private Stanovnik stanovnikA;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "stanovnik_b")
    @JsonBackReference
    private Stanovnik stanovnikB;

    private String adresaVencanja;

    private LocalDateTime datumVencanja;

    public MaticnaKnjigaVencanih() {
    }

    public MaticnaKnjigaVencanih(Stanovnik stanovnikA, Stanovnik stanovnikB, String adresaVencanja, LocalDateTime datumVencanja) {
        this.stanovnikA = stanovnikA;
        this.stanovnikB = stanovnikB;
        this.adresaVencanja = adresaVencanja;
        this.datumVencanja = datumVencanja;
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
