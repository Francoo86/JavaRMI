package clases.ejemplo.rmi_demostracion.models;

import javax.persistence.*;
@Entity
@Table(name = "Vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Patente", nullable = false, length = 15)
    private String patente;

    @Column(name = "Marca", nullable = false)
    private String marca;

    @Column(name = "Modelo", nullable = false)
    private String modelo;

    @Column(name = "Anio", nullable = false)
    private int anio;

    @Column(name = "Robo")
    private boolean robo;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isRobo() {
        return robo;
    }

    public void setRobo(boolean robo) {
        this.robo = robo;
    }
}
