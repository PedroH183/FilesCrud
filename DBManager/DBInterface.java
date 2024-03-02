package DBManager;

import java.util.List;
import java.util.HashMap;
import java.io.IOException;


public interface DBInterface {

    void viewEmployee(String s);
    void viewVehicle(String s);
    void deleteData(String s);

    List<DataCompatibility> getAll() throws IOException;
    void updateEmployee(String employeeId, HashMap<String,String> hashMap);
    void updateVehicle(String vehicleId, HashMap<String,String> hashMap);

    <T extends DataCompatibility> void insertData(T t) throws IOException;
}
