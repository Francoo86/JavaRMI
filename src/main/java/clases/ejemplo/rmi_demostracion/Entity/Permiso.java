package clases.ejemplo.rmi_demostracion.Entity;

import javax.persistence.*;
@Entity
@Table(name = "Permisos")
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "Patente", nullable = false, length = 15)
    private String patent;

    @Column(name = "Fecha_Limite", nullable = false, length = 15)
    private String dueDate;

    @Column(name = "Permiso_Valido")
    private boolean validPermiso;

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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isValido() {
        return validPermiso;
    }

    public void setIsValido(boolean isValido) {
        this.validPermiso = isValido;
    }

}
