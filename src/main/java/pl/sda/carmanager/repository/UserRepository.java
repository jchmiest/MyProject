package pl.sda.carmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.carmanager.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByMail(String mail);
    //przefiltruj po mailu uzytkownikow
}
