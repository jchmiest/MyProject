package pl.sda.carmanager.web;



import java.math.BigDecimal;
import java.time.LocalDate;

public class RegistryEntry {
    private Integer id;
    private Integer counter;
    private Integer litre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private LocalDate date;
    private BigDecimal price;

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

    public Integer getDifference() {
        return difference;
    }

    public void setDifference(Integer difference) {
        this.difference = difference;
    }

    private BigDecimal cost;
    private Integer difference;
}
