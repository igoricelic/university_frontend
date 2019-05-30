package raf.si.maticneknjige.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stanovnik")
public class Stanovnik {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "jmbg")
    private String jmbg;

    @Column(name = "adresa")
    private String adresa;

    @OneToMany(mappedBy = "stanovnikA")
    @JsonManagedReference
    private List<MaticnaKnjigaVencanih> vencanja= new ArrayList<>();

    @OneToOne(mappedBy = "stanovnik")
    @JsonManagedReference
    private MaticnaKnjigaUmrlih maticnaKnjigaUmrlih;

    @OneToOne(mappedBy = "stanovnik")
    @JsonManagedReference
    private MaticnaKnjigaRodjenih maticnaKnjigaRodjenih;

    public Stanovnik() {
    }

    public Stanovnik(String ime, String prezime, String jmbg, String adresa) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.adresa = adresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<MaticnaKnjigaVencanih> getVencanja() {
        return vencanja;
    }

    public void setVencanja(List<MaticnaKnjigaVencanih> vencanja) {
        this.vencanja = vencanja;
    }

    public MaticnaKnjigaUmrlih getMaticnaKnjigaUmrlih() {
        return maticnaKnjigaUmrlih;
    }

    public void setMaticnaKnjigaUmrlih(MaticnaKnjigaUmrlih maticnaKnjigaUmrlih) {
        this.maticnaKnjigaUmrlih = maticnaKnjigaUmrlih;
    }

    public MaticnaKnjigaRodjenih getMaticnaKnjigaRodjenih() {
        return maticnaKnjigaRodjenih;
    }

    public void setMaticnaKnjigaRodjenih(MaticnaKnjigaRodjenih maticnaKnjigaRodjenih) {
        this.maticnaKnjigaRodjenih = maticnaKnjigaRodjenih;
    }
    
    @Override
    public String toString() {
    	return String.format("%s %s %s %s", id.toString(), ime, prezime, jmbg);
    }
}
