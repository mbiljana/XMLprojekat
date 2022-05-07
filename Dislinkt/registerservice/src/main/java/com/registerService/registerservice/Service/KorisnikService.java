package com.registerService.registerservice.Service;

import com.registerService.registerservice.Model.Korisnik;

public interface KorisnikService {
    Korisnik findOne(Long id);
    Korisnik getByUsername(String username);
    Korisnik save(Korisnik korisnik) throws Exception;
}
