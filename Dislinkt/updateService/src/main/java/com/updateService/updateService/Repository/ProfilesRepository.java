package com.updateService.updateService.Repository;

import com.updateService.updateService.Model.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilesRepository extends JpaRepository<Profiles, Long> {
    Profiles findByUsername(String username);

}
