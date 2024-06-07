package clases.ejemplo.rmi_demostracion.models;

import javax.persistence.*;
@Entity
@Table(name = "Permisos")
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Patente", nullable = false, length = 15)
    private String patente;

    @Column(name = "Fecha_vencimiento", nullable = false, length = 15)
    private String fecha_vencimiento;

    @Column(name = "Estado_permiso")
    private boolean estado_permiso;

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

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public boolean isValido() {
        return estado_permiso;
    }

    public void setValidez(boolean estado_permiso) {
        this.estado_permiso = estado_permiso;
    }

}
