import Service.DBManager;

import java.io.IOException;
import java.util.Scanner;

import Domain.Employee;

public class WorkWithFiles {

  public static void main(String[] args) throws IOException {
    DBManager cursor = DBManager.getInstance();
    String option;

    while(true) {
      Scanner s = new Scanner(System.in);
      cursor.showOptions();
      System.out.print("> ");
      option = s.nextLine();

      switch(option) {
        case "1":
          cursor.showEmployeeOptions();
          System.out.print("> ");
          option = s.nextLine();

          switch (option) {
            case "1":
              String id, name, address, wage, birthDate;
              System.out.println("id: ");
              id = s.nextLine();
              System.out.println("name: ");
              name = s.nextLine();
              System.out.println("address: ");
              address = s.nextLine();
              System.out.println("wage: ");
              wage = s.nextLine();
              System.out.println("birthDate: ");
              birthDate = s.nextLine();

              Employee employee = new Employee(id, name, address, wage, birthDate);
              cursor.insertData(employee);
              break;
            case "2":
              cursor.viewAll();
              break;
            case "3":
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
        case "2":
          cursor.showVehicleOptions();
          System.out.print("> ");
          option = s.nextLine();
          
          switch (option) {
            case "1":
              break;
            case "2":
              break;
            case "3":
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