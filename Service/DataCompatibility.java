package Service;

public abstract class DataCompatibility {
    protected String id;
    protected String type;
    
    public abstract String getRawData();
    public abstract String getId();
    public abstract String getType();
}
