package Domain;


import DBManager.DataCompatibility;


public class Employee extends DataCompatibility {
   private String id;
   private String name;
   private String address;
   private String wage;
   private String birthDate;
   private final String type = "Employee";


   public Employee(String id, String name, String address, String wage, String birthDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.wage = wage;
        this.birthDate = birthDate;
   }

   public Employee() {
        this.id = null;
        this.name = null;
        this.address = null;
        this.wage = null;
        this.birthDate = null;
   }

    @Override
    public String getRawData() {
        return new String(this.type + ":" + this.id + ":" + this.name + ":" + this.address + ":" + this.wage + ":" + this.birthDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getType() {
        return this.type;
    }
}
