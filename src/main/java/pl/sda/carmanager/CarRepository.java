package pl.sda.carmanager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //zapisywanie do bazy dancyh
public interface CarRepository extends JpaRepository<CarEntity,Integer> {
    //extends JPA bo ma wbudowane funkcje itp
}
