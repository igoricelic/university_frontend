package raf.si.maticneknjige.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import raf.si.maticneknjige.domain.Stanovnik;

public interface StanovnikDao extends JpaRepository<Stanovnik, Long> {
}
