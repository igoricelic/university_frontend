package raf.si.maticneknjige.domain.dto;

public class MaticnaKnjigaUmrlihRequestDto {

    private Long stanovnik;
    private String adresa;

    public MaticnaKnjigaUmrlihRequestDto(Long stanovnik, String adresa) {
        this.stanovnik = stanovnik;
        this.adresa = adresa;
    }

    public Long getStanovnik() {
        return stanovnik;
    }

    public void setStanovnik(Long stanovnik) {
        this.stanovnik = stanovnik;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
