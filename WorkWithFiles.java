import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import DBManager.DBManager;
import Domain.Employee;
import Domain.Vehicle;


public class WorkWithFiles {

  public static void main(String[] args) throws IOException {
    Menu menu = new Menu();
    DBManager cursor = DBManager.getInstance();

    while(true) {
      Scanner s = new Scanner(System.in);
      menu.showOptions();
      String option = menu.setScanner("\nChoose an option: ", s);
      System.out.print("\n");

      switch(option) {
        case "1":
          menu.showEmployeeOptions();
          option = menu.setScanner("\nChoose an option: ", s);

          String idEmployee;

          switch (option) {
            case "1":
              // creating employee
              String id, name, address, wage, birthDate;
              id = menu.setScanner("Id: ", s);
              name = menu.setScanner("Name: ", s);
              address = menu.setScanner("Address: ", s);
              wage = menu.setScanner("Wage: ", s);
              birthDate = menu.setScanner("Birth Date: ", s);

              Employee employee = new Employee(id, name, address, wage, birthDate);
              cursor.insertData(employee);
              System.out.print("\n");
              break;

            case "2":
              // Read all employees
              cursor.viewAll("Employee");
              System.out.print("\n");
              break;

            case "3":
              // Search employees
              idEmployee = menu.setScanner("Type the employee id to search: ", s);
              cursor.viewEmployee(idEmployee);
              System.out.print("\n");
              break;

            case "4":
              // Edit employee
              idEmployee = menu.setScanner("Type the employee id to edit: ", s);
              HashMap<String, String> menuData = menu.menuUpdateEmployee(s);

              cursor.updateData(idEmployee, menuData);
              System.out.print("\n");
              break;

            case "5":
              // removing employee
              idEmployee = menu.setScanner("Type the employee id to remove: ", s);;
              cursor.deleteData(idEmployee);
              System.out.print("\n");
              break;

            case "6":
              break;
          }
          break;
        case "2":
          menu.showVehicleOptions();
          option = menu.setScanner("\nChoose an option: ", s);

          switch (option) {
            case "1":
              // creating vehicle
              String id, employeeId, description, plate, brand, model;
              id = menu.setScanner("\nId: ", s);
              employeeId = menu.setScanner("Employee Id: ", s);
              description = menu.setScanner("Description: ", s);
              plate = menu.setScanner("Plate: ", s);
              brand = menu.setScanner("Brand: ", s);
              model = menu.setScanner("Model: ", s);

              Vehicle vehicle = new Vehicle(id, employeeId, description, plate, brand, model);
              cursor.insertData(vehicle);
              System.out.print("\n");
              break;

            case "2":
              // listing all vehicle
              cursor.viewAll("Vehicle");
              break;

            case "3":
              // view vehicle
              idEmployee = menu.setScanner("Type the vehicle id to search: ", s);
              cursor.viewVehicle(idEmployee);
              System.out.print("\n");
              break;

            case "4":
              // Edit vehicle
              idEmployee = menu.setScanner("Type the vehicle id to edit: ", s);
              HashMap<String, String> menuData = menu.menuUpdateVehicle(s);

              cursor.updateData(idEmployee, menuData);
              break;

            case "5":
              // removing vehicle
              idEmployee = menu.setScanner("Type the vehicle id to remove: ", s);;
              cursor.deleteData(idEmployee);
              break;
            case "6":
              break;
          }
          break;
        case "3":
          return;
        default:
          System.out.println("Not an option");
          break;
      }
    }
  }
}
