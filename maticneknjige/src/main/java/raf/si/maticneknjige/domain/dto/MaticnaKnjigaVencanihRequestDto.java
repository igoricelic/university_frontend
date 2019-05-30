package raf.si.maticneknjige.domain.dto;

public class MaticnaKnjigaVencanihRequestDto {

    private Long stanovnikA;
    private Long stanovnikB;
    private String adresaVencanja;

    public Long getStanovnikA() {
        return stanovnikA;
    }

    public void setStanovnikA(Long stanovnikA) {
        this.stanovnikA = stanovnikA;
    }

    public Long getStanovnikB() {
        return stanovnikB;
    }

    public void setStanovnikB(Long stanovnikB) {
        this.stanovnikB = stanovnikB;
    }

    public String getAdresaVencanja() {
        return adresaVencanja;
    }

    public void setAdresaVencanja(String adresaVencanja) {
        this.adresaVencanja = adresaVencanja;
    }
}
