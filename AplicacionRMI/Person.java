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
    private String phone;
    @DatabaseField
    private String email;
    //even if we have email or phone those are placeholders for the future

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
