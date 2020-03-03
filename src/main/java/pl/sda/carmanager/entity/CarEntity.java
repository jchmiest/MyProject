package pl.sda.carmanager.entity;

import javax.persistence.*;

@Entity
@Table(name="car_table")
public class CarEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;

    public CarEntity() { //konstruktos bezargumentowy
    }

    public CarEntity(String name){ //konstruktor
        this.name=name;
    }


    public Integer getId() { //gettery
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) { //settery
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override //toString
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
