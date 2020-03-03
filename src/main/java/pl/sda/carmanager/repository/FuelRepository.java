package pl.sda.carmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.carmanager.entity.FuelEntity;
import java.math.BigDecimal;

@Repository //zapisywanie do bazy dancyh
public interface FuelRepository extends JpaRepository<FuelEntity,Integer> {


    @Query("SELECT SUM(fuel.cost) FROM FuelEntity fuel")
    //fuel alias ktorego bediemy uzywac,do ktorego bedziemy sie odnosic
    BigDecimal selectTotals();

    @Query("SELECT COUNT(fuel.id) FROM FuelEntity fuel")
    Integer selectCount();

    @Query("SELECT min (fuel.counter) FROM FuelEntity fuel")
    BigDecimal selectMin();

    @Query("SELECT max (fuel.counter) FROM FuelEntity fuel")
    BigDecimal selectMax();

    @Query("SELECT SUM(fuel.litre) FROM FuelEntity fuel") //suma zatankowanego paliwa
        //fuel alias ktorego bediemy uzywac,do ktorego bedziemy sie odnosic
    BigDecimal selectLitre();
}
