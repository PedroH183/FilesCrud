package DBManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public interface DBInterface {

    void viewEmployee(String s);
    void viewVehicle(String s);
    void deleteData(String s);

    List<Service.DataCompatibility> getAll() throws IOException;
    Boolean updateData(java.lang.String s, HashMap<String,String> hashMap);
    void updateEmployee(Domain.Employee employee, HashMap<String,String> hashMap);
    void updateVehicle(Domain.Vehicle vehicle, HashMap<String,String> hashMap);

    <T extends Service.DataCompatibility> void insertData(T t) throws IOException;
}
