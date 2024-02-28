import Service.DBManager;

import java.io.IOException;

import Domain.Employee;


public class WorkWithFiles {

 public static void main(String[] args) throws IOException{
  DBManager cursor = DBManager.getInstance();
  Employee employee = new Employee("1", "Pedro Leandro", "Av. 13 de Maio", "R$1500.00", "03/05/2003");

 cursor.insertData(employee);

  //cursor.viewAll();
  cursor.viewData("1");
 }
}
