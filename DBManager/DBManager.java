package DBManager;

import java.util.List;
import java.util.HashMap;
import java.util.Vector;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import Domain.Employee;
import Domain.Vehicle;


public class DBManager implements DBInterface {

  private static DBManager instance;
  private final String URL_PATH = "./Database/";
  private final String FILE_NAME = "DATABASE_DATA.txt";
  private final Vector<DataCompatibility> DATA_ALL = new Vector<DataCompatibility>(); 

  private DBManager() throws IOException{
    Path file = FileManager.getDatabase(URL_PATH, FILE_NAME);
    List<String> linhas = Files.readAllLines(file);

    for (String linha : linhas) {
      String[] fields = linha.split(":");

      switch (fields[0]) {
        case "Employee":
          this.DATA_ALL.add(new Employee(fields[1], fields[2], fields[3], fields[4], fields[5]));
          break;

        case "Vehicle":
          this.DATA_ALL.add(new Vehicle(fields[1], fields[2], fields[3], fields[4], fields[5], fields[6]));
          break;
      }
    }
}

  private String getPathFile(){
    return this.URL_PATH + this.FILE_NAME;
  }

  private Path getFileInstance(){
    return Path.of(this.getPathFile());
  }

  public static DBManager getInstance() throws IOException{
    if( instance == null ){
      instance = new DBManager();
    }
    return instance;
  }

  @Override
  public <TY extends DataCompatibility> void insertData(TY DataInstance) throws IOException {
    Path pathManager = this.getFileInstance();
    String rawDataInstance = DataInstance.getRawData();

    this.DATA_ALL.add(DataInstance);
    Files.writeString(pathManager, (rawDataInstance + "\n"), StandardOpenOption.APPEND);
  }

  @Override
  public List<DataCompatibility> getAll() {
    return this.DATA_ALL;
  }

  public List<DataCompatibility> getEmployeeList() {
    List<DataCompatibility> employeeList = new Vector<>();

    for (int index = 0; index < this.DATA_ALL.size(); index++) {
      if(this.DATA_ALL.get(index).getType().equals("Employee")) {
        employeeList.add(this.DATA_ALL.get(index));
      }
    }

    return employeeList;
  }

  public List<DataCompatibility> getVehicleList() {
    List<DataCompatibility> vehicleList = new Vector<>();

    for (int index = 0; index < this.DATA_ALL.size(); index++) {
      if(this.DATA_ALL.get(index).getType().equals("Vehicle")) {
        vehicleList.add(this.DATA_ALL.get(index));
      }
    }

    return vehicleList;
  }

  public DataCompatibility getOneEmployee(String id) {
    List<DataCompatibility> employeeList = this.getEmployeeList();

    for (int i = 0; i < employeeList.size(); i++) {
      if(employeeList.get(i).getId().equals(id)) {
        return employeeList.get(i);
      }
    }

    return null;
  }

  public DataCompatibility getOneVehicle(String id) {
    List<DataCompatibility> vehicleList = this.getVehicleList();

    for (int i = 0; i < vehicleList.size(); i++) {
      if(vehicleList.get(i).getId().equals(id)) {
        return vehicleList.get(i);
      }
    }

    return null;
  }
 
  public void viewAll(String type) {
    switch (type) {
      case "Employee":
        this.getEmployeeList().forEach(e -> {this.viewEmployee(e.getId()); System.out.println();} );
        break;

      case "Vehicle":
        this.getVehicleList().forEach(e -> {this.viewVehicle(e.getId()); System.out.println();} );
        break;

      default:
        System.out.println("Not a valid option!");
        break;
    }
  }

  public void viewEmployee(String id) {
    Employee employee = (Employee) this.getOneEmployee(id);

    if( employee == null ){
      System.out.println("Employee not found !!");
      return;
    }

    System.out.println("id: " + employee.getId());
    System.out.println("name: " + employee.getName());
    System.out.println("address: " + employee.getAddress());
    System.out.println("wage: " + employee.getWage());
    System.out.println("birth date: " + employee.getBirthDate());
  }

  public void viewVehicle(String id) {
    Vehicle vehicle = (Vehicle) this.getOneVehicle(id);

    if( vehicle == null ){
      System.out.println("Vehicle not found !!");
      return;
    }

    System.out.println("id:" + vehicle.getId());
    System.out.println("employee id:" + vehicle.getEmployeeId());
    System.out.println("description:" + vehicle.getDescription());
    System.out.println("plate:" + vehicle.getPlate());
    System.out.println("brand:" + vehicle.getBrand());
    System.out.println("model:" + vehicle.getModel());
  }

  @Override
  public void updateEmployee(String employeeId, HashMap<String, String> hashMap) {

    Employee employee = (Employee) this.getOneEmployee(employeeId);

    hashMap.forEach( (key, value) -> {
      if( value.isBlank() ){
        return;
      }
      if( key.equals("name")  ){
        employee.setName(value);
        return;
      }
      if( key.equals("address") ){
        employee.setAddress(value);
        return;
      }
      if( key.equals("wage") ){
        employee.setWage(value);
        return;
      }
      if( key.equals("birthDate") ){
        employee.setBirthDate(value);
      }
    });

    FileManager.recreateDatabase(this.getPathFile(), this.getAll());
  }

  @Override
  public void updateVehicle(String vehicleId, HashMap<String, String> hashMap) {

    Vehicle vehicle = (Vehicle) this.getOneVehicle(vehicleId);

    hashMap.forEach( (key, value) -> {
      if( value.isBlank() ){
        return;
      }
      if( key.equals("description")  ){
        vehicle.setDescription(value);
        return;
      }
      if( key.equals("plate") ){
        vehicle.setPlate(value);
        return;
      }
      if( key.equals("brand") ){
        vehicle.setBrand(value);
        return;
      }
      if( key.equals("model") ){
        vehicle.setModel(value);
      }
    });

    FileManager.recreateDatabase(this.getPathFile(), this.getAll());
  }

  @Override
  public void deleteData(String id) {
    List<DataCompatibility> allData = new Vector<>();
    allData = this.getAll();

    for (int i = 0; i < allData.size(); i++) {
     if(allData.get(i).getId().equals(id)) {
      this.DATA_ALL.remove(i);
     } 
    }

    FileManager.recreateDatabase(this.getPathFile(), this.getAll());
  }

}