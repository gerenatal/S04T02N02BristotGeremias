package cat.itacademy.barcelonactiva.bristot.geremias.s04.t02.n02.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name="Fruit")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 45)
    private String name;

    @Column(length = 8)
    private int quantityKilos;

    public Fruit(){}

    public Fruit(int id, String name, int quantityKilos) {
        this.id = id;
        this.name = name;
        this.quantityKilos = quantityKilos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKilos() {
        return quantityKilos;
    }

    public void setQuantityKilos(int quantityKilos) {
        this.quantityKilos = quantityKilos;
    }

    @Override
    public String toString() {
        return "Fruit " + name + ", with id " + id + ", weighting " + quantityKilos +" kg";
    }
}