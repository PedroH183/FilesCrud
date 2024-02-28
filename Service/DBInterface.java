package Service;

import java.io.IOException;
import java.util.List;

public interface DBInterface {
  /**
   * Interface com os métodos que o banco de dados deverá conter.
   * 
   * Esses métodos são essenciais para que o banco de dados da cadeira funcione 
   * de forma parecida com aos banco reais.
   */

  <T extends DataCompatibility> Boolean insertData(T DataInstance) throws IOException;
  <T extends DataCompatibility> List<T> getAll() throws IOException;

  Boolean viewData(String id) throws IOException;
  Boolean updateData(String id);
  Boolean deleteData(String id);
}
