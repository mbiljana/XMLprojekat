package com.registerService.registerservice.Controller;


import com.registerService.registerservice.Model.DTO.KorisnikDTO;
import com.registerService.registerservice.Model.Korisnik;
import com.registerService.registerservice.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/korisnik") //proveriti koji standard traze
public class KorisnikController {
    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService){
        this.korisnikService = korisnikService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> createUser(@RequestBody KorisnikDTO DTO) throws Exception{
        Korisnik existing = this.korisnikService.getByUsername(DTO.getUsername());
        //ako postoji vec takav username
        if(existing != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            Korisnik korisnik = new Korisnik();
            korisnik.setName(DTO.getName());
            korisnik.setSurname(DTO.getSurname());
            korisnik.setBirthDate(DTO.getBirthDate());
            korisnik.setGender(DTO.getGender());
            korisnik.setEmailAddress(DTO.getEmailAddress());
            korisnik.setUsername(DTO.getUsername());
            korisnik.setPassword(DTO.getPassword());
            korisnik.setPhoneNumber(DTO.getPhoneNumber());
            Korisnik newKorisnik = this.korisnikService.save(korisnik);

            KorisnikDTO korisnikDTO = new KorisnikDTO( newKorisnik.getName(),newKorisnik.getSurname(), newKorisnik.getEmailAddress(), newKorisnik.getPhoneNumber(),newKorisnik.getBirthDate(),newKorisnik.getUsername(),newKorisnik.getPassword(), newKorisnik.getGender());
            return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
        }
    }

}
