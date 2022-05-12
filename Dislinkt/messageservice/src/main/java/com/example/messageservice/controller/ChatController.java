package com.example.messageservice.controller;

import com.example.messageservice.model.DTO.SendMessageDTO;
import com.example.messageservice.service.ChatService;
import com.example.messageservice.service.MessageService;
import com.example.messageservice.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/chats")
public class ChatController {
    private final ProfileService profileService;
    private final MessageService messageService;
    private final ChatService chatService;

    @Autowired
    public ChatController(ProfileService profileService, MessageService messageService,ChatService chatService) {
        this.chatService = chatService;
        this.messageService = messageService;
        this.profileService = profileService;
    }


    /*
    @PostMapping(value = ("/kreiranje"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Termin> kreiranje(@RequestBody KreiranjeTerminaDTO kDTO) throws Exception {
       Trener trener =  trenerService.findOne(kDTO.getKorisnik());
        Trening trening = treningService.findOne(kDTO.getTrening());
        Termin noviTermin = new Termin(kDTO.getCena(), kDTO.getDatumPocetka(), trening,
                trener.getFitnesCentar());
        Termin t = terminService.create(noviTermin);

        return new ResponseEntity<>(noviTermin, HttpStatus.CREATED);

    }
     */


}
