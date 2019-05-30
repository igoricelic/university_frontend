package raf.si.maticneknjige.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import raf.si.maticneknjige.domain.MaticnaKnjigaRodjenih;
import raf.si.maticneknjige.domain.MaticnaKnjigaUmrlih;

public interface MaticnaKnjigaRodjenihDao extends JpaRepository<MaticnaKnjigaRodjenih, Long> {
}
