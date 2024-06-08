package clases.ejemplo.rmi_demostracion.Entity;

import javax.persistence.*;
@Entity
@Table(name = "Vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Patente", nullable = false, length = 6, unique = true)
    private String patent;

    @Column(name = "Marca", nullable = false)
    private String brand;

    @Column(name = "Modelo", nullable = false)
    private String model;

    @Column(name = "Anio", nullable = false)
    private int year;

    @Column(name = "Robo")
    private boolean isRobado;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isRobado() {
        return isRobado;
    }

    public void setRobado(boolean robado) {
        this.isRobado = robado;
    }
}
