package raf.si.maticneknjige.domain.dto;

import raf.si.maticneknjige.domain.MaticnaKnjigaRodjenih;
import raf.si.maticneknjige.domain.MaticnaKnjigaUmrlih;
import raf.si.maticneknjige.domain.Stanovnik;

public class StanovnikResponseDto {
	
    private String jmbg;

    private int age;

    private int yearOfBirth;

    private int yearOfDeath;

    private boolean isAlive;

    public StanovnikResponseDto(Stanovnik stanovnik, MaticnaKnjigaRodjenih maticnaKnjigaRodjenih, int yearsOld, MaticnaKnjigaUmrlih maticnaKnjigaUmrlih) {
        this.jmbg = stanovnik.getJmbg();
        this.age = yearsOld;
        this.yearOfBirth = maticnaKnjigaRodjenih.getDatum().getYear();
        if(maticnaKnjigaUmrlih == null){
            //ziv je umro nije
            this.yearOfDeath = -1;
            this.setAlive(true);
        }else{
            this.yearOfDeath = maticnaKnjigaUmrlih.getDatum().getYear();
            this.setAlive(false);
        }
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(int yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
