package com.example.securityservice.Service.impl;

import com.example.securityservice.Dto.UserRequest;
import com.example.securityservice.Model.Role;
import com.example.securityservice.Repository.UserRepository;
import com.example.securityservice.Service.RoleService;
import com.example.securityservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securityservice.Model.User;
import org.springframework.security.access.AccessDeniedException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder, RoleService roleService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User findByKorisnicko(String username) throws UsernameNotFoundException {
        return userRepository.findByKorisnicko(username);
    }

    public User findById(Long id) throws AccessDeniedException {
        return userRepository.findById(id).get();
    }

    public List<User> findAll() throws AccessDeniedException {
        return userRepository.findAll();
    }

    @Override
    public User save(UserRequest userRequest) {
        User u = new User();
        Long last_id=(long)0;
        List<User> allUsers = this.userRepository.findAll();
        for(User us : allUsers){
            last_id  =us.getId();
        }
        last_id = last_id+1;
        u.setId(last_id);
        u.setKorisnicko(userRequest.getKorisnicko());
        u.setProfilePicture(userRequest.getProfilePicture());

        // pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
        // treba voditi racuna da se koristi isi password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
        u.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        u.setFirstName(userRequest.getFirstname());
        u.setLastName(userRequest.getLastname());
        u.setEnabled(true);
        u.setEmail(userRequest.getEmail());
        u.setGender(userRequest.getGender());
        //novo
        u.setMobile(userRequest.getMobile());
        u.setDateOfBirth(userRequest.getDateOfBirth());
        // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
        List<Role> roles = roleService.findByName("ROLE_USER");
        u.setRoles(roles);
        u.setRoleType("User");

        return this.userRepository.save(u);
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }


}
