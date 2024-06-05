package AplicacionRMI;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "persons")
public class Person {
    @DatabaseField(id = true)
    private String rut;
    @DatabaseField
    private String name;
    @DatabaseField
    private String lastName;
    @DatabaseField

    public Person() {

    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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
}
