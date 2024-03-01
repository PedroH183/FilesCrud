package DBManager;

import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.xml.crypto.Data;

import Domain.Employee;
import Domain.Vehicle;
import Service.DataCompatibility;


public class DBManager implements DBInterface {
  /**
   * Classe que representa a interface do banco de dados,
   * por meio desta classe será possível acessar os recursos salvos no banco de dado.
   *
   *  instance :: é a representação da instancia dessa classe
   *  é por meio de instance que o usuario irá interagir com o banco.
   *
   *  fileInstance :: é a representação do path que contém todos os dados da aplicação.
   */

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
  public <TY extends DataCompatibility> Boolean insertData(TY DataInstance) throws IOException {
    Path pathManager = this.getFileInstance();
    String rawDataInstance = DataInstance.getRawData();

    this.DATA_ALL.add(DataInstance);
    Files.writeString(pathManager, (rawDataInstance + "\n"), StandardOpenOption.APPEND);

    return true;
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
  
  public void viewAll(String type) throws IOException {
    //Recebe o tipo, veiculo ou funcionario
    //percorre linha por linha o arquivo e verifica se a primeira palavra corresponde ao tipo escolhido
    //se sim, guarda a linha em um array
    //no final retorna um array com todas as linhas deste tipo 

    // List<String> linhas = Files.readAllLines(file);

    // for (String linha : linhas) {
    //   String[] fields1 = linha.split(":");
    //   ArrayList<String> fields = new ArrayList<>();

    //   for (int i = 0; i < fields1.length; i++) {
    //     fields.add(fields1[i]);
    //   }

    

    // switch (fields.get(0)) {
    //   case "Employee":
    //     this.DATA_ALL.add(new Employee(fields.get(1), fields.get(2), fields.get(3), fields.get(4), fields.get(5)));
    //     break;

    //   case "Vehicle":
    //     this.DATA_ALL.add(new Vehicle(fields.get(1), fields.get(2), fields.get(3), fields.get(4), fields.get(5), fields.get(6)));
    //     break;

    //   default:
    //     break;
    // }

    List<DataCompatibility> allData = this.getAll();

    allData.forEach((e) -> System.out.println(e.getRawData()));
  }

  @Override
  public Boolean viewData(String id) throws IOException {
      // TODO
      // Usar getOneVehicle e getOneEmployee e quebrar esse metodo em dois tambem
      // Considerar deletar esse metodo dependendo da logica final
      List<DataCompatibility> lista = this.getAll();

      for(int i = 0; i< lista.size(); i++) {
        if(lista.get(i).getId().equals(id)) {
          System.out.println(lista.get(i).getRawData());
          return true;
        }
      }

      return false;
  }

  @Override
  public Boolean updateData(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateData'");
  }

  @Override
  public Boolean deleteData(String id) {
    List<DataCompatibility> allData = new Vector<>();
    allData = this.getAll();
    
    for (int i = 0; i < allData.size(); i++) {
     if(allData.get(i).getId().equals(id)) {
      this.DATA_ALL.remove(i);
     } 
    }

    FileManager.recreateDatabase(this.getPathFile(), this.getAll());
    return false;
  }

  public void updateField(String key, String value) {

  }

  public void showOptions() {
    System.out.println("---------- OPTIONS ----------");
    System.out.println("1 - Employee");
    System.out.println("2 - Vehicle");
    System.out.println("3 - Exit");
  }

  public void showEmployeeOptions() {
    System.out.println("---------- EMPLOYEES OPTIONS ----------");
    System.out.println("1 - Create Employee");
    System.out.println("2 - Read All Employees");
    System.out.println("3 - Search Employee");
    System.out.println("4 - Edit Employee");
    System.out.println("5 - Delete Employee");
    System.out.println("6 - Go back");
  }

  public void showVehicleOptions() {
    System.out.println("---------- VEHICLES OPTIONS ----------");
    System.out.println("1 - Create Vehicle");
    System.out.println("2 - Read All Vehicles");
    System.out.println("3 - Search Vehicle");
    System.out.println("4 - Edit Vehicle");
    System.out.println("5 - Delete Vehicle");
    System.out.println("6 - Go back");
  }
}