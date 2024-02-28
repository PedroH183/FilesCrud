import Service.DBManager;
import Service.DataCompatibility;

import java.util.List;
import java.util.Vector;
import java.io.IOException;


public class WorkWithFiles {

 public static void main(String[] args) throws IOException{
  DBManager cursor = DBManager.getInstance();
  //Product product = new Product("Carro de Controle");

 //cursor.insertData( product );

  //List<Product> list_product = cursor.getAll();

  //for( Product prod : list_product ){
  //  prod.soutData();
  //}
  cursor.viewAll();
 }
}
