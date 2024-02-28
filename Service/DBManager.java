package Service;

import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Vector;


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
  private static Path fileInstance;
  private final String URL_PATH = "./Database/";
  private final String FILE_NAME = "DATABASE_DATA.txt";
  private final Vector<DataCompatibility> DATA_ALL = new Vector<DataCompatibility>(); 

  private DBManager() throws IOException{

    Path directory = Path.of(URL_PATH);

    if( !Files.exists(directory) ){
      Files.createDirectories(directory);
      System.out.println("Creating Directory");
    }

    String uriConnectToFile = this.getPathFile();
    Path file = Path.of(uriConnectToFile);

    if( !Files.exists(file) ){
      Files.createFile(file);
      System.out.println("Creating File");
    }
    fileInstance = file;

    // Alimentando o arrayList que conterá todos os dados salvos.
    List<String> linhas = Files.readAllLines(file);

  for (String linha : linhas) {
    
    // TODO
    // switch case com os type cases e os construtores em cada caso
    //  this.DATA_ALL.add( new Product(linha) );
    }
  }

  private String getPathFile(){
    return this.URL_PATH + this.FILE_NAME;
  }

  private Path getFileInstance(){
    return fileInstance;
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

     // inserting data...
     Files.writeString(pathManager, (rawDataInstance + "\n"), StandardOpenOption.APPEND);

    return true;
  }

  @Override
  public List getAll() throws IOException {
    return this.DATA_ALL;
  }

  public void viewAll() throws IOException {
    List<DataCompatibility> allData = this.getAll();

    allData.forEach((e) -> System.out.println(e.getRawData()));
  }

  @Override
  public Boolean viewData(String id) throws IOException {
      Vector lista = (Vector) this.getAll();

      for(int i = 0; i< lista.size(); i++) {
        //if(lista.get(i).get) {

        //}
      }

      return true;
  }

  @Override
  public Boolean updateData(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateData'");
  }

  @Override
  public Boolean deleteData(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteData'");
  }
}
