package DBManager;

import java.util.UUID;


public abstract class DataCompatibility {
    protected String id;
    protected String type;

    public abstract String getRawData();
    public abstract String getId();
    public abstract String getType();

    public static String generateRandomId(){
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }
}