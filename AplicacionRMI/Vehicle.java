package AplicacionRMI;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "vehicles")
public class Vehicle {
    @DatabaseField(unique = true)
    private String plate;
    @DatabaseField
    private String brand;
    @DatabaseField
    private String model;
    @DatabaseField
    private String color;
    @DatabaseField
    private String year;
    @DatabaseField
    private String owner;
    @DatabaseField
    private String rut;
    // add person object field
    @DatabaseField
    private Person person;
    @DatabaseField
    private boolean wasStolen;

    public Vehicle() {

    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    // add getter and setter for person object
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isWasStolen() {
        return wasStolen;
    }

    public void setWasStolen(boolean wasStolen) {
        this.wasStolen = wasStolen;
    }
}
