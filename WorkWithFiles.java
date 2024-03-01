import Service.DBManager;

import java.io.IOException;
import java.util.Scanner;

import Domain.Employee;
import Domain.Vehicle;

public class WorkWithFiles {

  public static void main(String[] args) throws IOException {
    DBManager cursor = DBManager.getInstance();
    String option;

    while(true) {
      Scanner s = new Scanner(System.in);
      cursor.showOptions();
      System.out.print("\nChoose an option: ");
      option = s.nextLine();
      System.out.print("\n");

      switch(option) {
        case "1":
          cursor.showEmployeeOptions();
          System.out.print("\nChoose an option: ");
          option = s.nextLine();
          System.out.print("\n");

          String idEmployee;

          switch (option) {
            case "1":
              String id, name, address, wage, birthDate;
              System.out.println("Id: ");
              id = s.nextLine();
              System.out.print("\n");

              System.out.println("Name: ");
              name = s.nextLine();
              System.out.print("\n");
              
              System.out.println("Address: ");
              address = s.nextLine();
              System.out.print("\n");
              
              System.out.println("Wage: ");
              wage = s.nextLine();
              System.out.print("\n");
              
              System.out.println("Birth Date: ");
              birthDate = s.nextLine();
              System.out.print("\n");

              Employee employee = new Employee(id, name, address, wage, birthDate);
              cursor.insertData(employee);
              break;
            case "2":
            //Ajustar para retornar separadamente e não todos os dados
              cursor.viewAll("Employee");
              System.out.print("\n");
              break;
            case "3":
              System.out.println("Type the employee id to search: ");
              idEmployee = s.nextLine();
              cursor.viewData(idEmployee);
              System.out.print("\n");
              break;
            case "4":
              //cursor.updateData(idEmployee);
              break;
            case "5":
              System.out.println("Type the employee id: ");
              idEmployee = s.nextLine();
              cursor.deleteData(idEmployee);
              System.out.print("\n");
              break;
            case "6":
              break;
            default:
              break;
          }
          break;
        case "2":
          cursor.showVehicleOptions();
          System.out.print("\nChoose an option: ");
          option = s.nextLine();
          
          switch (option) {
            case "1":
              String id, employeeId, description, plate, brand, model;

              System.out.println("Id: ");
              id = s.nextLine();
              System.out.print("\n");

              System.out.println("Employee Id: ");
              employeeId = s.nextLine();
              System.out.print("\n");

              System.out.println("Description: ");
              description = s.nextLine();
              System.out.print("\n");

              System.out.println("Plate: ");
              plate = s.nextLine();
              System.out.print("\n");

              System.out.println("Brand: ");
              brand = s.nextLine();
              System.out.print("\n");

              System.out.println("Model: ");
              model = s.nextLine();
              System.out.print("\n");

              Vehicle vehicle = new Vehicle(id, employeeId, description, plate, brand, model);
              cursor.insertData(vehicle);

              break;
            case "2":
              cursor.viewAll("Vehicle");
              System.out.print("\n");
              break;
            case "3":
            S ystem.out.println("Type the employee id to search: ");
              idEmployee = s.nextLine();
              cursor.viewData(idEmployee);
              System.out.print("\n");
              break;
            case "4":
              break;
            case "5":
              break;
            case "6":
              break;
            default:
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

//                case "3":
//                    //cursor.showEditOptions();
//                    System.out.print("> ");
//                    option = s.nextLine();
//
//                    switch (option) {
//                        case "1":
//                            //cursor.editBrandRecord();
//                            break;
//                        case "2":
//                            //cursor.editModelRecord();
//                            break;
//                        case "3":
//                            //cursor.editPlateRecord();
//                            break; 
//                        default:
//                            System.out.println("Not an option!");
//                            break;
//                    }
//                    break;
//                case "4":
//                    //cursor.deleteRecord();
//                    break;
//                case "5":
//                    System.out.println("Exit");
//                    s.close();
//                    return;