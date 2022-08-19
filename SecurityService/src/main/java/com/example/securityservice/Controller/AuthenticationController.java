package com.example.securityservice.Controller;
import javax.servlet.http.HttpServletResponse;

import com.example.securityservice.Dto.AuthenticatedUserDTO;
import com.example.securityservice.Dto.JwtAuthenticationRequest;
import com.example.securityservice.Dto.UserRequest;
import com.example.securityservice.Dto.UserTokenState;
import com.example.securityservice.Service.UserService;
import com.example.securityservice.exception.ResourceConflictException;
import com.example.securityservice.util.TokenUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import com.example.securityservice.Model.User;


//kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    private final TokenUtils tokenUtils;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Autowired
    public AuthenticationController(TokenUtils tokenUtils, UserService userService , AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
        this.tokenUtils = tokenUtils;
        this.userService = userService;
    }




    // Prvi endpoint koji pogadja korisnik kada se loguje.
    // Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
    /*@PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

        // Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
        // AuthenticationException
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getKorisnicko(), authenticationRequest.getPassword()));

        // Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
        // kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getKorisnicko());
        int expiresIn = tokenUtils.getExpiredIn();

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }*/
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

		 AuthenticatedUserDTO authenticatedUserDTO = new AuthenticatedUserDTO();
	        User u = userService.findByKorisnicko(authenticationRequest.getKorisnicko());
	      
	        if(u!=null){
	           
	                Authentication authentication = authenticationManager
	                        .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getKorisnicko(),
	                                authenticationRequest.getPassword()));

	                SecurityContext ctx = SecurityContextHolder.createEmptyContext();
	                SecurityContextHolder.setContext(ctx);
	                SecurityContextHolder.getContext().setAuthentication(authentication);

	                User user = (User) authentication.getPrincipal();
	                String jwt = tokenUtils.generateToken(user.getUsername());
	                int expiresIn = tokenUtils.getExpiredIn();
	                authenticatedUserDTO = new AuthenticatedUserDTO(user.getId(), user.getRoleType(), user.getUsername(), new UserTokenState(jwt, expiresIn));
	                return new ResponseEntity<>(authenticatedUserDTO, HttpStatus.OK);}
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
	}

    // Endpoint za registraciju novog korisnika
    @PostMapping("/signup")
    public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest, UriComponentsBuilder ucBuilder) {

        User existUser = this.userService.findByKorisnicko(userRequest.getKorisnicko());

        if (existUser != null) {
            throw new ResourceConflictException(userRequest.getId(), "Username already exists");
        }

        User user = this.userService.save(userRequest);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
