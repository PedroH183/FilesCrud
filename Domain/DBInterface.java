package Domain;

import java.io.IOException;

public interface DBInterface {
  /**
   * Interface com os métodos que o banco de dados deverá conter.
   * 
   * Esses métodos são essenciais para que o banco de dados da cadeira funcione 
   * de forma parecida com aos banco reais.
   */

  <T extends DataCompatibility> Boolean insertData(T DataInstance) throws IOException;

  Boolean viewData(String id);
  Boolean updateData(String id);
  Boolean deleteData(String id);
}
