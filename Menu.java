import java.util.HashMap;
import java.util.Scanner;

public class Menu{

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

    public String setScanner(String message, Scanner sc){
        System.out.println(message);
        String option = sc.nextLine();
        System.out.println();
        return option;
    }

    public HashMap<String, String> menuUpdateEmployee(Scanner sc){
        HashMap<String, String> menuData = new HashMap<>();
        menuData.put("name", this.setScanner("Insert new Name *Enter to skip*", sc));
        menuData.put("address", this.setScanner("Insert new Address *Enter to skip*", sc));
        menuData.put("wage", this.setScanner("Insert new Wage *Enter to skip*", sc));
        menuData.put("birthDate", this.setScanner("Insert new BirthDate *Enter to skip*", sc));

        return menuData;
    }

    public HashMap<String, String> menuUpdateVehicle(Scanner sc){
        HashMap<String, String> menuData = new HashMap<>();
        menuData.put("description", this.setScanner("Insert new Description *Enter to skip*", sc));
        menuData.put("plate", this.setScanner("Insert new Plate *Enter to skip*", sc));
        menuData.put("brand", this.setScanner("Insert new Brand *Enter to skip*", sc));
        menuData.put("model", this.setScanner("Insert new Model *Enter to skip*", sc));

        return menuData;
    }
}
