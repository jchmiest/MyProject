package pl.sda.carmanager.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="fuel_table")
public class FuelEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="counter") // wszystkie moga miec name
    private Integer counter;
    @Column(name="litre")
    private Integer litre;
    @Column(name="date")
    private LocalDate date;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="cost")
    private BigDecimal cost;

    public FuelEntity() {
    }

    public Integer getId() { //brakowalo set i get i nie ustawial danych
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getLitre() {
        return litre;
    }

    public void setLitre(Integer litre) {
        this.litre = litre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
