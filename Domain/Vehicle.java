package Domain;

import Service.DataCompatibility;

public class Vehicle extends DataCompatibility {
    private String id;
    private String employeeId;
    private String description;
    private String plate;
    private String brand;
    private String model;
    private final String type = "Vehicle";    

    public Vehicle(String id, String employeeId, String description, String plate, String brand, String model) {
        this.id = id;
        this.employeeId = employeeId;
        this.description = description;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
    }

    public Vehicle() {
        this.id = null;
        this.employeeId = null;
        this.description = null;
        this.plate = null;
        this.brand = null;
        this.model = null;
    }

    @Override
    public String getRawData() {
        return new String(this.type + ":" + this.id + ":" + this.employeeId + ":" + this.description + ":" + this.plate + ":" + this.brand + ":" + this.model);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getType() {
        return type;
    }
}