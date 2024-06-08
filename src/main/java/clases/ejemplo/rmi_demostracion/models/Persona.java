package clases.ejemplo.rmi_demostracion.models;

import javax.persistence.*;
@Entity
@Table(name = "Personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nombre", nullable = false, length = 255)
    private String name;

    @Column(name = "Apellido", nullable = false, length = 255)
    private String lastName;

    @Column(name = "RUT", nullable = false, length = 15)
    private int rut;

    @Column(name = "DV", nullable = false, length = 1)
    private char dv;

    @Column(name = "Nacionalidad", length = 100)
    private String nationality;

    @Column(name = "Is_Arraigo")
    private boolean hasArraigo;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean hasArraigo() {

        return hasArraigo;
    }

    public void setHasArraigo(boolean hasArraigo) {
        this.hasArraigo = hasArraigo;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }
}
