package com.registerService.registerservice.Service.ServiceImpl;

import com.registerService.registerservice.Model.Korisnik;
import com.registerService.registerservice.Repository.KorisnikRepository;
import com.registerService.registerservice.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository){
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Korisnik findOne(Long id) {
        return null;
    }

    @Override
    public Korisnik getByUsername(String username){
        Korisnik korisnik = this.korisnikRepository.findByUsername(username);
        return korisnik;
    }

    @Override
    public Korisnik save(Korisnik korisnik) throws Exception {
        if(korisnik.getId() != null){
            throw new Exception("ID and username must be unique");
        }
        Korisnik nkorisnik = korisnikRepository.save(korisnik);
        return nkorisnik;
    }


}
