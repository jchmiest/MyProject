package pl.sda.carmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.carmanager.entity.CarEntity;

@Repository //zapisywanie do bazy dancyh
public interface CarRepository extends JpaRepository<CarEntity,Integer> {
    //extends JPA bo ma wbudowane funkcje itp
}
