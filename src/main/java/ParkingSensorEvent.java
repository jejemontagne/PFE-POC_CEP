/**
 * Created by Jerome on 22/01/2015.
 */
public class ParkingSensorEvent {
    public String value;
    public String name;
    public String timeStamp;

    public ParkingSensorEvent(String value, String name, String timeStamp) {
        this.value = value;
        this.name = name;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ParkingSensorEvent{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}