package com.registerService.registerservice.Repository;

import com.registerService.registerservice.Model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByUsername(String username);
}
