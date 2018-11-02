import java.text.SimpleDateFormat;
import java.util.Date;

public class TemperatureSensor {

    private String timestamp;
    private Double temperature;

    public TemperatureSensor(String timestamp, Double temperature) {
        this.timestamp = timestamp;
        this.temperature = temperature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}