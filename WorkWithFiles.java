import Domain.DBManager;
import Service.Product;

import java.io.IOException;

public class WorkWithFiles {

 public static void main(String[] args) throws IOException{
  DBManager cursor = DBManager.getInstance();
  Product product = new Product("Carro de Controle", 5000);

  cursor.insertData( product );
 }
}
